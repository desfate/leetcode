package com.chengdu.leetcode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.*

class MainActivity352 : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }


    class SummaryRanges() {
        val map: TreeMap<Int, Int> = TreeMap()  // key 是 start ， value 是 end
        fun addNum(`val`: Int) {
            val intervalLeft = map.floorEntry(`val`)  // 左侧的迭代器 负责找到左侧最接近的key（start）
            val internalRight = map.ceilingEntry(`val`)  // 右侧迭代器 负责找到右侧最接近的key（start）
            when{
                // 如果这个数字在一个区间内 min = intervalLeft.key， max = intervalLeft.value
                intervalLeft != null && intervalLeft.key <= `val` && intervalLeft.value >= `val` -> return
                // 这个数字链接左右两个区间
                intervalLeft != null && internalRight != null && intervalLeft.value + 1 == `val` && internalRight.key - 1 == `val` ->{
                    // 移除原有区间
                    map.remove(intervalLeft.key)
                    map.remove(internalRight.key)
                    map[intervalLeft.key] = internalRight.value
                }
                // 如果这个数字在一个区间的左侧或是右侧
                // 左侧 min = min(val, internalRight.key)  max = internalRight.value
                internalRight != null && internalRight.key - 1 == `val` -> {
                    // 左侧由于变动的是key 所以要移除旧key
                    map[internalRight.key - 1] = internalRight.value
                    map.remove(internalRight.key)
                }
                // 右侧 min = intervalLeft.key  max = max(intervalLeft.value, val)
                intervalLeft != null && intervalLeft.value + 1 == `val` -> {
                    // 右侧由于变动的是value 则 直接value + 1
                    map[intervalLeft.key] = intervalLeft.value + 1
                }
                // 不属于任何区间
                else -> {
                    map[`val`] = `val`
                }
            }
        }

        fun getIntervals(): Array<IntArray> {
            val result = arrayOfNulls<IntArray>(map.size)
            var index = 0
            map.forEach { (key, value) ->
                val array = IntArray(2)
                array[0] = key
                array[1] = value
                result[index] = array
                index ++
            }
            return result as Array<IntArray>
        }
    }
}

