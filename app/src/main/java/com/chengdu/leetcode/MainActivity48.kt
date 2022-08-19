package com.chengdu.leetcode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlin.text.StringBuilder
// https://leetcode.cn/problems/rotate-image/
class MainActivity48 : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun rotate(matrix: Array<IntArray>): Unit {
        // 顺时针旋转
        // n层的旋转 = 第n层的旋转 + n - 1的旋转
        var n = matrix.size
        var swap = -1
        // 从第二层的旋转 可以看出来

        // 从 0， 0 开始
        swap = matrix[0][0]

    }



}

