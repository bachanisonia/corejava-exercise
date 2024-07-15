package com.learnjava.corejava;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;

import com.learnjava.corejava.tradeexample.EquityTrade;

public class MiscPractice {

	 public static void main(String[] args) throws IOException {
		
		 System.out.println("The value of args is " + args);
		
		 int i;
		 String s;
		 
		 // Errors out for initializing the variables
		 //System.out.println("Printing the default values : " + "i=" + i + ", s=" + s);
		 
		 Trade t1 = new Trade();
		 System.out.println("Value of static variable in the class after t1 : " + t1.getId());
		 t1.printTrade();
		 Trade t2 = new Trade();
		 System.out.println("Value of static variable in the class after t2 : " + t1.getId());
		 t2.printTrade();
		 
		 Trade.printTrade(10);
		 
		 // returns true
		 System.out.println(t2 instanceof Trade);
		 
		 t2 = new EquityTrade();
		 // returns true
		 System.out.println(t2 instanceof EquityTrade);
		 
		 AbstractClass.printSomething();
		 
		 int result = new AbstractClass() {

			@Override
			int printNothing() {
				return 100;
			}
			 
		 }.printNothing();
		 
		 System.out.println(result);
		 
		 InterfaceExample.printSomething();
		 
		 Interface1 i1 = new Interface1();
		 i1.printNothing();
	
		 Interface2 i2 = new Interface2();
		 i2.printNothing();
		 
		 System.out.println("Circle Area : " + MathExample.calculateCircleArea(10));
		 
		 double divideResult = MathExample.divide();
		 
		 String name = "Sonia";
		 name.concat("Bachani");
		 System.out.println("Name : " + name);
		 
		 String sameName = new String("Sonia");
		 // true
		 System.out.println(name.equals(sameName));
		
		 // false
		 System.out.println(name == sameName);
		 
		 String s1 = "Welcome";
		 String s2 = "Welcome";
		 String s3 = "Welcome";
		 String s4 = new String("Welcome");
		 String s5 = new String("Welcome");
		 
		 // true
		 System.out.println(s1==s3);
		 
		 // true
		 System.out.println(s1.equals(s3));
		 
		 // false
		 System.out.println(s1==s4);
		 
		 // true
		 System.out.println(s1.equals(s4));

		 // false
		 System.out.println(s4==s5);
		 
		 // true
		 System.out.println(s4.equals(s5));

		 // Return the String pool referece and hence s1==s4 returns true
		 s4 = s4.intern();
		 // true
		 System.out.println(s4==s1);
		 
		 // Opens notepad. getRuntime returns the singleton instance of runtime class. 
		 //Runtime.getRuntime().exec("notepad");
		 
		 
		 //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		 //System.out.println(reader.readLine());
		 
		 /*
		  * This isn't working
		 Console console = System.console();
		 System.out.println("Enter your name : ");
		 String answer = console.readLine();
		 System.out.println("My name is " + answer);
		 */
		 
		 Integer integer1 = 20000;
		 Integer integer2 = 20000;
		 
		 // false
		 System.out.println(integer1==integer2);
		 
		 // true
		 System.out.println(integer1.equals(integer2));
		 
	}

}

