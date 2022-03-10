package com.babe.fancesca

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.view.KeyEvent
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

import java.util.concurrent.Delayed
import kotlin.coroutines.coroutineContext
import kotlin.coroutines.suspendCoroutine
import kotlin.random.Random

private val adapter = MessageAdapter()
class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler()

        clicker()

        supportActionBar?.title = "Francesca"
    }

    fun recycler(){
        recycle.layoutManager = LinearLayoutManager(applicationContext)
        recycle.adapter = adapter
    }

    fun francesca(a:String){

        val c = Francesca.francescaResponse(a)
        adapter.insertMessage(Messagess(c, RECEIVER_ID))
        recycle.scrollToPosition(adapter.itemCount - 1)
        }

    fun clicker(){
        send.setOnClickListener{
            val a = edit_text.text.toString()

            if (a.isNotEmpty()) {
                edit_text.setText("")
                adapter.insertMessage(Messagess(a, SENDER_ID))
                edit_text.setText("")
                recycle.scrollToPosition(adapter.itemCount - 1)

                francesca(a)
            }else{
                adapter.insertMessage(Messagess("Are you giving me the silent treatment Love?", RECEIVER_ID))
            }
        }
    }


}