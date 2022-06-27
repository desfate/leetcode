package com.chengdu.leetcode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlin.math.absoluteValue
import kotlin.math.max

/**
 * 给定字符串列表 strs ，返回其中 最长的特殊序列 。如果最长特殊序列不存在，返回 -1 。

特殊序列 定义如下：该序列为某字符串 独有的子序列（即不能是其他字符串的子序列）。

 s 的 子序列可以通过删去字符串 s 中的某些字符实现。

例如，"abc" 是 "aebdc" 的子序列，因为您可以删除"aebdc"中的下划线字符来得到 "abc" 。"aebdc"的子序列还包括"aebdc"、 "aeb" 和 "" (空字符串)。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/longest-uncommon-subsequence-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class MainActivity522 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    fun findLUSlength(strs: Array<String>): Int {
        var results = -1
        // 每个字符串都和其他字符串比较一次 判断a是否是b的独有子序列
        // 如果是则可以滚蛋
        if(strs.isEmpty()) return 0;
        else if(strs.size == 1) return strs[0].length;
        else{
            strs.forEachIndexed forEach1@{ index1, s1 ->
                var isCompare = true
                strs.forEachIndexed forEach2@{ index2, s2 ->
                    if(index1 != index2){
                        if(compareStr(s1,s2)) {
                            isCompare = false
                            return@forEach1
                        }
                    }
                }
                if(isCompare){
                    results = max(results, s1.length)
                }
            }
        }
        return results;
    }

    fun compareStr(target:String, compare:String): Boolean{
        // 双指针
        var pointT = 0
        var pointC = 0
        while (pointT != target.length - 1 && pointC != compare.length - 1){
            if(target[pointT] == compare[pointC]){
                pointT ++
            }
            pointC ++
        }
        return pointT == target.length
    }
}