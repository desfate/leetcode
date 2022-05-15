package com.chengdu.leetcode.algorithm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.chengdu.leetcode.R

/**
 * 二叉树 以及二叉树的遍历
 */
class BinaryTreeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        root.left = TreeNode(2)
        root.right = TreeNode(3)
        root.left!!.left = TreeNode(4)
        root.left!!.right = TreeNode(5)
        root.right!!.left = TreeNode(6)
        root.right!!.right = TreeNode(7)
        ergodic(root)
    }

    val root = TreeNode(1)

    // 递归遍历二叉树
    fun ergodic(rootNode: TreeNode?){
        if(rootNode == null){
            return
        }
        // 先序
//        System.out.println(rootNode.`val`)
        ergodic(rootNode.left)
        // 中序
//        System.out.println(rootNode.`val`)
        ergodic(rootNode.right)
        // 后序
        System.out.println(rootNode.`val`)
    }

}