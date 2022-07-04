package com.chengdu.leetcode

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import java.util.*


/**
请你帮忙给从 1 到 n 的数设计排列方案，使得所有的「质数」都应该被放在「质数索引」（索引从 1 开始）上；你需要返回可能的方案总数。

让我们一起来回顾一下「质数」：质数一定是大于 1 的，并且不能用两个小于它的正整数的乘积来表示。

由于答案可能会很大，所以请你返回答案 模 mod 10^9 + 7 之后的结果即可。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/prime-arrangements
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class MainActivity1175 {

    fun numPrimeArrangements(n: Int): Int {
        return 0
    }


    fun isPrime(number: Int): Boolean{
        if(number == 1) return false
        var v = 2
        while (v * v <= number){
            v++
            if(number % v == 0){
                return false
            }
        }
        return true
    }
}

