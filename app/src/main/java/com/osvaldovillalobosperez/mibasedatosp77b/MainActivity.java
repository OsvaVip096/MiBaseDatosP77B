package com.osvaldovillalobosperez.mibasedatosp77b;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DAOContacto dao = new DAOContacto(this);

        dao.insert(
                new Contacto(
                        0,
                        "Osva",
                        "s15120062@alumnos.itsur.edu.mx",
                        "4451597776",
                        "10/12/1996"
                )
        );

        dao.insert(
                new Contacto(
                        0,
                        "Jesús",
                        "s29823933@alumnos.itsur.edu.mx",
                        "4452880110",
                        "21/01/1997"
                )
        );

        for (Contacto c : dao.getAll()) {
            Toast.makeText(this, c.getUsuario(), Toast.LENGTH_SHORT).show();
        }

        Cursor c = dao.getAllCursor();

        lv = findViewById(R.id.Lv);

        SimpleCursorAdapter adp = new SimpleCursorAdapter(
                this,
                android.R.layout.simple_expandable_list_item_2,
                c,
                new String[]{"usuario", "email"},
                new int[]{android.R.id.text1, android.R.id.text2},
                SimpleCursorAdapter.IGNORE_ITEM_VIEW_TYPE
        );

        lv.setAdapter(adp);
    }
}
