package main

import (
	"fmt"
	"time"

	controllers "github.com/ABCMobile/controller"
	_ "github.com/go-sql-driver/mysql"

	"github.com/gin-contrib/cors"
	"github.com/gin-gonic/gin"
)

func main() {
	fmt.Println("ABCMobile API")

	router := gin.Default()

	router.Use(cors.New(cors.Config{
		AllowOrigins:     []string{"*"},
		AllowMethods:     []string{"GET", "POST", "PUT", "PATCH", "DELETE"},
		AllowHeaders:     []string{"*"},
		ExposeHeaders:    []string{"Content-Length"},
		AllowCredentials: true,
		AllowOriginFunc: func(origin string) bool {
			return origin == "*"
		},
		MaxAge: 12 * time.Hour,
	}))

	//Login
	router.GET("/login", controllers.Login)

	//Logout
	router.GET("/logout", controllers.Logout)

	//Melihat Daftar Transfer
	router.GET("/listTransfer", controllers.GetTransfer)

	// Melihat Info Account
	router.GET("/infoaccount/:nomor_kartu", controllers.GetInfoAccount)

	// Transfer
	router.POST("/insertTransfer", controllers.InsertTransfer)

	// Virtual Account
	router.POST("/virtualaccount", controllers.InsertVirtualAccount)

	// Membuat Rekening Baru
	router.POST("/rekeningbaru", controllers.InsertRekening)

	// Ganti Kode Akses
	router.PUT("/gantikodeakses/:nomor_rekening", controllers.UpdateKodeAkses)

	router.Run(":8080")
	fmt.Println("Connected to port 8080")
}
