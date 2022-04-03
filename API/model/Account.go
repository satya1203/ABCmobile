package model

import "github.com/ABCmobile/API/model"
type Account struct {
	Id            int    `form:"id" json:"id"`
	User          model.User   `form:"user" json:"user"`
	Saldo         int    `form:"saldo" json:"saldo"`
	NomorKartu    string `form:"nomor_kartu" json:"nomor_kartu"`
	NomorRekening string `form:"nomor_rekening" json:"nomor_rekening"`
	KodeAkses     int    `form:"kodeakses" json:"kodeakses"`
}

type AccountResponse struct {
	Message string    `form:"message" json:"message"`
	Data    []Account `form:"data" json:"data"`
}

type LoginResponse struct {
	Message string `form:"message" json:"message"`
}
