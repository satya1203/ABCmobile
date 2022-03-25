package com.example.abcmobile

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import java.lang.Exception

class SQLiteHelper(context:Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "abcMobile.db"
        private const val TBL_NASABAH = "tbl_nasabah"
        private const val TBL_REKENING = "tbl_rekening"
        private const val TBL_VA = "tbl_va"
        private const val TBL_TRANSAKSI = "tbl_transaksi"

        //Table Nasabah
        private const val ID = "id"
        private const val NAME = "name"
        private const val ALAMAT = "alamat"
        private const val EMAIL = "email"
        private const val KODE_AKSES = "kode_akses"
        private const val TELP = "telp"

        //Table Rekening
        private const val NOMOR_REKENING = "nomor_rekening"
        private const val SALDO = "saldo"

        //Table Virtual Account
        private const val NOMOR_VA = "nomor_va"
        private const val TAGIHAN = "tagihan"

        //Table Transaksi
        private const val NOMINAL = "nominal"
        private const val BERITA = "berita"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createTblNasabah = ("CREATE TABLE " + TBL_NASABAH + "("
                + ID + "INTEGER PRIMARY KEY," + NAME + "TEXT,"
                + ALAMAT + "TEXT," + EMAIL + "TEXT,"
                + KODE_AKSES + "TEXT," + TELP + "TEXT" + ")")
        db?.execSQL(createTblNasabah)

        val createTblRekening = ("CREATE TABLE " + TBL_REKENING + "("
                + NOMOR_REKENING + "TEXT PRIMARY KEY," + SALDO + "INTEGER"
                + ")")
        db?.execSQL(createTblRekening)

        val createTblVA = ("CREATE TABLE " + TBL_VA + "("
                + NOMOR_VA + "INTEGER PRIMARY KEY," + TAGIHAN + "DOUBLE"
                + ")")
        db?.execSQL(createTblVA)

        val createTblTransaksi = ("CREATE TABLE " + TBL_TRANSAKSI + "("
                + NOMINAL + "INTEGER PRIMARY KEY," + BERITA + "TEXT"
                +")")
        db?.execSQL(createTblTransaksi)
    }

    override fun onUpgrade(db: SQLiteDatabase?, old: Int, new: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS $TBL_NASABAH")
        db!!.execSQL("DROP TABLE IF EXISTS $TBL_REKENING")
        db!!.execSQL("DROP TABLE IF EXISTS $TBL_VA")
        db!!.execSQL("DROP TABLE IF EXISTS $TBL_TRANSAKSI")
        onCreate(db)
    }

    fun insertRekening(rk: RekeningModel): Long {
        val db = this.writableDatabase

        val contentValues = ContentValues()
        contentValues.put(NOMOR_REKENING, rk.nomor_rekening)
        contentValues.put(SALDO, rk.saldo)

        val success = db.insert(TBL_REKENING, null, contentValues)
        db.close()
        return success
    }

    fun insertVirtualAccount(va : VAModel): Long {
        val db = this.writableDatabase
        val contentValues = ContentValues()

        contentValues.put(NOMOR_VA, va.nomorva)
        contentValues.put(TAGIHAN, va.tagihan)

        val success = db.insert(TBL_VA, null, contentValues)
        db.close()
        return success
    }

    fun insertTransaksi(tk : TransaksiModel): Long {
        val db = this.writableDatabase
        val contentValues = ContentValues()

        contentValues.put(NOMINAL, tk.nominal)
        contentValues.put(BERITA, tk.berita)

        val success = db.insert(TBL_TRANSAKSI, null, contentValues)
        db.close()
        return success
    }

   fun updateSaldo(rk: RekeningModel): Int {
       val db = this.writableDatabase
       val contentValues = ContentValues()

       contentValues.put(NOMOR_REKENING, rk.nomor_rekening)
       contentValues.put(SALDO, rk.saldo)

       val success = db.update(TBL_REKENING, contentValues, "nomor_rekening=" + rk.nomor_rekening, null)
       db.close()
       return success
   }

    fun updateKodeAkses(nb: NasabahModel): Int {
        val db = this.writableDatabase
        val contentValues = ContentValues()

        contentValues.put(ID, nb.id)
        contentValues.put(KODE_AKSES, nb.kode_akses)

        val success = db.update(TBL_NASABAH, contentValues, "id=" + nb.id, null)
        db.close()
        return success
    }


     fun getSaldo(rk : RekeningModel): ArrayList<RekeningModel>{
         val stdList : ArrayList<RekeningModel> = ArrayList()
         val selectQuery = "SELECT * FROM $TBL_REKENING WHERE noRekening = noRekening"
         val db = this.readableDatabase

         val cursor : Cursor?

         try {
            cursor = db.rawQuery(selectQuery, null)
         } catch(e: Exception) {
             e.printStackTrace()
             db.execSQL(selectQuery)
             return ArrayList()
         }

         var noRekening : String
         var saldo : Double
         var name : String

         if(cursor.moveToFirst()) {
             do {
                 noRekening = cursor.getString(cursor.getColumnIndex("noRekening"))
                 saldo = cursor.getDouble(cursor.getColumnIndex("saldo"))
                 name = cursor.getString(cursor.getColumnIndex("name"))

                 val std = RekeningModel(nomor_rekening = noRekening, saldo = saldo, name = name)
                 stdList.add(std)
             } while (cursor.moveToNext())
                 return stdList
         }
     }

    //Kode Akses dan Login
   // fun login()

}