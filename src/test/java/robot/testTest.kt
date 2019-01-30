package frc.robot

import com.nhaarman.mockitokotlin2.*
import org.junit.Test;
import org.junit.Before;


class MyClass {
    var lastFunc: String

    init {
        lastFunc = "null"
    }

    fun doAThing() {
        this.lastFunc = "Do a thing"
    }

    fun doADifferentThing() {
        this.lastFunc = "Did a different thing"
    }
}

class TestTest {
    val myClass = MyClass()
    var mockedMyClass: MyClass = mock()

    init {
        myClass.doAThing()
        myClass.doADifferentThing()
    }
    
    // @Before
    // fun setUp() {
    //     mockedMyClass = mock()
    // }

    @Test
    fun test_numero_uno() {

        mockedMyClass.doAThing()
        mockedMyClass.doADifferentThing()

        verify(mockedMyClass).doAThing()
        verify(mockedMyClass).doADifferentThing()
    }
}