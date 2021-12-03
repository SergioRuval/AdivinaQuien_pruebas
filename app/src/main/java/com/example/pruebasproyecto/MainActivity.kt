package com.example.pruebasproyecto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.pruebasproyecto.fragmentos.PruebaFragment
import com.example.pruebasproyecto.objects.ListaAvatares

class MainActivity : AppCompatActivity() {

    private val imgVwIds : Array<Int> = arrayOf(R.id.tab_avtr_01, R.id.tab_avtr_02, R.id.tab_avtr_03, R.id.tab_avtr_04,
        R.id.tab_avtr_05, R.id.tab_avtr_06, R.id.tab_avtr_7, R.id.tab_avtr_8, R.id.tab_avtr_9, R.id.tab_avtr_10,
        R.id.tab_avtr_11, R.id.tab_avtr_12, R.id.tab_avtr_13, R.id.tab_avtr_14, R.id.tab_avtr_15, R.id.tab_avtr_16,
        R.id.tab_avtr_17, R.id.tab_avtr_18, R.id.tab_avtr_19, R.id.tab_avtr_20, R.id.tab_avtr_21, R.id.tab_avtr_22,
        R.id.tab_avtr_23, R.id.tab_avtr_24)

    private var imgViews : MutableList<ImageView> = mutableListOf()

    private lateinit var imgBtnAdivinar : ImageView
    private lateinit var btnPreguntar : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN)

        imgVwIds.forEach {
            imgViews.add(findViewById( it ))
        }

        var i = 0

        imgViews.forEach{
            var img : Int = ListaAvatares.arrayAvatares.get(i).getImgSource()
            it.tag = "adelante"

            Glide.with(this)
                .load(img)
                .into(it)

            it.setOnClickListener {
                var imgView : ImageView = it as ImageView

                var position = imgVwIds.indexOf(imgView.id)

                if (imgView.tag != "adelante"){
                    Glide.with(this)
                        .load(ListaAvatares.arrayAvatares.get(position).getImgSource())
                        .into(imgView)
                    it.tag = "adelante"
                }else{
                    Glide.with(this)
                        .load(R.drawable.partetrasera)
                        .into(imgView)
                    imgView.tag = "atras"
                }
            }
            i++
        }

        imgBtnAdivinar = findViewById(R.id.imgBtnAdivinar)
        Glide.with(this)
            .load(R.drawable.partetrasera)
            .into(imgBtnAdivinar)

        btnPreguntar = findViewById(R.id.btnPreguntar)
        btnPreguntar.setOnClickListener {
            val f = supportFragmentManager.findFragmentByTag("Fragmento")
            if(f == null){
                supportFragmentManager.beginTransaction()
                    .setCustomAnimations(
                        R.anim.slide_in,
                        R.anim.slide_out,
                        R.anim.slide_in,
                        R.anim.slide_out
                    )
                    .add(R.id.linearLayoutForFragment, PruebaFragment.newInstance(), "Fragmento")
                    .commit()
            }else{
                supportFragmentManager.beginTransaction()
                    .remove(f)
                    .commit()
            }
        }

    }
}