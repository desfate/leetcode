package com.chengdu.leetcode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlin.text.StringBuilder

class MainActivity476 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findComplement(5)
    }

    fun findComplement(num: Int): Int {
        var highbit = 0
        for (index in 1..30){
            if (num >= 1 shl index) {
                highbit = index;
            } else {
                break;
            }
        }
        val mask = if(highbit == 30){0x7fffffff}else{(1 shl (highbit + 1)) - 1}
        return num.xor(mask);
    }


}

