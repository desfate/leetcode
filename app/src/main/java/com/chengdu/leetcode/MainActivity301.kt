package com.chengdu.leetcode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlin.math.absoluteValue

class MainActivity301 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        removeInvalidParentheses("((())(()(()(")
    }

    fun removeInvalidParentheses(s: String): List<String> {
        // 首先先计算一遍有几个符号不合理
        // 括号一般都是从左边开始  右边结束
        var right = 0   // 可以删除的右边括号
        var left = 0    // 可以删除的左边括号
        s.forEach {
            if(it == '('){
                left ++
            }else if(it == ')'){
                if(left == 0){  // 如果左边没有括号 又出现右边 则这个右边是多余的
                    right ++
                }else{
                    left --
                }
            }
        }
        findPossible(0, left, right, 0, 0, s)
        return res
    }
    val res = arrayListOf<String>()

    // 这里使用递归的方法找到所有可能的情况
    /**
     * key 是记录当前这次递归是从第几个字符串开始的
     * removeLeft: 左边括号剩余可移除数量 removeRight：右括号 left：已经使用的左括号 right：已经使用的右括号数目
     */
    fun findPossible(key: Int, removeLeft: Int, removeRight: Int, left: Int , right: Int, result: String ){
        System.out.println("@@@@"+result)
        var rightSum = right
        var leftSum = left

        if(removeLeft == 0 && removeRight == 0){ // 左右都已经移除完毕
            // 交验一下当前字符串是否满足要求
            if(isValid(result)){
                res.add(result)
            }
            return
        }

        for(index in key until result.length){
            if (index != key && result[index] == result[index - 1]) {  // 如果又连续一样的括号 那我们无论删除哪一个 生成的结果都是一样的
                continue;
            }
            if(removeLeft + removeRight > result.length - index){  // 还需要删除的括号数量大于剩余字符串长度
                return
            }
            if(removeLeft > 0 && result[index] == '('){  // 删除左括号
                findPossible(index, removeLeft - 1, removeRight, leftSum, rightSum, result.substring(0, index) + result.substring(index + 1))
            }
            if(removeRight > 0 && result[index] == ')'){ // 删除右括号
                findPossible(index, removeLeft, removeRight - 1, leftSum, rightSum, result.substring(0, index) + result.substring(index + 1))
            }
            if(result[index] == '('){
                leftSum ++
            }else if(result[index] == ')') {
                rightSum ++
            }
            if(right > left){
                break
            }
        }

    }



    /**
     * 交验字符串是否合法 这里不进行顺序交验 顺序交验交给上层逻辑
     */
    fun isValid(str: String): Boolean{
        var sum = 0
        str.forEach {
            if(it == '('){
                sum ++
            }else if(it ==')'){
                sum --
                if(sum < 0) return false
            }
        }
        return sum == 0
    }

}

