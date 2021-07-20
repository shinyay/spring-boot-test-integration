package com.google.shinyay.hamcrest

import com.google.shinyay.service.HamcrestService
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class AssertJAssertion {

    private val service = HamcrestService()

//    Basic ---------------------------------------------------------------

    // isEqualTo()
    @Test
    fun sameValue() {
        assertThat(service.returnStringValue()).isEqualTo("foo")
    }

    // isNotEqualTo()
    @Test
    fun notSameValue() {
        assertThat(service.returnStringValue()).isNotEqualTo("bar")
    }

//    String ---------------------------------------------------------------

    // startsWith()
    @Test
    fun startCharacter() {
        assertThat(service.returnStringValue()).startsWith("f")
    }

    // endsWith()
    @Test
    fun endCharacter() {
        assertThat(service.returnStringValue()).endsWith("f")
    }

    // contains()
    @Test
    fun containCharacter() {
        assertThat(service.returnStringValue()).contains("oo")
    }

    // equalToIgnoringCase()
    @Test
    fun ignoreCaseCharacter() {
        assertThat(service.returnStringValue()).isEqualToIgnoringCase("FOO")
    }

    //
    @Test
    fun shouldHaveBlank() {
        assertThat(service.returnBlank()).isNullOrEmpty()
    }
}