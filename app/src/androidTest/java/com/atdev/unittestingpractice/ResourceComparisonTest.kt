package com.atdev.unittestingpractice

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.atdev.unittestingpractice.other.registrationform.ResourceComparison
import com.google.common.truth.Truth.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Test

class ResourceComparisonTest {

    private lateinit var resourceComparison: ResourceComparison

    @Before
    fun setup() {
        resourceComparison = ResourceComparison()
    }

    @After
    fun tearDown() {
        //resourceComparison = null
    }

    @Test
    fun sameStringResourcesEqual_returnTrue() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val result = resourceComparison.isEqual(
            context,
            R.string.app_name,
            "UnitTestingPractice"
        )

        assertThat(result).isTrue()
    }

    @Test
    fun differentStringResourcesEqual_returnFalse() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val result = resourceComparison.isEqual(
            context,
            R.string.app_name,
            "UnitTestingPracticeAS"
        )

        assertThat(result).isFalse()
    }
}