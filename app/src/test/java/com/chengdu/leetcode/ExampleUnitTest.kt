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

    @Test
    fun test(){
//        println(findAndReplacePattern(arrayOf("abc","deq","mee","aqq","dkd","ccc"), "abb"))
        println(stringToRule("csccs"))
    }

    fun findAndReplacePattern(words: Array<String>, pattern: String): List<String> {
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
        return hashMap[stringToRule(pattern)] ?: listOf<String>() .toList()
    }

    private fun stringToRule(word: String): String{
        var start = 'a'
        val prvMap = hashMapOf<Char, Char>()
        var result = ""

        word.forEachIndexed { index, c ->
            if (index == 0){
                result += start
                prvMap[c] = start
            }else{
                if(prvMap.containsKey(c)){
                    result += prvMap[c]
                }else{
                    start ++
                    result += start
                    prvMap[c] = start
                }
            }
        }
        return result
    }
}