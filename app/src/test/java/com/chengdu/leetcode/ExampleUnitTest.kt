package com.chengdu.leetcode

import com.chengdu.leetcode.demo.Code06
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }


    @Test
    fun code6Test(){
        println(Code06().intTo32(-1))
        println(Code06().intToB(0))
    }
}