package main

import (
	"fmt"
	// "net/ht tp"
	// "log"
	// "os"

	// "strconv"
	"time"

	// "github.com/joho/godotenv"

	controllers "github.com/ABCMobile/controller"
	_ "github.com/go-sql-driver/mysql"

	"github.com/gin-contrib/cors"
	"github.com/gin-gonic/gin"
	// "github.com/russross/blackfriday"
)

func main() {
	fmt.Println("ABCMobile API")

	router := gin.Default()

	// router.GET("/mark", func(c *gin.Context) {
	// 	c.String(http.StatusOK, string(blackfriday.Run([]byte("**hi!**"))))
	// })

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
	router.POST("/login", controllers.Login)

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
	router.PUT("/gantikodeakses", controllers.UpdateKodeAkses)

	// err := godotenv.Load(".env")
	// if err != nil {
	// 	log.Fatalf("Error loading .env file")
	// }

	port := os.Getenv("PORT")
	fmt.Println(port)
	router.Run(":" + port)
	// router.Run(":8080")
	fmt.Println("Connected to port 8080")

	// PORT := os.Getenv("PORT")

	// // if PORT == "" {
	// // 	PORT = strconv.Itoa(5000)
	// // }

	// print(PORT)
	// print("testttttttt")

	// if PORT == "" {
	// 	log.Fatal("$PORT must be set")
	// }
	// router.Run(":" + PORT)
	// // router.Run(":8080")
	// // router.Run(":39395")
	// fmt.Println("Connected to port " + PORT)

	//   port := os.Getenv("PORT")

	// if port == "" {
	//     log.Fatal("$PORT must be set")
	// }

	// tStr := os.Getenv("REPEAT")
	// repeat, err := strconv.Atoi(tStr)
	// if err != nil {
	//     log.Printf("Error converting $REPEAT to an int: %q - Using default\n", err)
	//     repeat = 5
	// }

	// router := gin.New()
	// router.Use(gin.Logger())
	// router.LoadHTMLGlob("templates/*.tmpl.html")
	// router.Static("/static", "static")

	// router.GET("/", func(c *gin.Context) {
	//     c.HTML(http.StatusOK, "index.tmpl.html", nil)
	// })

	// router.GET("/mark", func(c *gin.Context) {
	//     c.String(http.StatusOK, string(blackfriday.Run([]byte("**hi!**"))))
	// })

	// router.GET("/repeat", repeatHandler(repeat))

	// router.Run(":" + port)

	// serverPort := config.LoadConfig("PORT")

	// router := gin.Default()
	// router.Use(cors.Default())

	// MapEndPoints(router)

	// router.Run(":" + serverPort)

}
