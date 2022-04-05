package controller

import (
	"crypto/rand"
	"encoding/json"
	"errors"
	"fmt"
	"log"
	"strconv"
	"time"

	"github.com/ABCMobile/model"
	"github.com/gin-gonic/gin"
)

//Login
func Login(c *gin.Context) {
	db := connect()
	defer db.Close()

	var accountData model.Account
	err := json.NewDecoder(c.Request.Body).Decode(&accountData)

	if err != nil {
		log.Println(err)
	}

	query := "SELECT id, saldo, nomor_kartu, nomor_rekening, kode_akses FROM account WHERE nomor_kartu = '" + accountData.NomorKartu + "' AND kode_akses = '" + accountData.KodeAkses + "'"

	rows, err := db.Query(query)
	if err != nil {
		log.Println(err)
	}

	var account model.Account
	for rows.Next() {
		if err := rows.Scan(&account.Id, &account.Saldo, &account.NomorKartu, &account.NomorRekening, &account.KodeAkses); err != nil {
			log.Fatal(err.Error())
		}
	}

	var response model.LoginResponse
	if account.KodeAkses == accountData.KodeAkses {
		generateToken(c, account.Id, account.NomorKartu, account.NomorRekening)
		response.Message = "Login Success"
		sendLoginSuccessResponse(c, response)
	} else {
		response.Message = "Kode Akses Salah!"
		fmt.Print(err)
		sendLoginErrorResponse(c, response)
	}

}

//Logout
func Logout(c *gin.Context) {
	resetUserToken(c)
	var response model.UserResponse
	response.Message = "Logout Success"
	sendUserSuccessresponse(c, response)
}

//List Transfer
func GetTransfer(c *gin.Context) {
	db := connect()
	defer db.Close()

	query := "SELECT * FROM transfer"

	rows, err := db.Query(query)
	if err != nil {
		log.Println(err)
	}

	var transfer model.Transfer
	var transfers []model.Transfer

	for rows.Next() {
		if err := rows.Scan(&transfer.Id, &transfer.Jumlah, &transfer.Berita, &transfer.RekeningPengirim, &transfer.RekeningPenerima, &transfer.Waktu); err != nil {
			log.Fatal(err.Error())
		} else {
			transfers = append(transfers, transfer)
		}
	}

	var response model.TransferResponse
	if err == nil {
		response.Message = "Get Transfer Success"
		response.Data = transfers
		sendTransferSuccessresponse(c, response)
	} else {
		response.Message = "Get Transfer Error!"
		sendTransferErrorResponse(c, response)
		fmt.Print(err)
	}
}

// Info Account
func GetInfoAccount(c *gin.Context) {
	db := connect()
	defer db.Close()

	noKartu := c.Param("nomor_kartu")

	query := "SELECT a.saldo, a.nomor_rekening, u.nama FROM `account` a JOIN `user` u ON a.user_fk = u.id WHERE a.nomor_kartu='" + noKartu + "'"

	rows, err := db.Query(query)
	if err != nil {
		log.Println(err)
	}

	var account model.Account
	var accounts []model.Account

	for rows.Next() {
		if err := rows.Scan(&account.Saldo, &account.NomorRekening, &account.User.Nama); err != nil {
			log.Fatal(err.Error())
		} else {
			accounts = append(accounts, account)
		}
	}

	var response model.AccountResponse
	if err == nil {
		response.Message = "Get Account Success"
		response.Data = accounts
		sendAccountSuccessresponse(c, response)
	} else {
		response.Message = "Get Account Query Error"
		sendAccountErrorResponse(c, response)
		fmt.Print(err)
	}
}

// Insert Transfer Antar rekening
func InsertTransfer(c *gin.Context) {
	db := connect()
	defer db.Close()

	jumlah, _ := strconv.Atoi(c.PostForm("jumlah"))
	berita := c.PostForm("berita")
	rekeningPengirim := c.PostForm("rekening_pengirim")
	rekeningPenerima := c.PostForm("rekening_penerima")
	waktu := time.Now()

	//get saldo pengirim
	var saldoPengirim int
	saldoPengirim = GetSaldo(c, rekeningPengirim)
	//get saldo penerima
	var saldoPenerima int
	saldoPenerima = GetSaldo(c, rekeningPenerima)

	//cek saldo pengirim
	if saldoPengirim != 0 {
		//saldo pengirim berkurang
		UpdateSaldo(c, rekeningPengirim, saldoPengirim-jumlah)
		//saldo penerima bertambah
		UpdateSaldo(c, rekeningPenerima, saldoPenerima+jumlah)
	} else {
		println(errors.New("Saldo pengirim tidak cukup"))
	}

	//insert transfer
	_, errQuery := db.Exec("INSERT INTO transfer(jumlah, berita, rekening_pengirim, rekening_penerima, waktu) VALUES (?,?,?,?,?)",
		jumlah,
		berita,
		rekeningPengirim,
		rekeningPenerima,
		waktu,
	)

	var response model.TransferResponse
	if errQuery == nil {
		response.Message = "Insert Transfer Success"
		sendTransferSuccessresponse(c, response)
	} else {
		response.Message = "Insert Transfer Error"
		fmt.Print(errQuery)
		sendTransferErrorResponse(c, response)
	}
}

