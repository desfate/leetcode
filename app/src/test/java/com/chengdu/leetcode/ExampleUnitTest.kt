package com.chengdu.leetcode

import com.chengdu.leetcode.demo.Code06
import org.junit.Test

import org.junit.Assert.*
import kotlin.math.min

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

    @Test
    fun Test2(){
        var tagList = IntArray(6)
        tagList[0] = 1
        tagList[1] = 1
        tagList[2] = 4
        tagList[3] = 2
        tagList[4] = 1
        tagList[5] = 3
        quickSork(tagList, 0, 5)
        tagList
    }


    fun quickSork(tagList: IntArray, start: Int, end: Int){
        if(start >= end){
            return
        }

        // 如何寻找当前点的位置
        // 双边指针
        var pivot = PointSwap(tagList, start, end)
        // 单边指针

        quickSork(tagList, start, pivot - 1)
        quickSork(tagList, pivot + 1, end)
    }

    fun PointSwap(tagList: IntArray, start: Int, end: Int): Int{
        val pivot = tagList[start]
        var leftPoint: Int = start
        var rightPoint: Int = end
        while (
            leftPoint < rightPoint
        ){
            while ((leftPoint < rightPoint) && tagList[end] > pivot){
                rightPoint --
            }

            while ((leftPoint < rightPoint) && tagList[start] < pivot){
                leftPoint ++
            }

            if(leftPoint < rightPoint){
                val temp = tagList[rightPoint]
                tagList[rightPoint] = tagList[leftPoint]
                tagList[leftPoint] = temp
            }
        }
        // 最终将分界值与当前指针数据交换
        tagList[start] = tagList[rightPoint];
        tagList[rightPoint] = pivot;
        // 返回分界值所在下标
        return rightPoint;
    }



    // 这种题目肯定是动态规划
    // 先用暴力破解
    @Test
    fun testsss(){

        val int1 = IntArray(3)
        int1[0] = 17
        int1[1] = 2
        int1[2] = 17
        val int2 = IntArray(3)
        int2[0] = 16
        int2[1] = 16
        int2[2] = 5
        val array = arrayOf<IntArray>(int1,int2)

    }






}