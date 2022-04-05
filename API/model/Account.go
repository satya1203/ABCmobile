package model

type Account struct {
	Id            int    `form:"id" json:"id"`
	User          User   `form:"user" json:"user"`
	Saldo         int    `form:"saldo" json:"saldo"`
	NomorKartu    string `form:"nomor_kartu" json:"nomor_kartu"`
	NomorRekening string `form:"nomor_rekening" json:"nomor_rekening"`
	KodeAkses     string `form:"kode_akses" json:"kode_akses"`
}

type AccountResponse struct {
	Message string    `form:"message" json:"message"`
	Data    []Account `form:"data" json:"data"`
}

type LoginResponse struct {
	Message string `form:"message" json:"message"`
}
