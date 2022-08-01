package com.chengdu.leetcode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity1374 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun generateTheString(n: Int): String {
        var result = "";
        if(n % 2 == 0){
            for (i in 1 until n){
                 result += 'a'
            }
            result += 'b'
        }else{
            for (i in 1..n){
                result += 'a'
            }
        }
        return result
    }

}

