package com.al.mond.typer

import java.text.Normalizer

object StringSlicer {
    fun slice(source: String, useCursor: Boolean) =
        assembleStepByStepFME(splitFME(source), useCursor)

    // 첫가끝을 분해한다.
    private fun splitFME(input: String): List<String> {
        val result: MutableList<String> = mutableListOf()
        val inputs = input.split("")
        for (char in inputs) {
            if (char == "") continue
            val nfd = Normalizer.normalize(char, Normalizer.Form.NFD)
            for (i in nfd.indices) {
                result.add(nfd.codePointAt(i).toChar().toString())
            }
        }
        return result
    }

    // 첫가끝을 계속 조합하여 순차적인 리스트를 만든다.
    private fun assembleStepByStepFME(
        splitedFME: List<String>,
        useCursor: Boolean
    ): MutableList<String> {
        val result = arrayListOf<String>()
        splitedFME.indices.forEach { i ->
            var step = ""
            for (j in 0..i) step += splitedFME[j]
            result.add(step + getCursor(useCursor))
        }
        println(result)
        return result
    }

    private fun getCursor(useCursor: Boolean) = if (useCursor) "|" else ""

}