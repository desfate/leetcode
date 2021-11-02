package com.chengdu.leetcode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.*
import kotlin.math.absoluteValue

class MainActivity237 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun deleteNode(node: ListNode?) {
//        val li = node!!.next!!.next
        // 题目已经定义了 当前节点后面肯定有节点
        // 复制后方节点
        node?.`val` = node?.next!!.`val`
//        // 删除后方节点
//        node.next!!.next = null
        // 链接节点
        node.next = node.next?.next
    }



     var li = ListNode(5)
     var v = li.`val`
     class ListNode(var `val`: Int) {
         var next: ListNode? = null
     }

}

