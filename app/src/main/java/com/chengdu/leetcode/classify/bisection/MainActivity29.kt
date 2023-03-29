package com.chengdu.leetcode.classify.bisection

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.chengdu.leetcode.R

class MainActivity29 : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val a = divide(-2147483648,-1)
        System.out.println(a)
    }

    var minIndex = 0L     // 这个是index min  这个是结果
    var maxIndex = 0L     // index max
    var min : Long = 0   // 注意越界 所以用long minIndex * divisor
    var max : Long = 0
    var isPlus = true
    var mid = 0L
    var ans = 0

    fun divide(dividend: Int, divisor: Int): Int {
        // 考虑被除数为最小值的情况
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == 1) {
                return Integer.MIN_VALUE;
            }
            if (divisor == -1) {
                return Integer.MAX_VALUE;
            }
        }
        // 考虑除数为最小值的情况
        if (divisor == Integer.MIN_VALUE) {
            return  if(dividend ==Integer.MIN_VALUE){ 1 }else{ 0 }
        }
        // 考虑被除数为 0 的情况
        if (dividend == 0) {
            return 0;
        }

        // 处理符号
        if((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)){
            isPlus = false
        }
        var left = 1
        var right = Int.MAX_VALUE
        var ans = 0
        // 通过迭代调用缩小最大最小范围
//        rec(dividend.toLong().absoluteValue, divisor.toLong().absoluteValue, 1)
        // 这里用二分法
        while (left <= right) {
            // 注意溢出，并且不能使用除法
            mid = minIndex + ((right - left) shr 1)
            val check = quickAdd(divisor, mid.toInt(), dividend);
            if (check) {
                ans = mid.toInt()
                // 注意溢出
                if (mid > Integer.MAX_VALUE) {
                    break
                }
                left = (mid + 1).toInt()
            } else {
                right = (mid - 1).toInt();
            }
        }
        return ans
    }

    //确定范围
    fun rec(dividend: Long, divisor: Long, index: Long){
        val sum = divisor + divisor
        val sumIndex = index.toLong() + index
        if(dividend > sum){
            min = sum
            minIndex = sumIndex
            rec(dividend, sum, sumIndex)
        }else{
            max = sum
            maxIndex = sumIndex
        }
    }

    // 快速乘
    fun quickAdd(y: Int,z: Int,x: Int): Boolean {
        // x 和 y 是负数，z 是正数
        // 需要判断 z * y >= x 是否成立
        var result = 0
        var add = y
        while (z != 0) {
            if ((z and 1) != 0) {
                // 需要保证 result + add >= x
                if (result < x - add) {
                    return false;
                }
                result += add;
            }
            if (z != 1) {
                // 需要保证 add + add >= x
                if (add < x - add) {
                    return false;
                }
                add += add;
            }
            // 不能使用除法
            mid = (z shr 1).toLong()
        }
        return true;
    }
}

