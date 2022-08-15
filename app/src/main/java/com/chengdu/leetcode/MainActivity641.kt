package com.chengdu.leetcode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.*

class MainActivity641 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
    class MyCircularDeque(val k: Int) {
        private val linkList = LinkedList<Int>()
        fun insertFront(value: Int): Boolean {
            return if(linkList.size < k){
                linkList.addFirst(value)
                true
            }else{
                false;
            }
        }

        fun insertLast(value: Int): Boolean {
            return if(linkList.size < k){
                linkList.addLast(value)
                true
            }else{
                false;
            }
        }

        fun deleteFront(): Boolean {
            if(linkList.size != 0){
                linkList.removeFirst()
                return true
            }else{
                return false
            }
        }

        fun deleteLast(): Boolean {
            if(linkList.size != 0){
                linkList.removeLast()
                return true
            }else{
                return false
            }
        }

        fun getFront(): Int {
            if(linkList.isEmpty()){
                return -1
            }
            return linkList.first
        }

        fun getRear(): Int {
            if(linkList.isEmpty()){
                return -1
            }
            return linkList.last
        }

        fun isEmpty(): Boolean {
            return linkList.isEmpty()
        }

        fun isFull(): Boolean {
            return linkList.size == k
        }

    }


}

