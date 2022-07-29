package com.chengdu.leetcode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlin.math.absoluteValue

class MainActivity814 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

     class TreeNode(var `val`: Int) {
             var left: TreeNode? = null
             var right: TreeNode? = null
    }

    fun pruneTree(root: TreeNode?): TreeNode? {
        // 这个问题等同于 对所有的左右子树求解
        if(root != null){
            root.left = pruneTree(root.left)
            root.right = pruneTree(root.right)
            if(root.left == null && root.right == null && root.`val` == 0){
                return null
            }
        }
        return root
    }

}

