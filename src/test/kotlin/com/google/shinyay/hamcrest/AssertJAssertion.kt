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

}