package com.chengdu.leetcode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlin.math.absoluteValue
import kotlin.math.max

/**
TinyURL 是一种 URL 简化服务， 比如：当你输入一个 URL https://leetcode.com/problems/design-tinyurl 时，它将返回一个简化的URL http://tinyurl.com/4e9iAk 。请你设计一个类来加密与解密 TinyURL 。

加密和解密算法如何设计和运作是没有限制的，你只需要保证一个 URL 可以被加密成一个 TinyURL ，并且这个 TinyURL 可以用解密方法恢复成原本的 URL 。

实现 Solution 类：

Solution() 初始化 TinyURL 系统对象。
String encode(String longUrl) 返回 longUrl 对应的 TinyURL 。
String decode(String shortUrl) 返回 shortUrl 原本的 URL 。题目数据保证给定的 shortUrl 是由同一个系统对象加密的。
 

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/encode-and-decode-tinyurl
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class MainActivity535 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    class Codec() {
        // 通过hashmap去记录
        private val dir = hashMapOf<Int, String>()  // key 为加密后 value 为加密前

        // Encodes a URL to a shortened URL.
        fun encode(longUrl: String): String {
            dir[longUrl.hashCode()] = longUrl
            return longUrl.hashCode().toString()
        }

        // Decodes a shortened URL to its original URL.
        fun decode(shortUrl: String): String {
            return dir[shortUrl.hashCode()] ?: ""
        }
    }
}