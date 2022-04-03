package model

type User struct {
	Id              int    `form:"id" json:"id"`
	Nama            string `form:"nama" json:"nama"`
	TTL             string `form:"TTL" json:"TTL"`
	JniesKelamin             string `form:"jenis_kelamin" json:"jenis_kelamin"`
	Alamat          string `form:"alamat" json:"alamat"`
	Agama           string `form:"agama" json:"agama"`
	StatusKawin     int    `form:"status_kawin" json:"status_kawin"`
	Pekerjaan       string `form:"pekerjaan" json:"pekerjaan"`
	Kewarganegaraan string `form:"kewarganegaraan" json:"kewarganegaraan"`
	NoHP            string `form:"no_hp" json:"no_hp"`
}

type UserResponse struct {
	Message string `form:"message" json:"message"`
	Data    []User `form:"data" json:"data"`
}

