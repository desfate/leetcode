package com.chengdu.leetcode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlin.math.absoluteValue
import kotlin.math.max

/**
 *
 */
class MainActivity515 : AppCompatActivity() {

    var allSum = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun largestValues(root: TreeNode?): List<Int> {
        ergodic(root, 0)
        return map.values.toList()
    }

    var map = hashMapOf<Int, Int>();

    // 遍历二叉树的同时 用hashmap储存节点信息
    fun ergodic(root: TreeNode?, deep: Int) {
        if (root == null) {
            return;
        }
        val value = map[deep] ?: 0
        map[deep] = max(value, root.`val`)
        ergodic(root.left, deep + 1)
        ergodic(root.right, deep + 1)
    }

    fun morrisErgodic(root: TreeNode?) {
        if (root == null) {
            return;
        }
        var cur = root;
        var pre: TreeNode? = null;
        while (cur != null) {
            pre = cur.left
            if (pre != null) {
                while (pre!!.right != null && pre.right != cur) {
                    pre = pre.right
                }
                if (pre.right == null) {
                    pre.right = cur
                    cur = cur.left
                    continue
                } else {
                    pre.right = null
                }
            }
            println(cur.`val`)
            cur = cur.right
        }
    }

}