package com.chengdu.leetcode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlin.math.absoluteValue

class MainActivity335 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun isSelfCrossing(distance: IntArray): Boolean {
        var a = 0
        var b = 0
        var c = 0
        var d = 0
        // 4个分一组 不满4个的补0
        distance.forEachIndexed { index, i ->
            if(index % 4 == 0 && a == 0){
                a = i
            }else if(index % 4 == 1 && b == 0){
                b = i
            }else if(index % 4 == 2 && c == 0){
                c = i
            }else if(index % 4 == 3 && d == 0){
                d = i
                if(checkWithFour(a, b, c, d)) return true
                else {
                    //还原数据
                    a = 0
                    b = 0
                    c = 0
                    d = 0
                }
            }else if(index == distance.size - 1){
                return false
            }
        }
        return false
    }

    /**
     * 四个为一组 交验是否相交
     */
    fun checkWithFour(a: Int, b: Int, c: Int, d: Int):Boolean{
        if(a == 0 || b ==0 || c ==0 || d ==0 ) return false
        return c <= a && b <= d
    }

}

