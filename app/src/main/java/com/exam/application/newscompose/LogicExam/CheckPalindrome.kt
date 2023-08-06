package com.exam.application.newscompose.LogicExam

fun main() {
    checkStringPalindrome(readln())
}
fun checkStringPalindrome(text:String) {

    val originalString = text

    var reverseString = ""
    val length = originalString.length

    for (i in (length - 1) downTo 0) {
        reverseString = reverseString + originalString[i]
    }

    if (originalString.equals(reverseString, ignoreCase = true)) {
        println("The given string is Palindrome")
    } else {
        println("The given string is NOT a Palindrome")
    }
}