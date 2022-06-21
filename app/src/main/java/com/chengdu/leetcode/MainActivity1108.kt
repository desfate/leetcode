package com.chengdu.leetcode

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import java.util.*


/**
给你一个有效的 IPv4 地址 address，返回这个 IP 地址的无效化版本。
所谓无效化 IP 地址，其实就是用 "[.]" 代替了每个 "."。
 */
class MainActivity1108 {

    fun defangIPaddr(address: String): String {
//        return address.replace(".", "[.]")

        var result = StringBuilder()
        for (ad in address){
            if(ad == '.'){
                result.append("[.]")
            }else{
                result.append(ad)
            }
        }
        return result.toString()
//        address.forEach {
//            if(it == '.'){
//                result.append("[.]")
//            }else{
//                result.append(it)
//            }
//        }
//        return result.toString()
    }
}

