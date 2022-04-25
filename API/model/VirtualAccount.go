package model

import "time"

type VirtualAccount struct {
	Id       int       `form:"id" json:"id"`
	Transfer Transfer  `form:"transaksi" json:"transaksi"`
	NoVA     string    `form:"nomor_va" json:"nomor_va"`
	Tagihan  int       `form:"tagihan" json:"tagihan"`
	Batas    time.Time `form:"batas" json:"batas"`
	Waktu    time.Time `form:"waktu" json:"waktu"`
	Status   int       `form:"status" json:"status"`
}

type VirtualAccountResponse struct {
	Message string             `form:"message" json:"message"`
	Data    []VirtualAccount `form:"data" json:"data"`
}
