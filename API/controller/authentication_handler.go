package controller

import (
	"time"

	"github.com/gin-gonic/gin"
	"github.com/golang-jwt/jwt"
)

var jwtKey = []byte("abcmobile")
var tokenName = "token"

type Claims struct {
	ID            int    `json:"id"`
	nomorKartu    string `json:"nomor_kartu"`
	nomorRekening string `json:"nomor_rekening"`
	jwt.StandardClaims
}

func generateToken(c *gin.Context, id int, nomorKartu string, nomorRekening string) {
	tokenExpiryTime := time.Now().Add(60 * time.Minute)

	claims := &Claims{
		ID:            id,
		nomorKartu:    nomorKartu,
		nomorRekening: nomorRekening,
		StandardClaims: jwt.StandardClaims{
			ExpiresAt: tokenExpiryTime.Unix(),
		},
	}
	token := jwt.NewWithClaims(jwt.SigningMethodHS256, claims)
	signedToken, err := token.SignedString(jwtKey)
	if err != nil {
		return
	}

	c.SetCookie(tokenName, signedToken, 1000, "/", "localhost", false, true)
}

func resetUserToken(c *gin.Context) {
	c.SetCookie(tokenName, "", -1, "/", "localhost", false, true)
}

func validateTokenFromCookies(c *gin.Context) (bool, int, string, string) {
	if cookie, err := c.Cookie(tokenName); err == nil {
		accessToken := cookie
		accessClaims := &Claims{}
		parsedToken, err := jwt.ParseWithClaims(accessToken, accessClaims, func(accessToken *jwt.Token) (interface{}, error) {
			return jwtKey, nil
		})
		if err == nil && parsedToken.Valid {
			return true, accessClaims.ID, accessClaims.nomorKartu, accessClaims.nomorRekening
		}
	}
	return false, -1, "", ""
}
