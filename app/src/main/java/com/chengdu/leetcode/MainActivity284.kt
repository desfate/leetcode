package com.chengdu.leetcode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.lang.StringBuilder

class MainActivity284 : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        var obj = PeekingIterator(arr)
//        var param_1 = obj.next()
//        var param_2 = obj.peek()
//        var param_3 = obj.hasNext()
    }

    class PeekingIterator(val iterator: Iterator<Int>) : Iterator<Int> {
        var nextValue: Int? = null

        init {
            nextValue = iterator.next()
        }


        fun peek(): Int? {
            return nextValue
        }

        override fun next(): Int {
            val value = if(nextValue == null){0}else{nextValue}
            nextValue = if(iterator.hasNext()){iterator.next()}else{null}
            return value!!
        }

        override fun hasNext(): Boolean {
            return nextValue != null
        }
    }
}

//

