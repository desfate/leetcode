package com.chengdu.leetcode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity676 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    class MagicDictionary() {

        val dictionarys = arrayListOf<String>()

        fun buildDict(dictionary: Array<String>) {
            dictionarys.addAll(dictionary)
        }

        fun search(searchWord: String): Boolean {
            dictionarys.forEach {
                if(checkIsLike(it, searchWord)){
                    return true
                }
            }
            return false
        }

        fun checkIsLike(word: String, sameWord: String): Boolean{
            if(word.length != sameWord.length) return false
            var isSame = 0
            word.forEachIndexed {
                index, c ->
                    if(sameWord[index] != c){
                        isSame ++
                    }
            }
            return isSame == 1
        }
    }
}

