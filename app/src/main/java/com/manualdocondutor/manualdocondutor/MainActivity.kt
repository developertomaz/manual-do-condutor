package com.manualdocondutor.manualdocondutor

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

import java.net.URL

class MainActivity : AppCompatActivity() {
    private lateinit var rc_item: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val itensdb = mutableListOf<DbItens>()

        itensdb.add(
            DbItens(
                id = 1,
                drawableId = R.drawable.cnh,
                textStringId = R.string.mes,
                color = Color.BLACK

            )
        )

        itensdb.add(
            DbItens(
                id = 2,
                drawableId = R.drawable.primeirah,
                textStringId = R.string.mes,
                color = Color.BLACK

            )
        )
        itensdb.add(
            DbItens(
                id = 3,
                drawableId = R.drawable.detran,
                textStringId = R.string.mes,
                color = Color.BLACK

            )
        )
        itensdb.add(
            DbItens(
                id = 4,
                drawableId = R.drawable.toxi,
                textStringId = R.string.mes,
                color = Color.BLACK

            )
        )
        itensdb.add(
            DbItens(
                id = 5,
                drawableId = R.drawable.reci,
                textStringId = R.string.mes,
                color = Color.BLACK

            )
        )
        itensdb.add(
            DbItens(
                id = 6,
                drawableId = R.drawable.espe,
                textStringId = R.string.mes,
                color = Color.BLACK

            )
        )

        itensdb.add(
            DbItens(
                id = 7,
                drawableId = R.drawable.emer,
                textStringId = R.string.mes,
                color = Color.BLACK

            )
        )
        itensdb.add(
            DbItens(
                id = 8,
                drawableId = R.drawable.co,
                textStringId = R.string.mes,
                color = Color.BLACK

            )
        )





        val adapter = MainAdapter(itensdb) { id ->
            when (id) {
                1 -> {

                    val go = Intent(this@MainActivity, tela1Activity::class.java)
                    startActivity(go)
                }

                2 -> {
                    val go2 = Intent(this@MainActivity, habili::class.java)
                    startActivity(go2)
                }

                3 -> {
                 //   val intent= Intent.ACTION_VIEW;Uri.parse("https://www.google.com")
                    startActivity(Intent(Intent.ACTION_VIEW,Uri.parse("https://www.detran.sc.gov.br")))
                }

                4 -> {
                    val go4 = Intent(this@MainActivity, toxico::class.java)
                    startActivity(go4)
                }
                5 -> {
                    val go5 = Intent(this@MainActivity, recicla::class.java)
                    startActivity(go5)
                }
                6 -> {
                    val go6 = Intent(this@MainActivity, especiali::class.java)
                    startActivity(go6)
                }

                7 -> {
                    val go7 = Intent(this@MainActivity, phone::class.java)
                    startActivity(go7)
                }
                8-> {
                    val intent= Intent.ACTION_VIEW;Uri.parse("https://www.ctbdigital.com.br/busca-artigo")
                    startActivity(Intent(Intent.ACTION_VIEW,Uri.parse("https://www.ctbdigital.com.br/busca-artigo")))
                }
            }


        }
        rc_item = findViewById(R.id.rc_item)
        rc_item.adapter = adapter
        rc_item.layoutManager = GridLayoutManager(this, 2)

    }

    private inner class MainAdapter(
        private val itensdb: List<DbItens>,
        private val click:(Int)->Unit,
    ) : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
            val view = layoutInflater.inflate(R.layout.activity_item2, parent, false)
            return MainViewHolder(view)
        }

        override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
            val itemCurrent = itensdb[position]
            holder.bind(itemCurrent)
        }

        override fun getItemCount(): Int {
            return itensdb.size
        }


    private inner class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(iten: DbItens) {
            val img: ImageView = itemView.findViewById(R.id.imgContact)
            val container: LinearLayout = itemView.findViewById(R.id.containerItem)

            img.setImageResource(iten.drawableId)
//            container.setBackgroundColor(iten.color)

            container.setOnClickListener {
                click.invoke(iten.id)
            }
        }
    }

}
}