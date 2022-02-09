package com.babe.fancesca

import android.opengl.Visibility
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class MessageAdapter: RecyclerView.Adapter<MessageAdapter.MessageViewHolder>() {

    var messageList = mutableListOf<Messagess>()


    inner class MessageViewHolder(itemView:View): RecyclerView.ViewHolder(itemView){
        var message = itemView.findViewById<TextView>(R.id.jaysmessage)
        var francescaMessage = itemView.findViewById<TextView>(R.id.francescasmessage)

        init {
            itemView.setOnClickListener {
                messageList.removeAt(adapterPosition)
                notifyItemRemoved(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.messages,parent,false)
        return MessageViewHolder(v)
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        val currentPosition = messageList[position]

        when (currentPosition.id){
            SENDER_ID -> {
                holder.message.apply {
                    text = currentPosition.message
                    visibility = View.VISIBLE
                }
                holder.francescaMessage.visibility = View.GONE
                }
            RECEIVER_ID -> {
                holder.francescaMessage.apply {
                    visibility = View.VISIBLE
                    text = currentPosition.message
                }
                holder.message.visibility = View.GONE
            }
        }

    }

    override fun getItemCount(): Int {
        return messageList.size
    }

    fun insertMessage(message:Messagess){
        this.messageList.add(message)
        notifyItemInserted(messageList.size-1)
    }


}