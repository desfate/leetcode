package com.chengdu.leetcode

import com.chengdu.leetcode.algorithm.TreeNode

class MainActivity1161 {


    val hashMap = hashMapOf<Int, Int>()

    fun maxLevelSum(root: TreeNode?): Int {
        // 直接遍历  然后将每层的信息统计到hashmap中  key是层数  value是每层节点之和
        dfs(root, 1)
        var max = Int.MIN_VALUE
        hashMap.forEach { (_, u) ->
            if (u > max) max = u
        }

        hashMap.forEach { (i, u) ->
            if(u == max){
                return i
            }
        }

        return 0
    }
    // 问题一  带层数的遍历

    // 前序遍历  根左右  递归  （需要记录层数）
    fun dfs(root: TreeNode?, layer: Int) {
        if (root == null) {
            return
        }
        val value = hashMap.getOrDefault(layer, 0)
        hashMap[layer] = root.`val` + value
        dfs(root.left, layer + 1)
        dfs(root.right, layer + 1)
    }


}

