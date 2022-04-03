package controller

import (
	"net/http"

	"github.com/ABCmobile/model"
	"github.com/gin-gonic/gin"
)

// Menu Response
func sendUserSuccessresponse(c *gin.Context, ur model.UserResponse) {
	c.JSON(http.StatusOK, ur)
}

func sendUserErrorResponse(c *gin.Context, ur model.UserResponse) {
	c.JSON(http.StatusBadRequest, ur)
}

func sendAccountSuccessresponse(c *gin.Context, ur model.AccountResponse) {
	c.JSON(http.StatusOK, ur)
}

func sendAccountErrorResponse(c *gin.Context, ur model.AccountResponse) {
	c.JSON(http.StatusBadRequest, ur)
}

func sendTransferSuccessresponse(c *gin.Context, ur model.TransferResponse) {
	c.JSON(http.StatusOK, ur)
}

func sendTransferErrorResponse(c *gin.Context, ur model.TransferResponse) {
	c.JSON(http.StatusBadRequest, ur)
}

func sendLoginSuccessResponse(c *gin.Context, log model.LoginResponse) {
	c.JSON(http.StatusOK, log)
}

func sendLoginErrorResponse(c *gin.Context, err model.LoginResponse) {
	c.JSON(http.StatusBadRequest, err)

}