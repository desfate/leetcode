package com.chengdu.leetcode

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity1408 {

    fun stringMatching(words: Array<String>): List<String> {
        val result = arrayListOf<String>()
        words.forEachIndexed forEachIndexed1@{ index, s ->
            words.forEachIndexed { index2, s2 ->
                if(index2 != index){
                    if(words[index2].contains(words[index])){
                        result.add(words[index])
                        return@forEachIndexed1
                    }
                }
            }
        }
        return result
    }


}

