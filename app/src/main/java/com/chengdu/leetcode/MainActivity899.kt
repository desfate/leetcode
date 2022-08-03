package com.chengdu.leetcode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.*
import kotlin.math.absoluteValue

/**
 *  查找和替换模式 双百kotlin
 */
class MainActivity899 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }



    fun orderlyQueue(s: String, k: Int): String {
        // 题目可以转换为  从前n个字符中 找到比n+1更小的  并移动到最后
        // 1.循环处理上述逻辑
        // 2.如何设计数据结构 更容易操作 （链表）

        if (s.length == k) return s.toSortedSet().toList().joinToString { "" }

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
                var maxIndex = 0
                link.forEachIndexed { index, c ->
                    if (index <= k - 1) {
                        max = if (max > c) {
                            max
                        } else {
                            maxIndex = index
                            c
                        }
                    }
                }
                if (max > s[k + 1]) {
                    link.addLast(max)
                    link.removeAt(maxIndex)
                } else {
                    isFinish = true
                }
            }
        }
        return s
    }


}

