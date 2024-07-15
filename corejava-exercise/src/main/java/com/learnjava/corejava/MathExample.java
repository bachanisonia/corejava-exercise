package com.learnjava.corejava;
import static com.learnjava.corejava.StaticVariables.PI;

import java.io.IOException;

public class MathExample {
	
	public static double calculateCircleArea(int radius) {
		return 2*radius*PI;
	}
	
	public static double divide() {
		
		try {
			int result = 10/0;
			return result;
		}
		catch (Exception e) {
			System.out.println("Can't divide by zero !!");
			return 0;
		}
		finally {
			// Gets executed, whether an exception occurs or does not occur,
			// whether a catch block is present or not present
			System.out.println("Try again later...!!!");
		}
	}

}
