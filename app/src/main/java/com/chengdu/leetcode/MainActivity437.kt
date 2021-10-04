package com.chengdu.leetcode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity437 : AppCompatActivity() {

    var allSum = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val root = TreeNode(10)
        root.right = TreeNode(-3)
        root.left = TreeNode(5)
        root.right!!.right = TreeNode(11)

        root.left!!.left = TreeNode(3)
        root.left!!.right = TreeNode(2)
        root.left!!.right!!.right = TreeNode(1)
        root.left!!.left!!.left = TreeNode(3)
        root.left!!.left!!.right = TreeNode(-2)

//        val root = TreeNode(1)
//
//        root.right = TreeNode(2)
//
//        root.right!!.right = TreeNode(3)
//
//        root.right!!.right!!.right = TreeNode(4)
//
//        root.right!!.right!!.right!!.right = TreeNode(5)

        hashMap[0] = 1
        // 遍历整个二叉树  对每个节点执行以下方法
//        calculate(root, hashMap, 0, 8)


        System.out.println(calculate(root, hashMap, 0, 8))
        System.out.println(hashMap)
    }

    val hashMap = HashMap<Int, Int>()

    fun calculate(root: TreeNode?, hashMap: HashMap<Int, Int>, sum: Int, targetSum: Int){
        // hashMap 记录的是前缀和 由于不需要识别是哪些节点
        // 所以直接用hashMap统计数量就行

        System.out.println(root)
        // 先序遍历
        if(root == null) return

        val curSum = root.`val` + sum // 当前前缀和


        allSum += hashMap.getOrDefault(curSum - targetSum, 0) // 统计答案
        System.out.println("answer = "+ allSum)
        hashMap[curSum] = hashMap.getOrDefault(curSum, 0) + 1  // 保存前缀和

        System.out.println("current Sum = "+ curSum + "!!!!!"+"current val = "+ root.`val`)
        // 先序遍历
        calculate(root.left, hashMap, curSum, targetSum)
        calculate(root.right, hashMap, curSum, targetSum)

        // 由于往左边遍历 和 往右边遍历 都会同时进过该路径 则会导致 重复计算了一次路径和
        // 则如果左右都有节点
        System.out.println(hashMap)
        hashMap[curSum] = hashMap.getOrDefault(curSum, 0) - 1
        System.out.println(hashMap)

    }

    fun dfs(root: TreeNode?, prefix: HashMap<Int, Int> , curr: Int, targetSum: Int ):Int {
        if (root == null) {
            return 0;
        }

        var ret = 0;
        val curr2: Int = root.`val` + curr

        ret = prefix.getOrDefault(curr2 - targetSum, 0);
        prefix[curr2] = prefix.getOrDefault(curr, 0) + 1;
        ret += dfs(root.left, prefix, curr2, targetSum);
        ret += dfs(root.right, prefix, curr2, targetSum);
        prefix[curr2] = prefix.getOrDefault(curr2, 0) - 1;

        return ret;
    }


    fun pathSum(root: TreeNode?, targetSum: Int): Int {
        // 遍历整个二叉树  对每个节点执行以下方法
        loadDeep(root, targetSum)
        allLoad(root, targetSum)
        return allSum
    }

    fun allLoad(root: TreeNode?, targetSum: Int){
        if(root == null) return

        if(root.left != null){
            loadDeep(root.left, targetSum)
            allLoad(root.left, targetSum)
        }

        if(root.right != null){
            loadDeep(root.right, targetSum)
            allLoad(root.right, targetSum)
        }
    }

    fun loadDeep(root: TreeNode?, sum: Int){

        if(root == null) return

        if(sum - root!!.`val` == 0){
            allSum += 1
        }
        if(root?.left != null){
            System.out.println("to left" + "current sum ="+ sum + "!!!!!" + "current vla = "+ root!!.`val`)
            loadDeep(root.left, sum - (root.`val`))
        }

        if(root?.right != null){
            System.out.println("to right" + "current sum ="+ sum + "!!!!!" + "current vla = "+ root!!.`val`)
            loadDeep(root.right, sum - (root.`val`))

        }
    }


    class TreeNode(var `val`: Int) {
             var left: TreeNode? = null
             var right: TreeNode? = null
         }
}