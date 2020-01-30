package com.example.studio2

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.fragment_deposit.*
import kotlinx.android.synthetic.main.fragment_withdraw.*


class WithdrawFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_withdraw, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        withdraw_button.setOnClickListener {
            val total = withdraw_value.text.toString().toIntOrNull()?.times(-1)
            val intent = Intent(activity, MainActivity::class.java)
            intent.putExtra("total", total)
            activity!!.setResult(Activity.RESULT_OK, intent)
            activity?.finish()
        }
    }


}
