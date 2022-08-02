package com.chengdu.leetcode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlin.math.max

class MainActivity622 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



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
            if(curSize == 0){
                root = ListNode(value)
                last = root
                curSize = 1
            }else if(curSize < maxSize){
                last!!.next = ListNode(value)
                last = last!!.next
                curSize ++
            }else{
                return false
            }
            return true
        }

        fun deQueue(): Boolean {
            return if(root != null){
                root = if(root!!.next != null) root!!.next
                else null
                curSize --
                true
            }else{
                false
            }
        }

        fun Front(): Int {
            return if(curSize == 0) -1
            else root!!.`val`
        }

        fun Rear(): Int {
            return if(curSize == 0) -1
            else last!!.`val`
        }

        fun isEmpty(): Boolean {
            return curSize == 0
        }

        fun isFull(): Boolean {
            return curSize == maxSize
        }

    }

}

