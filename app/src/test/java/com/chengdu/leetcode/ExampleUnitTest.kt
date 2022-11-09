package com.chengdu.leetcode

import com.chengdu.leetcode.algorithm.TreeNode
import com.chengdu.leetcode.algorithm.sorts.SelectSorts
import com.chengdu.leetcode.demo.Code06
import org.junit.Test

import org.junit.Assert.*
import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.abs
import kotlin.math.max
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
    fun mTest5() {
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
            tagList0, tagList1, tagList2, tagList3
        )
        containVirus(list)
    }

    fun containVirus(isInfected: Array<IntArray>) {
        isInfected.forEachIndexed { indexI, i ->
            isInfected[indexI].forEachIndexed { indexJ, j ->
                if (isInfected[indexI][indexJ] == 1) {  // 我是病毒 尝试向四周扩散
                    // 判断上下左右扩散的可行性
                    if (indexI - 1 >= 0 && isInfected[indexI - 1][indexJ] == 0) {
                        isInfected[indexI - 1][indexJ] = -1  // 向上扩散
                    }
                    if (indexI + 1 <= isInfected.size - 1 && isInfected[indexI + 1][indexJ] == 0) {
                        isInfected[indexI + 1][indexJ] = -1  // 向下扩散
                    }
                    if (indexJ + 1 <= isInfected[indexI].size - 1 && isInfected[indexI][indexJ + 1] == 0) {
                        isInfected[indexI][indexJ + 1] = -1  // 向右扩散
                    }
                    if (indexJ - 1 >= 0 && isInfected[indexI][indexJ - 1] == 0) {
                        isInfected[indexI][indexJ - 1] = -1  // 向左扩散
                    }
                }
            }
        }
        print(isInfected.contentDeepToString())
    }


    @Test
    fun mTest6() {
        var tagList0 = IntArray(4)
        tagList0[0] = 1
        tagList0[1] = 2
        tagList0[2] = 3
        tagList0[3] = 4
        distanceBetweenBusStops(tagList0, 0, 3)
    }

    fun distanceBetweenBusStops(distance: IntArray, start: Int, destination: Int): Int {
        var right = start
        var left = destination
        if (right > left) {
            right = left.apply { left = right }
        }

        var rightSum = 0
        var leftSum = 0
        for (index in distance.indices) {
            if (index in right until left) {
                rightSum += distance[index]
            } else {
                leftSum += distance[index]
            }
        }
        return min(rightSum, leftSum)
    }

    @Test
    fun mTest7() {
        //[37,12,28,9,100,56,80,5,12]
        var tagList0 = IntArray(9)
        tagList0[0] = 37
        tagList0[1] = 12
        tagList0[2] = 28
        tagList0[3] = 9
        tagList0[4] = 100
        tagList0[5] = 56
        tagList0[6] = 80
        tagList0[7] = 5
        tagList0[8] = 12
        arrayRankTransform(tagList0)
    }

    fun arrayRankTransform(arr: IntArray): IntArray {
        val sortedList = arr.sortedArray()
        return arr.map {
            sortedList.indexOf(it) + 1
        }.toIntArray()
    }

    @Test
    fun mTest8() {
        var tagList0 = IntArray(2)
        tagList0[0] = 0
        tagList0[1] = 0
        var tagList1 = IntArray(2)
        tagList1[0] = 1
        tagList1[1] = 1
        var tagList2 = IntArray(2)
        tagList2[0] = 1
        tagList2[1] = 0
        var tagList3 = IntArray(2)
        tagList3[0] = 0
        tagList3[1] = 1
        validSquare(tagList0, tagList1, tagList2, tagList3)
    }

    fun validSquare(p1: IntArray, p2: IntArray, p3: IntArray, p4: IntArray): Boolean {
        // 找到一个正确的循环
        // 最大的y  最小的x  最小的y  最大的x




        // 四个点  3 3 之间 积为 -1
        return getX(p1, p3, p2) && getX(p3, p2, p4) && getX(p2, p4, p1) && getX(p4, p1, p3)
    }


    fun getX(p1: IntArray, p2: IntArray, p3: IntArray): Boolean {
        // k p1 p2 和 k p1 p3 的乘积为 -1
        if (p1[0] - p2[0] == 0) {
            return p2[0] - p3[0] != 0 && p2[1] - p3[1] == 0
        }
        if (p2[0] - p3[0] == 0) {
            return p1[0] - p2[0] != 0 && p1[1] - p2[1] == 0
        }

        val k1 = (p1[1] - p2[1]) / (p1[0] - p2[0])
        val k2 = (p2[1] - p3[1]) / (p2[0] - p3[0])
        return k1 * k2 == -1
    }


    @Test
    fun mTest9() {
        var tagList0 = IntArray(5)
        tagList0[0] = 2
        tagList0[1] = 3
        tagList0[2] = 1
        tagList0[3] = 1
        tagList0[4] = 4
        jump(tagList0)
    }

    var min = Int.MAX_VALUE

    fun jump(nums: IntArray): Int {

        if (nums.size == 1) return 0
        // 将数组转换成 start end 模式
        var arrays = nums.mapIndexed { index, i ->
            index + i
        }

        findNext(arrays.toIntArray(), 0)
        return min
    }

    fun findNext(nums: IntArray, result: Int) {
        // 递归寻找符合跳跃条件的数组
        nums.forEachIndexed { index, i ->
            if (i >= nums.size - 1) {
                if (index == 0) {
                    min = if (min < result + 1) {
                        min
                    } else {
                        result + 1
                    }
                }
                findNext(nums.take(index).toIntArray(), result + 1)
            }
        }
    }

    @Test
    fun Test10() {
        val queue = MyCircularQueue(3)
        queue.enQueue(2)
        queue.enQueue(3)
        queue.enQueue(4)
    }

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    class MyCircularQueue(k: Int) {

        val maxSize = k
        var curSize = 0
        var root: ListNode? = null
        var last: ListNode? = null

        fun enQueue(value: Int): Boolean {
            if (curSize == 0) {
                root = ListNode(value)
                last = root
                curSize = 1
            } else if (curSize < maxSize) {
                last!!.next = ListNode(value)
                last = last!!.next
                curSize++
            } else {
                return false
            }
            return true
        }

        fun deQueue(): Boolean {
            return if (root != null) {
                root = if (root!!.next != null) root!!.next
                else null
                curSize--
                true
            } else {
                false
            }
        }

        fun Front(): Int {
            return if (curSize == 0) -1
            else root!!.`val`
        }

        fun Rear(): Int {
            return if (curSize == 0) -1
            else last!!.`val`
        }

        fun isEmpty(): Boolean {
            return curSize == 0
        }

        fun isFull(): Boolean {
            return curSize == maxSize
        }

    }


    @Test
    fun Test11() {

        orderlyQueue("hmg", 2)
    }


    fun orderlyQueue(s: String, k: Int): String {
        // 题目可以转换为  从前n个字符中 找到比n+1更小的  并移动到最后
        // 1.循环处理上述逻辑
        // 2.如何设计数据结构 更容易操作 （链表）
        var arr = s.toCharArray()
        arr.sort()
        if (s.length == k) return arr.toList().joinToString("")

        val link = LinkedList<Char>()
        s.forEach {
            link.add(it)
        }
        var isFinish = false
        // 对链表处理上述逻辑
        if (k < s.length) {
            while (!isFinish) {
                // 从前k个里面中找到最大的
                var max = link.first()
                var min = s.last()
                var maxIndex = 0
                link.forEachIndexed { index, c ->
                    if (index < k) {
                        max = if (max >= c) {
                            max
                        } else {
                            maxIndex = index
                            c
                        }
                    } else {
                        min = if (min <= c) {
                            min
                        } else {
                            c
                        }
                    }
                }
                if (max > min) {
                    link.addLast(max)
                    link.removeAt(maxIndex)
                } else {
                    isFinish = true
                }
            }
            return link.toList().joinToString("")
        }
        return s
    }


    @Test
    fun Test12() {
        var tagList0 = IntArray(5)
        tagList0[0] = 4
        tagList0[1] = 4
        tagList0[2] = 7
        tagList0[3] = 6
        tagList0[4] = 7
        minSubsequence(tagList0)
    }


    fun minSubsequence(nums: IntArray): List<Int> {
        if (nums.size == 1) return nums.toList()
        // 先排序  排序之后  双指针 计算
        val list = nums.sortedArray()
        var start = 0
        var end = nums.size - 1
        var sumStart = list[0]
        var sumEnd = list[end]
        while (start != end) {
            if (sumStart >= sumEnd) {
                end--
                sumEnd += list[end]
            } else {
                start++
                sumStart += list[start]
            }
        }
        return list.takeLast(nums.size - end).reversed()
    }

