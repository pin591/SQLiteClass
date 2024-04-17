package com.example.sqlitetrainning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addName.setOnClickListener {
            val db = DBHelper(this, null)
            val name = enterName.text.toString()
            db.addName(name, age)
            Toast.makeTest(this, name + "added to database", android.widget.Toast.LENGTH_LONG.show())
            enterName.text.clear()
            enterAge.text.clear()
        }

        printName.setOnClickListener {
            val db = DBHelper(this, null)
            val cursor = db.getName()
            cursor!!.moveToFirst()


            name.append(cursor.getString(cursor.getColumnIndex((DBHelper.NAME_COL)) + "\n"))
            age.append(cursor.getString(cursor.getColumnIndex((DBHelper.AGE_COL)) + "\n"))

            while (cursor.moveToNext()) {
                Name.append(cursor.getString(cursor.getColumnIndex((DBHelper.NAME_COL)) + "\n"))
                Age.append(cursor.getString(cursor.getColumnIndex((DBHelper.AGE_COL)) + "\n"))
            }

            cursor.close()
        }

        print.setOnclickListener {
            do {
                cursor.getString(columnIndex: 0).toString() + ": "
                cursor.getString(columnIndex: 1).toString() + ", "
                cursor.getString(columnIndex: 1).toString() + "\n"
            } while (cursor.moveToNext())
        }
    }
}