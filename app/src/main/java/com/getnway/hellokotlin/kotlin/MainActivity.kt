package com.getnway.hellokotlin.kotlin

import android.app.Activity
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.getnway.hellokotlin.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
//    private var et_content: EditText? = null
//    private var tv_content: TextView? = null
//    private var btn_ok: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        et_content = findViewById(R.id.et_content) as EditText
//        tv_content = findViewById(R.id.tv_content) as TextView
//        btn_ok = findViewById(R.id.btn_ok) as Button

//        btn_ok!!.setOnClickListener { tv_content!!.text = et_content!!.text }
        btn_ok.setOnClickListener { tv_content.text = et_content.text }
    }
}