//
//    @Test
//    fun mTest9() {
//        val root = TreeNode(1)
//
//        root.left = TreeNode(1)
//        root.right = TreeNode(0)
//        root.right!!.right = TreeNode(9)
//        root.right!!.left = TreeNode(-7)
//        root.left!!.left = TreeNode(7)
//        root.left!!.right = TreeNode(-8)
//
//        maxLevelSum(root)
//    }
//
//
//    val hashMap = hashMapOf<Int, Int>()
//
//    fun maxLevelSum(root: TreeNode?): Int {
//        // 直接遍历  然后将每层的信息统计到hashmap中  key是层数  value是每层节点之和
//        dfs(root, 1)
//        var max = Int.MIN_VALUE
//        hashMap.forEach { (_, u) ->
//            if (u > max) max = u
//        }
//
//        hashMap.forEach { (i, u) ->
//            if(u == max){
//                return i
//            }
//        }
//
//        return 0
//    }
//    // 问题一  带层数的遍历
//
//    // 前序遍历  根左右  递归  （需要记录层数）
//    fun dfs(root: TreeNode?, layer: Int) {
//        if (root == null) {
//            return
//        }
//        val value = hashMap.getOrDefault(layer, 0)
//        hashMap[layer] = root.`val` + value
//        dfs(root.left, layer + 1)
//        dfs(root.right, layer + 1)
//    }

    /**
     * [1,1,1,2,2,2,3,3,3,4,4,4,5]
     * [10,2,8,9,3,8,1,5,2,3,7,6]
     */
    @Test
    fun test10086(){

        val array1 = IntArray(18)
        array1[0] = 10
        array1[1] = 2
        array1[2] = 8
        array1[3] = 9
        array1[4] = 3
        array1[5] = 8
        array1[6] = 1
        array1[7] = 5
        array1[8] = 2
        array1[9] = 3
        array1[10] = 7
        array1[11] = 6
        maxEqualFreq(array1);
    }

    var max = 0
    val hashMap = hashMapOf<Int, Int>()
    fun maxEqualFreq(nums: IntArray): Int {
        nums.forEachIndexed { index, i ->
            val value = hashMap.getOrDefault(i, 0)
            hashMap[i] = value + 1
            if(isFreq()){
                max = max(max, index + 1)
            }
        }
        return max
    }

    // 判断通过hashmap值合并后是否只有两个值  且两个值的差值 只有1
    fun isFreq(): Boolean {
        val set = hashMap.map {
            it.value
        }.toSet()
        var first = -1
        if (set.size == 2) {
            set.toList().sorted().forEach {
                if (first == -1) {
                    first = it
                } else {
                    if(first == 1 || it == 1) return true
                    return kotlin.math.abs(first - it) == 1
                }
            }
        }
        return false
    }

    @Test
    fun testSortSelected(){
        SelectSorts().test()
    }
}