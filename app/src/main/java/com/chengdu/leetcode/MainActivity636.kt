package com.chengdu.leetcode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity636 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    val hashMap = hashMapOf<Int, Int>()

    // 0:end:6
    class Task {
        var id: Int = 0 // 进程任务
        var type: Boolean = true  // true : Start  false : End
        var cpuId: Int = -1  // 对某个id执行任务
    }


    fun exclusiveTime(n: Int, logs: List<String>): IntArray {
        var lastTask: Task? = null
        logs.forEach {
            // 这里记录每个元素 和 上一个元素中间的插值
            val task = toTask(it)
            if (lastTask != null) {
                if(!task.type && !lastTask!!.type){
                    val value = hashMap.getOrDefault(task.id, 0)
                    hashMap[task.id] = (task.cpuId - lastTask!!.cpuId) + value
                }else{
                    val value = hashMap.getOrDefault(lastTask!!.id, 0)
                    hashMap[lastTask!!.id] = (task.cpuId - lastTask!!.cpuId) + value + if (task.type) {
                        1
                    } else {
                        0
                    }
                }
            }
            lastTask = task
        }
        val result = IntArray(n)
        for (i in 0 until n) {
            result[i] = hashMap.getOrDefault(i, 0)
        }
        return result
    }

    private fun toTask(log: String): Task {
        val list = log.split(":")
        return Task().apply {
            id = list[0].toInt()
            type = (list[1] == "start")
            cpuId = list[2].toInt()
        }
    }

}

