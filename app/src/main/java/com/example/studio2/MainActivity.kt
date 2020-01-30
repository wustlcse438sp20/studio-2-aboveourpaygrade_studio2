package com.example.studio2

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    var savings = 0

    val CHANGE_BALANCE_REQUEST = 1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        value_display.text = "$0"
    }

    fun changeBalance(view: View) {
        val addNameIntent = Intent(this, ChangeActivity::class.java)
        startActivityForResult(addNameIntent, CHANGE_BALANCE_REQUEST)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        super.onActivityResult(requestCode, resultCode, data)
        println(requestCode)
        if(requestCode == CHANGE_BALANCE_REQUEST) {
            if(resultCode == Activity.RESULT_OK) {
                val change = data?.extras?.getInt("total")
                println(change)
                if (change != null && savings + change >= 0) {
                    savings += change
                }
                value_display.text = "$$savings"
            }
        }
    }

}
