package com.chengdu.leetcode.classify.dynamic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.chengdu.leetcode.R
import kotlin.text.StringBuilder

/**
 * 给你一个整数 n，请返回长度为 n 、仅由元音 (a, e, i, o, u) 组成且按 字典序排列 的字符串数量。

字符串 s 按 字典序排列 需要满足：对于所有有效的 i，s[i] 在字母表中的位置总是与 s[i+1] 相同或在 s[i+1] 之前。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/count-sorted-vowel-strings
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class MainActivity1641 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val n = 2
        val list = arrayListOf("a", "e", "i", "o", "u")
        violence("", list, 0, 2)
    }

    val ansList = ArrayList<String>()

    // 暴力法
    fun violence(ans: String, list: ArrayList<String>, start: Int, n: Int) {
        if (list.size - start - 1 < n) return
        if (n == start + 1 && ans.length == n)  ansList.add(ans)
        for (index in start until n){
            violence(ans + list[index], list, index, n)
        }
    }
    fun dynamic(n: Int) {
        val dp = IntArray(5)
        dp.fill(1)
        for (index2 in 1 until n) {
            for (index in 1..4) {
                dp[index] += dp[index - 1]
            }
        }
    }



}

