package com.chengdu.leetcode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlin.text.StringBuilder

class MainActivity282 : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    var results: Int = -1
    var nowIndex = 0

    fun kthSmallest(root: TreeNode?, k: Int): Int {
        // 中序遍历
        ldr(root, k)
        return results
    }


    fun ldr(root: TreeNode?, k: Int){
        if(root == null || results != -1) return
        ldr(root.left, k)
        nowIndex ++
        if(nowIndex == k){
            results = root.`val`
        }
        ldr(root.right, k)
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

}

