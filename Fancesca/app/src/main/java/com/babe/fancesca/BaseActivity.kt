package com.babe.fancesca

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.babe.fancesca.BaseActivity.Calculator.calculator
import java.util.*

const val SENDER_ID = "sender"
const val RECEIVER_ID = "receive"
const val TAG = ""
var NAME = "Jojo"

open class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    fun user(name:String){
        NAME = name
    }



    object Calculator {
        fun calculator(value: String): String {
            val random = (0..3).random()
            val text: String = when (random) {
                0 -> {
                    "babe"
                }
                1 -> {
                    "love"
                }
                2 -> {
                    "mi amor"
                }
                3 -> {
                    NAME
                }
                else -> return "null"
            }

            val newEquation = value.replace(" ", "")

            if (newEquation.contains("+")) {
                if (newEquation.contains("me") || (newEquation.contains("you") || (newEquation.lowercase().contains("fran")))) {
                    return "You dirty dirty boy\nI like!"
                } else {
                    val split = newEquation.split("+")
                    val result = split[0].toInt() + split[1].toInt()
                    return "The answer is $result $text"
                }
            }
            else if (newEquation.contains("-")) {
                val split = newEquation.split("-")
                val result = split[0].toInt() - split[1].toInt()
                return "The answer is ${result} $text "
            }else if ((newEquation.contains("x")) || (newEquation.contains("X")) || (newEquation.contains(
                    "*"))
            ) {
                val split = newEquation.split("x")
                val result = split[0].toInt() * split[1].toInt()
                return "The answer is ${result} $text "
            } else if (newEquation.contains("/")) {
                val split = newEquation.split("/")
                val result = split[0].toInt() / split[1].toInt()
                return "The answer is ${result} $text "
            }else if (newEquation.contains("me")&&(newEquation.contains("you")||(newEquation.lowercase().contains("fran")))){
                return "You dirty dirty boy\nI like"
            }
            else {
                return "I do not understand the equation $text"
            }

        }
    }

    object Francesca{
        var name = NAME
        fun francescaResponse(message:String): String {
            val mess = message.lowercase()
            val randomm = (0..5).random()

            val text:String = when(randomm){
                0 -> {
                    "babe"
                }
                1 -> {
                    "love"
                }
                2 -> {
                    "mi amor"
                }
                3 -> {
                    NAME
                }
                else -> "loml"
            }

            val helloresponses = listOf("Hello $name", "Heyyy $text \n How you doing baby?", "Hiiiiii baby", "Hey Heyyy $text", "Babeeee, what's good?", "Loml!!!!!\nHow you doing")
            val goodresponses = listOf("That's niceeeee babe","Yayyyy, that's my baby","Okurrrrrr", "Alrighttttt","Let'ss gooo","Thank God Love")
            val tex = "Awww what's wrong love?\nwhat happened?"
            val ext = "I'm just there babe\nI'm Okay, you?"

            if(mess.contains("hello")||(mess.contains("hi"))||mess.contains("hey")){
                return helloresponses[randomm]
            }else if (((mess.contains("am"))||(mess.contains("i'm"))) && ((mess.contains("good"))||(mess.contains("well")))){
                return goodresponses[randomm]
            }else if (((mess.contains("am"))||(mess.contains("i'm"))) && ((mess.contains("bad"))||(mess.contains("sad"))||(mess.contains("down")))){
                return tex
            }else if (mess.contains("solve")){
                val a = mess.removePrefix("solve")
                return calculator(a)
            }else if (mess.contains("how are you")&& mess.contains("you")){
                return ext
            }else if (mess.contains("Francesca")){
                return "Yaaasssssssssss $text?"
            }
            return "Sorry could you come again $text?"
        }

        }


    object Time{
        fun time(){

        }
    }

}