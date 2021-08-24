package com.Test.demo3;

import com.Test.demo3.demo.MathUtils;
import org.junit.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static org.junit.Assert.assertEquals;

@SpringBootApplication
public class Demo3Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo3Application.class, args);
	}

	@Test
	public void test(){
		MathUtils mathUtils=new MathUtils();
		int expected=2;
		int actual=mathUtils.add(1,1);
		assertEquals(expected,actual);
	}


}
