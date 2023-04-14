package com.example.calendar

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.calendar", appContext.packageName)
    }

    @Test
    fun testFlow() = runBlocking {

        val flow: Flow<Int> = flowOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)

        println("Even:")
        flow
            .filter { it % 2 == 0 }
            .map { it * 9 }
            .collect {
                println(it)
            }

        println("Odd:")
        flow
            .filter { it % 2 == 1}
            .collect {
                println(it)
            }
    }
}