package com.example.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = MhsDatabase(this)

        GlobalScope.launch {
            db.mhsDao().insertAll(MhsEntity(0, "Aura", "Malang"))
            val data = db.mhsDao().getAll()

            data?.forEach {
                Log.d("DATABASE", it.toString())
            }
        }

        tambah.setOnClickListener {

            var nama = nama.text.toString()
            var alamat = alamat.text.toString()

            hasil.setText("Nama : $nama \nAlamat : $alamat")

            GlobalScope.launch {
                db.mhsDao().insertAll(MhsEntity(0, "$nama", "$alamat"))
                val data = db.mhsDao().getAll()

                data?.forEach {
                    Log.d("DATABASE", it.toString())
                }
            }
        }
    }
}
