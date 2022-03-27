package model

type Transfer struct {
	Id               int    `form:"id" json:"id"`
	Jumlah           string `form:"jumlah" json:"jumlah"`
	Berita           string `form:"berita" json:"berita"`
	RekeningPengirim string `form:"rekening_penerima" json:"rekening_penerima"`
	RekeningPenerima string `form:"rekening_pengirim" json:"rekening_pengirim"`
	Waktu            string `form:"waktu" json:"waktu"`
}

type TransferResponse struct {
	Message string     `form:"message" json:"message"`
	Data    []Transfer `form:"data" json:"data"`
}
