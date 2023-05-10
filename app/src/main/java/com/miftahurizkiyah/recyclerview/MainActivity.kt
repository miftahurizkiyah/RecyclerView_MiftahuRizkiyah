package com.miftahurizkiyah.recyclerview

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.miftahurizkiyah.recyclerview.adapter.AdapterTeamBola
import com.miftahurizkiyah.recyclerview.databinding.ActivityMainBinding
import com.miftahurizkiyah.recyclerview.model.Pemain

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listPemain = ArrayList<Pemain>()
        listPemain.add(Pemain("Dani Carvajal",R.drawable.dani, "Pemain Bertahan","1.73 m", "Spanyol","11 Januari 1992"))
        listPemain.add(Pemain("Karim Benzema",R.drawable.benzema,"Penyerang","1.85 m", "Lyon (Perancis)","19 Desember 1987"))
        listPemain.add(Pemain("Federico Valverde",R.drawable.federico, "Gelandang","1.82 m", "Uruguay","22 Juli 1998"))
        listPemain.add(Pemain("Nacho Fernandez",R.drawable.nacho, "Pemain Bertahan","1.80 m", "Madrid (Spanyol)","18 Januari 1990"))
        listPemain.add(Pemain("Sergia Ramos Garcia",R.drawable.ramos, "Pemain Bertahan","1.84 m", "Camas (Sevilla)","30 Maret 1986"))

        binding.list.adapter = AdapterTeamBola(this,listPemain,object : AdapterTeamBola.OnClickListener {
            override fun detailData(item: Pemain?) {
                Dialog(this@MainActivity).apply {
                    requestWindowFeature(Window.FEATURE_NO_TITLE)
                    setCancelable(true)
                    setContentView(R.layout.detail_data_pemain)

                    val image = this.findViewById<ImageView>(R.id.image_pemain)
                    val nama = this.findViewById<TextView>(R.id.txtNamaPemain)

                    val posisi = this.findViewById<TextView>(R.id.txtPosisi)
                    val tinggi = this.findViewById<TextView>(R.id.txtTinggi)
                    val tempatlahir = this.findViewById<TextView>(R.id.txtTempatLahir)
                    val tgllahir = this.findViewById<TextView>(R.id.txtTanggalLahir)
                    val btn = this.findViewById<Button>(R.id.btnClose)

                    image.setImageResource(item?.foto ?:0)
                    nama.text = "${item?.nama}"
                    posisi.text = "${item?.posisi}"
                    tinggi.text = "${item?.tinggi}"
                    tempatlahir.text = "${item?.tempatlahir}"
                    tgllahir.text = "${item?.tgllahir}"

                   btn.setOnClickListener {
                       this.dismiss()
                   }

                }.show()
            }

        })


    }

}