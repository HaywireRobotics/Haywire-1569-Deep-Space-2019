package frc.robot

import com.nhaarman.mockitokotlin2.*
import org.junit.Test;
import org.junit.Before;


open class MyClass {
    var lastFunc: String

    init {
        lastFunc = "null"
    }

    open fun doAThing() {
        this.lastFunc = "Do a thing"
    }

    open fun doADifferentThing() {
        this.lastFunc = "Did a different thing"
    }
}

class TestTest {
    val myClass = MyClass()
    var mockedMyClass: MyClass = mock()
    // @Before
    // fun setUp() {
    //     mockedMyClass = mock()
    // }

    init {
        myClass.doAThing()
        myClass.doADifferentThing()
    }

    @Test
    fun test_numero_uno() {

        mockedMyClass.doAThing()
        mockedMyClass.doADifferentThing()

        verify(mockedMyClass).doAThing()
        verify(mockedMyClass).doADifferentThing()
    }
}