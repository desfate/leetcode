package com.chengdu.leetcode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.chengdu.leetcode.algorithm.TreeNode

class MainActivity1302 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun deepestLeavesSum(root: TreeNode?): Int {
        dfs(root, 0)
        return hashMap[max]!!
    }

    val hashMap = hashMapOf<Int, Int>()
    var max = Int.MIN_VALUE

    // 递归遍历二叉树 - 遍历的同时记录二叉树高度
    fun dfs(root: TreeNode?, deep: Int){
        if(root == null) return
        val value = hashMap.getOrDefault(deep, 0)
        if(deep > max) max = deep
        hashMap[deep] = value + root.`val`
        dfs(root.right, deep + 1)
        dfs(root.left, deep + 1)
    }

}

