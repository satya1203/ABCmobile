package model

type NoVirtualAccount struct {
	Id        int      `form:"id" json:"id"`
	Transfer Transfer `form:"transaksi" json:"transaksi"`
	NoVA      string   `form:"nomor_va" json:"nomor_va"`
	Tagihan   string   `form:"tagihan" json:"tagihan"`
	batas     string   `form:"waktu" json:"waktu"`
	Waktu     string   `form:"waktu" json:"waktu"`
	Status    int      `form:"status" json:"status"`
}

type NoVirtualAccountResponse struct {
	Message string             `form:"message" json:"message"`
	Data    []NoVirtualAccount `form:"data" json:"data"`
}
