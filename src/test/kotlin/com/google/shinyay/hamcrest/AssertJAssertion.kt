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

    // isEmpty() or isNullOrEmpty()
    @Test
    fun shouldHaveBlank() {
        assertThat(service.returnBlank()).isNullOrEmpty()
    }

    // stringContainsInOrder()
    @Test
    fun shouldBeInOrder() {
        assertThat(service.returnStringList()).containsSequence("Alice", "Bob", "Carol")
    }

//    Collection ---------------------------------------------------------------

    // containsSequence()
    @Test
    fun shouldBeInAnyOrder() {
        assertThat(service.returnStringList()).hasSameElementsAs(listOf("Carol", "Bob", "Alice"))
    }

    // contains()
    @Test
    fun shouldHaveItem() {
        assertThat(service.returnStringList()).contains("Bob")
    }

    // hasSize()
    @Test
    fun shouldHaveSize() {
        assertThat(service.returnStringList()).hasSize(3)
    }

//    Map ---------------------------------------------------------------

    // emptyMap()
    @Test
    fun shouldBeEmptyMap() {
        assertThat(service.returnMutableMap()).isEmpty()
    }

    // containsKey()
    @Test
    fun shouldHaveKey() {
        val testMap = service.returnMutableMap()
        testMap["language"] = "Japanese"
        assertThat(testMap).containsKey("language")
    }

    // containsValue()
    @Test
    fun shouldHaveValue() {
        val testMap = service.returnMutableMap()
        testMap["language"] = "Japanese"
        assertThat(testMap).containsValue("Japanese")
    }

//    Number ---------------------------------------------------------------

    // isBetween()
    @Test
    fun shouldBeInRange() {
        assertThat(service.returnRandomDoubleNumber()).isBetween(0.0, 10.0)
    }

    // isGreaterThan() or isGreaterThanOrEqualTo()
    @Test
    fun shouldBeGreater() {
        assertThat(service.returnRandomIntNumber()).isGreaterThanOrEqualTo(1)
    }

    // isLessThanOrEqualTo()
    @Test
    fun shouldBeLess() {
        assertThat(service.returnRandomIntNumber()).isLessThanOrEqualTo(10)
    }

//    ---------------------------------------------------------------

    // hasFieldOrProperty()
    @Test
    fun shouldHaveProperty() {
        assertThat(service.returnGirl()).hasFieldOrProperty("name")
        assertThat(service.returnGirl()).hasFieldOrProperty("age")
        assertThat(service.returnGirl()).hasFieldOrProperty("gender")
    }

    // hasFieldOrProperty()
    @Test
    fun shouldHavePropertyWithValue() {
        assertThat(service.returnGirl()).hasFieldOrPropertyWithValue("name", "Alice")
        assertThat(service.returnGirl()).hasFieldOrPropertyWithValue("age", 20)
    }
}