package com.chengdu.leetcode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.chengdu.leetcode.algorithm.TreeNode

class MainActivity655 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    val result:  ArrayList<ArrayList<String>> = arrayListOf()
    val key = 2

    fun printTree(root: TreeNode?): List<List<String>> {
        dfsHeight(root, 0)
        val treeHeight = height
        val xSize = key.shr(height + 1) + 1
        // 先生成最终答案数组结构
        for(i in 0 until treeHeight){
            val jList = arrayListOf<String>()
            for (j in 0 until xSize){
                jList.add("")
            }
            result.add(jList)
        }
        dfs(root, 0, xSize, treeHeight)
        return result
    }


    /**
     *  y == deep
     *
     */
    fun dfs(root: TreeNode?, deep: Int, x: Int, y: Int){
        if(root == null) return;
        // 填入答案
        result[deep][x / 2] = root.`val`.toString()
//        dfs(root.right, deep + 1, x / 2)
    }


    var height = 0;
    fun dfsHeight(root: TreeNode?, deep: Int){
        if (root == null) return;
        if(deep > height) height = deep
        dfsHeight(root.right, deep + 1)
        dfsHeight(root.left, deep + 1)
    }
}

