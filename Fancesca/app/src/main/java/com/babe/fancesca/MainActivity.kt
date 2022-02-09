package com.babe.fancesca

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.view.KeyEvent
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

import java.util.concurrent.Delayed
import kotlin.coroutines.coroutineContext
import kotlin.coroutines.suspendCoroutine

private val adapter = MessageAdapter()
class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler()

        clicker()
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
            }
        }
    }


}