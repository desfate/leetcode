package com.chengdu.leetcode.algorithm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.chengdu.leetcode.R

/**
 * Morris 遍历
 */
class MorrisActivity : AppCompatActivity() {
    val root = TreeNode(1)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        root.left = TreeNode(2)
        root.right = TreeNode(3)
        root.left!!.left = TreeNode(4)
        root.left!!.right = TreeNode(5)
        root.right!!.left = TreeNode(6)
        root.right!!.right = TreeNode(7)
        morris(root)
    }
    fun morris(root: TreeNode?){
        if(root == null) return

        var curr = root   // 当前节点
        var mostRight: TreeNode? = null // 最右节点

        // 当前节点未指向任何节点时  则遍历完了所有节点
        while (curr != null){
            //  当前节点的左子树不存在  则向右移动
            if(curr.left == null && curr.right != null){
                curr = curr.right
            }
            // 当前节点的左子树存在时 找到左子树的最右节点 并用mostRight指向它
            if(curr!!.left != null){
                mostRight = curr.left  // 寻找最右节点
                // 最后节点不等于空 且 不等于cur（防止无限循环）
                while (mostRight!!.right != null && mostRight!!.right != curr){
                    mostRight = mostRight.right
                }

                if(mostRight.right != null){
                    // 如果最右节点的右子树不为空
                    mostRight.right = null
                    curr = curr.right
                }else{
                    // 如果最右节点的右子树未空
                    mostRight.right = curr
                    curr = curr.left
                }
            }
        }
    }
}