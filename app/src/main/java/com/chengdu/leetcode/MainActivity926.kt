package com.chengdu.leetcode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlin.math.absoluteValue

/**
 * 如果一个二进制字符串，是以一些 0（可能没有 0）后面跟着一些 1（也可能没有 1）的形式组成的，那么该字符串是 单调递增 的。

给你一个二进制字符串 s，你可以将任何 0 翻转为 1 或者将 1 翻转为 0 。

返回使 s 单调递增的最小翻转次数。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/flip-string-to-monotone-increasing
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class MainActivity926 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        minFlipsMonoIncr("1 0 1 1 1 1 1 1 1 1 1 0")
    }

}

