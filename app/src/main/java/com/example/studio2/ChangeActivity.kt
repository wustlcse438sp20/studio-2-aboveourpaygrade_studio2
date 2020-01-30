package com.example.studio2

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_change.*

class ChangeActivity : AppCompatActivity() {


    var showingDeposit = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change)
    }

    override fun onStart() {
        super.onStart()
        //set the initial fragment
        switchFragment()
    }

    private fun switchFragment() {
        val fragment = getNewFragment()
        var bundle = Bundle()
        bundle.putInt("change", 0)
        fragment.arguments = bundle
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.contaner, fragment)
        transaction.commit()
        showingDeposit = !showingDeposit

    }

    fun completeTransaction(change: Int?) {
        var result = Intent()
        result.putExtra("change", change)

        setResult(Activity.RESULT_OK, result)
        finish()
    }

    private fun getNewFragment(): Fragment {
        if(showingDeposit) {
            return WithdrawFragment()
        } else {
            return DepositFragment()
        }
    }

    fun switchMode(view: View) {
        switchFragment()
    }

}
