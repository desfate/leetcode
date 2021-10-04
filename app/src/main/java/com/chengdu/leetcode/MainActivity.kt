package com.chengdu.leetcode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.lang.StringBuilder
class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        licenseKeyFormatting("---", 3)
    }

    fun licenseKeyFormatting(s: String, k: Int): String {
        val sb = StringBuilder()
        if(s.replace("-", "").isEmpty()) return ""
        for((index, chars) in s.replace("-","").reversed().withIndex()){
            var c = chars
            if(chars in 'a'..'z'){
                c -= 32
            }
            if(index % k == 0) sb.append("-").append(c)
            else sb.append(c)
        }
        return sb.reversed().toString().substring(0 , sb.length - 1)
    }


}