package com.exam.application.newscompose.LogicExam

fun main() {

    val arr = readln().split(",").map { it.toInt() } //intArrayOf(1, 3, 5, 7, 9)

    val balanceIndex = findBalanceIndex(arr)

    if (balanceIndex != -1) {
        println("Balance index found at index $balanceIndex")
    } else {
        println("No balance index found.")
    }
}

fun findBalanceIndex(arr: List<Int>): Int {
    val totalSum = arr.sum()
    var leftSum = 0
    var rightSum = 0

    for (index in arr.indices) {
        rightSum = totalSum - leftSum - arr[index]
        if (leftSum == rightSum) {
            return index
        }
        leftSum += arr[index]
    }

    return -1
}