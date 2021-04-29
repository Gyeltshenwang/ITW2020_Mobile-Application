package com.example.myapplication;



import androidx.test.filters.SmallTest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

@RunWith(JUnit4.class) //Testing method
@SmallTest
public class ExampleUnitTest {
// declared a class obj
    public  Calculator calculate;

    @Before // used when we test a method from other class
    public void setUp(){
        //create obj
        calculate = new Calculator();
    }
// test the positive number
    @Test // used to test methods
    public void addNumber(){
        double result = calculate.add(1d,2d);
        assertThat(result, (equalTo(3d)));
    }
    // test for negative result
    @Test
    public void NegativeNumber(){
        double res = calculate.add(-2d,-1d);
        assertThat(res,(equalTo(-3d)));

    }
    //positive number for subtraction;
    @Test
    public void subNumber(){
        double result = calculate.sub(1d,2d);
        assertThat(result, (equalTo(3d)));
    }

    // negative result for sub;

    @Test
    public void NegativeSubNumber(){
        double res = calculate.sub(-2d,-1d);
        assertThat(res,(equalTo(-1d)));

    }
    // at lest one argument zero result fo
    @Test
    public void mul_At_lest_ONe_Zero_ArgNumber(){
        double result = calculate.multi(1d,0d);
        assertThat(result, (equalTo(0d)));
    }
    // positive res
    @Test

    public void MultiNumber(){
        double res = calculate.multi(-2d,-1d);
        assertThat(res,(equalTo(3d)));

    }
// positive res with non zero argument
    @Test
    public void divNumber(){
        double result = calculate.div(1d,2d);
        assertThat(result, (equalTo(.5d)));
    }
    // divisor zero
    @Test
    public void divToNumberZero(){
        double result = calculate.div(1d,0d);
        assertThat(result, (equalTo(Double.POSITIVE_INFINITY)));
    }





}