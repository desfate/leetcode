package com.chengdu.leetcode.classify.greedy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.chengdu.leetcode.R

class MainActivity45 : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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

}

