package io.ghkim.algotest

import kotlin.math.max
import kotlin.math.min

class Solution {
    fun intervalIntersection(firstList: Array<IntArray>, secondList: Array<IntArray>): Array<IntArray> {
        if (firstList.isEmpty() || secondList.isEmpty()) {
            return arrayOf()
        }

        val result = mutableListOf<IntArray>()
        var i = 0
        var j = 0
        while (i < firstList.size && j < secondList.size) {
            val lo = max(firstList[i][0], secondList[j][0])
            val hi = min(firstList[i][1], secondList[j][1])
            if (lo > hi) {
                if (firstList[i][0] < secondList[j][0]) i++
                else j++
                continue
            }

            result.add(arrayOf(lo, hi).toIntArray())
            if (firstList[i][1] < secondList[j][1]) i++
            else j++
        }

        return result.toTypedArray()
    }
}