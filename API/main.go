package main

import (
	"fmt"
	"time"

	controllers "github.com/ABCmobile/controller"

	"github.com/gin-contrib/cors"
	"github.com/gin-gonic/gin"
	_ "github.com/go-sql-driver/mysql"
)

func main() {
	fmt.Println("ABCmobile API")

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

	// Melihat info account
	router.GET("/infoaccount", controllers.GetInfoAccount)
	// Transfer
	router.POST("/transfer", controllers.InsertTransfer)
	// Virtual Account
	router.POST("/virtualaccount", controllers.InsertVirtualAccount)
	// Membuat rekening baru
	router.POST("/rekeningbaru", controllers.InsertRekening)
	// Ganti kode akses
	router.PUT("/gantikodeakses", controllers.UpdateKodeAkses)

	router.Run(":8080")
	fmt.Println("Connected to port 8080")
}
