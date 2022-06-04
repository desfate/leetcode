package com.chengdu.leetcode.demo

/**
 * 将一个整数 转换成32位的状态
 *
 * kotlin 常见操作
 * 按位或 or
 * 按位与 and
 * 按位异或 xor
 * 按位非 inv
 * 左移 shl
 * 右移 shr
 * 无符号左移 ushl
 * 无符号右移 ushr
 *
 *
 * for example
 * 1 =  0000 0000 0001
 */
class Code06 {

    fun intTo32(number : Int): String{
        // 通过位运算处理
        var sum = ""
        for (value in 31 downTo 0){
            sum += if(number.and((1).shl(value)) == 0){
                0
            }else{
                1
            }
        }
        return sum
    }

    fun intToB(number: Int): Int{
        return number.inv() + 1
    }

}