// Get Saldo untuk penambahan saldo transfer (sub func insert tranfer)
func GetSaldo(c *gin.Context, noRekening string) int {
	db := connect()
	defer db.Close()

	if noRekening == "" {
		noRekening = c.PostForm("nomor_rekening")
	}

	query := "SELECT saldo FROM `account` WHERE nomor_rekening='" + noRekening + "'"

	rows, err := db.Query(query)
	if err != nil {
		log.Println(err)
	}

	var account model.Account
	var accounts []model.Account

	for rows.Next() {
		if err := rows.Scan(&account.Saldo); err != nil {
			log.Fatal(err.Error())
		} else {
			accounts = append(accounts, account)
		}
	}

	var response model.AccountResponse
	if err == nil {
		response.Message = "Get Saldo Success"
		response.Data = accounts
	} else {
		response.Message = "Get Saldo Error"
		fmt.Print(err)
	}
	return account.Saldo
}

//Update Saldo berkurang atau bertambah (sub function insert transfer)
func UpdateSaldo(c *gin.Context, rekening string, saldo int) {
	db := connect()
	defer db.Close()

	_, errQuery := db.Exec("UPDATE account SET saldo = ? WHERE nomor_rekening=?",
		saldo,
		rekening,
	)

	var response model.AccountResponse
	if errQuery == nil {
		response.Message = "Update Saldo Success"
	} else {
		response.Message = "Update Saldo Error"
	}
}

//Insert Virtual Account
func InsertVirtualAccount(c *gin.Context) {
	db := connect()
	defer db.Close()

	var va model.NoVirtualAccount
	var account model.Account

	va.Transfer.RekeningPengirim = c.PostForm("rekening_pengirim")
	va.Transfer.RekeningPenerima = c.PostForm("rekening_penerima")
	fmt.Println(va.Transfer.RekeningPenerima)
	fmt.Println(va.Transfer.RekeningPengirim)

	//generate unique virtual account number
	noVA := "022" + va.Transfer.RekeningPengirim
	//tagihan ex: pembelian barang dari online shop
	tagihan := 100000

	//get saldo pengirim
	saldoPengirim := GetSaldo(c, va.Transfer.RekeningPengirim)
	//get saldo pengirim
	saldoPenerima := GetSaldo(c, va.Transfer.RekeningPenerima)
	Status := 0

	//cek saldo pengirim
	if account.Saldo <= tagihan {
		//saldo pengirim berkurang
		UpdateSaldo(c, va.Transfer.RekeningPengirim, saldoPengirim-tagihan)
		//saldo penerima bertambah
		UpdateSaldo(c, va.Transfer.RekeningPenerima, saldoPenerima+tagihan)
		Status = 1
	} else {
		println(errors.New("Saldo pengirim tidak cukup"))
	}

	//insert virtual account
	_, errQuery := db.Exec("INSERT INTO virtual_account(nomor_virtual_account,tagihan,batas,waktu,status) VALUES (?,?,?,?,?)",
		noVA,
		tagihan,
		time.Now().Add(10*time.Minute),
		time.Now(),
		Status,
	)

	var response model.TransferResponse
	if errQuery == nil {
		response.Message = "Insert Virtual Account Success"
		sendTransferSuccessresponse(c, response)
	} else {
		response.Message = "Insert Virtual Account Error"
		fmt.Print(errQuery)
		sendTransferErrorResponse(c, response)
	}
}

// generate unique string untuk nomor rekening & nomor kartu
func generateUnique() string {
	b := make([]byte, 5)
	if _, err := rand.Read(b); err != nil {
		panic(err)
	}
	return fmt.Sprintf("%X", b)
}

// Insert Rekening
func InsertRekening(c *gin.Context) {
	db := connect()
	defer db.Close()

	nama := c.PostForm("nama")
	ttl := c.PostForm("ttl")
	jenisKelamin := c.PostForm("jenis_kelamin")
	alamat := c.PostForm("alamat")
	agama := c.PostForm("agama")
	statusPerkawinan := c.PostForm("status_perkawinan")
	pekerjaan := c.PostForm("pekerjaan")
	kewarganegaraan := c.PostForm("kewarganegaraan")
	noHP := c.PostForm("no_hp")

	nomorKartu := generateUnique()
	nomorRekening := generateUnique()
	kodeakses := c.PostForm("kode_akses")

	//insert user
	_, errQuery := db.Exec("INSERT INTO user(nama,tempat_tanggal_lahir,jenis_kelamin,alamat,agama,status_kawin,pekerjaan,kewarganegaraan,no_hp) VALUES (?,?,?,?,?,?,?,?,?)",
		nama,
		ttl,
		jenisKelamin,
		alamat,
		agama,
		statusPerkawinan,
		pekerjaan,
		kewarganegaraan,
		noHP,
	)

	//insert rekening
	_, errQuery = db.Exec("INSERT INTO account(user_fk,saldo,nomor_kartu,nomor_rekening,kode_akses) VALUES ((SELECT id FROM user WHERE no_hp="+noHP+"),0,?,?,?)",
		nomorKartu,
		nomorRekening,
		kodeakses,
	)

	var response model.AccountResponse
	if errQuery == nil {
		response.Message = "Insert Rekening Success"
		sendAccountSuccessresponse(c, response)
	} else {
		response.Message = "Insert Rekening Failed Error"
		fmt.Print(errQuery)
		sendAccountErrorResponse(c, response)
	}
}

//Update Kode Akses
func UpdateKodeAkses(c *gin.Context) {
	db := connect()
	defer db.Close()

	nomorRekening := c.Param("nomor_rekening")
	kodeAkses := c.PostForm("kode_akses")

	_, errQuery := db.Exec("UPDATE account SET kode_akses = ? WHERE nomor_rekening=?",
		kodeAkses,
		nomorRekening,
	)

	var response model.AccountResponse
	if errQuery == nil {
		response.Message = "Update Kode Akses Success"
		sendAccountSuccessresponse(c, response)
	} else {
		response.Message = "Update Kode Akses Error"
		fmt.Print(errQuery)
		sendAccountErrorResponse(c, response)
	}
}
