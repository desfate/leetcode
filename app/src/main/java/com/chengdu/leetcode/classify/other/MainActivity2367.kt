package com.chengdu.leetcode.classify.other

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.max
import kotlin.math.min
import kotlin.text.StringBuilder

/**
给你一个下标从 0 开始、严格递增 的整数数组 nums 和一个正整数 diff 。如果满足下述全部条件，则三元组 (i, j, k) 就是一个 算术三元组 ：

i < j < k ，
nums[j] - nums[i] == diff 且
nums[k] - nums[j] == diff
返回不同 算术三元组 的数目。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/number-of-arithmetic-triplets
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class MainActivity2367 : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val array = intArrayOf(0,1,4,6,7,10)
        //(1,3,2,1,3)
        //（4,5,6,7,8,9）
        //(1,1,1,1,1)


        //转换成求公差和 并满足排序要求




    }

    //
    fun arithmeticTriplets(nums: IntArray, diff: Int): Int {
        // 将数组转换为差值数组
        val list: ArrayList<Int> = nums.mapIndexed { index, i ->
            if (index > 0 && index < nums.size - 1){
                return nums[index + 1] - i
            }
        }.toMutableList() as ArrayList<Int>

        // 循环判断差值数组是否满足条件
        // 至少需要循环 n 次  等于消耗 n 平方
        var result  = 0
        var key = 0
        while (key < list.size){
            var start = key
            var sum = 2 * diff
            while (start < list.size){
                if(list[start] < sum){
                    sum -= list[start]
                    start ++
                }else if(list[start] == sum){
                    result += 1
                }else{
                    continue
                }
            }
            key++
        }
        return result
    }

}

