package com.chengdu.leetcode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlin.text.StringBuilder

class MainActivity38 : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        countAndSay(5)
    }

//    fun countAndSay(n: Int): String {
//        return if(n == 1) "1"
//        else NumtoSay(countAndSay(n - 1))
//    }
//
//    fun NumtoSay(num: String): String{
//        var start = 0
//        var end = 0
//        var sb = StringBuilder()
//        while (end <= num.length - 1){
//            if(end == num.length - 1){ // 我是最后一个了
//                if(start != end){
//                    sb.append( end - start + 1)
//                    sb.append(num[end])
//                    break
//                }else{
//                    sb.append(end - start + 1)
//                    sb.append(num[end])
//                    break
//                }
//            }
//
//            if(num[end + 1] == num[end]){
//                end ++
//                continue
//            }else{
//                sb.append(end - start + 1)
//                sb.append(num[end])
//                start = end + 1
//                end ++
//            }
//        }
//        return sb.toString()
//    }

    fun NumtoSay(num: String): String{
        val stringBuilder = StringBuilder()
        var key = 'a'
        var count = 0
        if(num.length == 1) return "1$num"
        num.forEachIndexed { index, c ->
            if(index == num.length - 1){  // 这是最后一个数字
                if(key == c){
                    count ++
                    stringBuilder.append(count)
                    stringBuilder.append(key)
                }else{
                    stringBuilder.append(count)
                    stringBuilder.append(key)
                    stringBuilder.append(1)
                    stringBuilder.append(c)
                }
            }else{
                if(key == c) count ++
                else{
                    if(key != 'a') {
                        stringBuilder.append(count)  // 记录上一个数
                        stringBuilder.append(key)
                    }
                    count = 1
                    key = c
                }
            }

        }
        return stringBuilder.toString()
    }
}

