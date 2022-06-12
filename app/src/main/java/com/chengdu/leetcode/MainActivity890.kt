package com.chengdu.leetcode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlin.math.absoluteValue

/**
 *  查找和替换模式 双百kotlin
 */
class MainActivity890 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findAndReplacePattern(arrayOf("abc","deq","mee","aqq","dkd","ccc"), "abb")
    }

    private fun findAndReplacePattern(words: Array<String>, pattern: String): List<String> {
        // key 是生成后的规则  value是匹配的数组
        val hashMap = hashMapOf<String, ArrayList<String>>()
        // 1.生成便于搜索的结构
        words.forEach {
            // 将每个字符串转化成对应的规则
            val rule = stringToRule(it)
            if(hashMap.containsKey(rule)){
                hashMap[rule]!!.add(it)
            }else{
                hashMap[rule] = arrayListOf(it)
            }
        }

        return hashMap[pattern] ?: listOf<String>() .toList()
    }

    private fun stringToRule(word: String): String{
        var start = 'a'
        var prv = '1'
        var result = ""

        word.forEachIndexed { index, c ->
            if (index == 0){
                result += start
                prv = c
            }else{
                if(c == prv){
                    result += start
                }else{
                    start ++
                    result += start
                    prv = c
                }
            }
        }
        return result
    }



}

