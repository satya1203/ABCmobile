package controller

import (
	"database/sql"
	"log"
)

func connect() *sql.DB {
	// db, err := sql.Open("mysql", "root:@tcp(localhost:3306)/abcmobile?parseTime=true&loc=Asia%2FJakarta")
	// db, err := sql.Open("mysql", "admin:zH7wwJ3u@tcp(mysql-75830-0.cloudclusters.net:18445)/abcmobile?parseTime=true&loc=Asia%2FJakarta") //free account pertama
	db, err := sql.Open("mysql", "admin:5OaBvFiI@tcp(mysql-78043-0.cloudclusters.net:12074)/abcmobile?parseTime=true&loc=Asia%2FJakarta")
	// db, err := sql.Open("mysql", "epiz_31612360:tIntqwxcjT1P@tcp(sql313.epizy.com:3306)/epiz_31612360_abcmobile?parseTime=true&loc=Asia%2FJakarta")

	if err != nil {
		log.Fatal(err)
	}
	return db
}
