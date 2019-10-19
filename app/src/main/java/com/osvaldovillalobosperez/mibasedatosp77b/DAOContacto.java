package com.osvaldovillalobosperez.mibasedatosp77b;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class DAOContacto {
    SQLiteDatabase _sqlSqLiteDatabase;

    public DAOContacto(Context ctx) {
        MiDB miDB = new MiDB(ctx);
        _sqlSqLiteDatabase = miDB.getWritableDatabase();
    }

    public long insert(Contacto contacto) {
        ContentValues cv = new ContentValues();
        cv.put(MiDB.COLUMNS_CONTACTOS[1], contacto.getUsuario());
        cv.put(MiDB.COLUMNS_CONTACTOS[2], contacto.getEmail());
        cv.put(MiDB.COLUMNS_CONTACTOS[3], contacto.getTel());
        cv.put(MiDB.COLUMNS_CONTACTOS[4], contacto.getFecha_nacimiento());
        return _sqlSqLiteDatabase.insert(MiDB.TABLE_NAME_CONTACTOS, null, cv);
    }

    // Ingresar el dato que se va a eliminar...
    public int delete(Contacto contacto) {
        return 0;
    }

    public List<Contacto> getAll() {
        List<Contacto> lst = null;
        Cursor c = _sqlSqLiteDatabase.query(MiDB.TABLE_NAME_CONTACTOS, MiDB.COLUMNS_CONTACTOS,
                null, null, null, null, null);
        if (c.moveToFirst()) {
            lst = new ArrayList<Contacto>();
            do {
                Contacto ctc = new Contacto(c.getInt(0), c.getString(1), c.getString(2),
                        c.getString(3), c.getString(4));
                lst.add(ctc);
            } while (c.moveToNext());
        }
        return lst;
    }

    public Cursor getAllCursor() {
        Cursor c = _sqlSqLiteDatabase.query(MiDB.TABLE_NAME_CONTACTOS, MiDB.COLUMNS_CONTACTOS,
                null, null, null, null, null);
        return c;
    }
}
