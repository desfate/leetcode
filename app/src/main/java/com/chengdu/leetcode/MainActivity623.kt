package com.chengdu.leetcode

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.chengdu.leetcode.algorithm.TreeNode

class MainActivity623 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun addOneRow(root: TreeNode?, `val`: Int, depth: Int): TreeNode? {
        if(root == null) return null
        if(depth == 1){
            var  node = TreeNode(`val`)
            node.left = root
            node.right = null
            return node
        }

        if(depth == 2){
            var nodeLeft = TreeNode(`val`)
            nodeLeft.left = root.left
            nodeLeft.right = null
            root.left = nodeLeft

            var nodeRight = TreeNode(`val`)
            nodeLeft.left = null
            nodeLeft.right = root.right
            root.right = nodeRight
        }else{
            root.left = addOneRow(root.left, `val`, depth - 1)
            root.right = addOneRow(root.right, `val`, depth - 1)
        }
        return root
    }



}

