package com.example.abcmobile.model_db_local;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteHelper extends SQLiteOpenHelper {
    public SQLiteHelper(Context context) {
        super(context, "abcmobilelocal.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE favorites(rekening_penerima TEXT PRIMARY KEY, alias TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS favorites");
    }

    public Boolean insertFavorites(String rekening_penerima, String alias){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("rekening_penerima", rekening_penerima);
        cv.put("alias", alias);
        long result = db.insert("favorites", null, cv);
        if(result == -1){
            return false;
        } else {
            return true;
        }
    }

    public Boolean updateFavorites(String rekening_penerima, String alias){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("rekening_penerima", rekening_penerima);
        cv.put("alias", alias);
        Cursor cursor = db.rawQuery("SELECT * FROM favorites where rekening_penerima = ?", new String[]{rekening_penerima});
        if(cursor.getCount()>0){
            long result = db.update("favorites", cv, "rekening_penerima=?", new String[]{rekening_penerima});
            if(result == -1){
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public Boolean deleteFavorites(String rekening_penerima){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM favorites where rekening_penerima = ?", new String[]{rekening_penerima});
        if(cursor.getCount()>0){
            long result = db.delete("favorites", "rekening_penerima=?", new String[]{rekening_penerima});
            if(result == -1){
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public Cursor getFavorites(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM favorites", null);
        return cursor;
    }
}
