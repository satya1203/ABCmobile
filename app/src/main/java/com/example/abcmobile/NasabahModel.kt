package com.example.abcmobile

import java.util.*

data class NasabahModel (
    var id: Int = getAutoId(),
    var name: String = "",
    var alamat: String = "",
    var email: String = "",
    var kode_akses: String = "",
    var telp: String = ""
){
    companion object {
        fun getAutoId(): Int {
            val random = Random()
            return random.nextInt(100)
        }
    }

}