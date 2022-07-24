package com.chengdu.leetcode

import com.chengdu.leetcode.demo.Code06
import org.junit.Test

import org.junit.Assert.*
import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.abs
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
    fun code6Test() {
        println(Code06().intTo32(-1))
        println(Code06().intToB(0))
    }

    @Test
    fun test() {
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
            if (hashMap.containsKey(rule)) {
                hashMap[rule]!!.add(it)
            } else {
                hashMap[rule] = arrayListOf(it)
            }
        }
        return hashMap[stringToRule(pattern)] ?: listOf<String>().toList()
    }

    private fun stringToRule(word: String): String {
        var start = 'a'
        val prvMap = hashMapOf<Char, Char>()
        var result = ""

        word.forEachIndexed { index, c ->
            if (index == 0) {
                result += start
                prvMap[c] = start
            } else {
                if (prvMap.containsKey(c)) {
                    result += prvMap[c]
                } else {
                    start++
                    result += start
                    prvMap[c] = start
                }
            }
        }
        return result
    }

    @Test
    fun Test2() {
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


    fun quickSork(tagList: IntArray, start: Int, end: Int) {
        if (start >= end) {
            return
        }

        // 如何寻找当前点的位置
        // 双边指针
        var pivot = PointSwap(tagList, start, end)
        // 单边指针

        quickSork(tagList, start, pivot - 1)
        quickSork(tagList, pivot + 1, end)
    }

    fun PointSwap(tagList: IntArray, start: Int, end: Int): Int {
        val pivot = tagList[start]
        var leftPoint: Int = start
        var rightPoint: Int = end
        while (
            leftPoint < rightPoint
        ) {
            while ((leftPoint < rightPoint) && tagList[end] > pivot) {
                rightPoint--
            }

            while ((leftPoint < rightPoint) && tagList[start] < pivot) {
                leftPoint++
            }

            if (leftPoint < rightPoint) {
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

    @Test
    fun mTest() {
        println(isPrime(123344345))
    }

    fun isPrime(number: Int): Boolean {
        if (number == 1) return false
        var v = 2
        while (v * v <= number) {
            if (number % v == 0) {
                return false
            }
            v += 1
        }
        return true
    }

    @Test
    fun mTest2() {
        var tagList = IntArray(4)
        tagList[0] = 4
        tagList[1] = 2
        tagList[2] = 1
        tagList[3] = 3
        println(minimumAbsDifference(tagList))
    }

    // 提速
    fun minimumAbsDifference(arr: IntArray): List<List<Int>> {
        val result = arrayListOf<List<Int>>()
        var min = Int.MAX_VALUE
        val arrs = arr.sortedBy { it }
        arrs.forEachIndexed { indexi, i ->
            if (indexi == arrs.size - 1) return result.toList().sortedBy { it[0] }
            val j = indexi + 1
            val cur = arrs[j] - i
            if (cur < min) {
                result.clear()
                result.add(
                    listOf(i, arrs[j])
                )
                min = cur
            } else if (cur == min) {
                result.add(
                    listOf(i, arrs[j])
                )
            }
        }
        return result.toList().sortedBy { it[0] }
    }

    @Test
    fun mTest3() {
        var dictionary = listOf("cat", "bat", "rat")
        replaceWords(dictionary, "the cattle was rattled by the battery")
    }

    fun replaceWords(dictionary: List<String>, sentence: String): String {
        val result = sentence.split(" ").toMutableList();
        if (sentence.isEmpty()) return ""
        result.forEachIndexed { i, it ->
            dictionary.forEach { dic ->
                if (it.startsWith(dic)) {
                    if (result[i].length > dic.length) {
                        result[i] = dic
                    }
                }
            }
        }
        val sb = StringBuffer()
        result.forEach {
            sb.append(" ")
            sb.append(it)
        }
        return sb.toString().substring(1, sb.toString().length)
    }

    @Test
    fun mTest4() {
        minIndex("kxeinco", "kxeinco", "kxeinco")
    }

    fun minIndex(pref: String, suff: String, value: String): Boolean {
        if (value.isNotEmpty()) {
            val start = value.indexOf(pref, 0, false)
            if (start == -1) return false
            val end = value.indexOf(suff, value.length - 1 - suff.length, false)
            if (end == -1) return false
            if (start < end) {
                return true
            } else if (start == end && pref == value) {
                return true
            }
        }
        return false
    }

    @Test
    fun mTest5(){
        var tagList0 = IntArray(4)
        tagList0[0] = 1
        tagList0[1] = 0
        tagList0[2] = 0
        tagList0[3] = 0
        var tagList1 = IntArray(4)
        tagList1[0] = 0
        tagList1[1] = 0
        tagList1[2] = 0
        tagList1[3] = 0
        var tagList2 = IntArray(4)
        tagList2[0] = 0
        tagList2[1] = 0
        tagList2[2] = 0
        tagList2[3] = 0
        var tagList3 = IntArray(4)
        tagList3[0] = 0
        tagList3[1] = 0
        tagList3[2] = 0
        tagList3[3] = 0
        val list = arrayOf<IntArray>(
            tagList0, tagList1,tagList2,tagList3
        )
        containVirus(list)
    }

    fun containVirus(isInfected: Array<IntArray>){
        isInfected.forEachIndexed { indexI, i ->
            isInfected[indexI].forEachIndexed { indexJ, j ->
                if(isInfected[indexI][indexJ] == 1){  // 我是病毒 尝试向四周扩散
                    // 判断上下左右扩散的可行性
                    if(indexI - 1 >= 0 && isInfected[indexI - 1][indexJ] == 0){
                        isInfected[indexI - 1][indexJ] = -1  // 向上扩散
                    }
                    if(indexI + 1 <= isInfected.size - 1 && isInfected[indexI + 1][indexJ] == 0){
                        isInfected[indexI + 1][indexJ] = -1  // 向下扩散
                    }
                    if(indexJ + 1 <= isInfected[indexI].size - 1 && isInfected[indexI][indexJ + 1] == 0){
                        isInfected[indexI][indexJ + 1] = -1  // 向右扩散
                    }
                    if(indexJ - 1 >= 0 && isInfected[indexI][indexJ - 1] == 0){
                        isInfected[indexI][indexJ - 1] = -1  // 向左扩散
                    }
                }
            }
        }
        print(isInfected.contentDeepToString())
    }
}