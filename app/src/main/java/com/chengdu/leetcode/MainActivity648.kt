package com.chengdu.leetcode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity648 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun replaceWords(dictionary: List<String>, sentence: String): String {
        val result = sentence.split(" ").toMutableList();
        if (sentence.isEmpty()) return ""
        result.forEachIndexed { i, it ->
            dictionary.forEach { dic ->
                if (it.startsWith(dic)) {
                    if (result[i].length > dic.length) {
                        result[i] = dic
                    }
                }
            }
        }
        val sb = StringBuffer()
        result.forEach {
            sb.append(" ")
            sb.append(it)
        }
        return sb.toString().substring(1, sb.toString().length)
    }
}

