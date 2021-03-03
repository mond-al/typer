package com.al.mond.typer

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class TypingTest {

    @Test
    fun assembleStepByStepFME_Test() {
        assertThat(StringSlicer.slice("가", false)).isNotEmpty()
        assertThat(StringSlicer.slice("가가", false)).isEqualTo(listOf("ᄀ", "가", "가ᄀ", "가가"))
        assertThat(StringSlicer.slice("한", false)).isEqualTo(listOf("ᄒ", "하", "한"))
        assertThat(StringSlicer.slice("한글", false)).isEqualTo(listOf("ᄒ", "하", "한", "한ᄀ", "한그", "한글"))

        assertThat(StringSlicer.slice("가", true)).isNotEmpty()
        assertThat(StringSlicer.slice("가가", true)).isEqualTo(listOf("ᄀ|", "가|", "가ᄀ|", "가가|"))
        assertThat(StringSlicer.slice("한", true)).isEqualTo(listOf("ᄒ|", "하|", "한|"))
        assertThat(StringSlicer.slice("한\n", true)).isEqualTo(listOf("ᄒ|", "하|", "한|", "한\n|"))
    }

   /* // private으로 변경.
   @Test
    fun splitFME_Test() {
        assertThat(StringSlicer.splitFME(" ")).isNotEmpty()
        assertThat(StringSlicer.splitFME("ㄱ")).isNotEmpty()
        assertThat(StringSlicer.splitFME(" ")).isEqualTo(mutableListOf(" "))
        assertThat(StringSlicer.splitFME("ㄱ")).isEqualTo(mutableListOf("ㄱ"))
        assertThat(StringSlicer.splitFME("ㅏ")).isEqualTo(mutableListOf("ㅏ"))
        assertThat(StringSlicer.splitFME("ㄱ")).hasSize(1)
        assertThat(StringSlicer.splitFME("가")).hasSize(2)
        assertThat(StringSlicer.splitFME("각")).hasSize(3)
        assertThat(StringSlicer.splitFME("가거")).hasSize(4)
        assertThat(StringSlicer.splitFME("각 ㅓ")).hasSize(5)
        assertThat(StringSlicer.splitFME(" ")).hasSize(1)
    }
    */
}