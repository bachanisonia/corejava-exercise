package com.learnjava.corejava;

import java.io.IOException;

public interface InterfaceExample {

	int a = 10;
	// does not work, needs initialization
	// int b;
	
	static void printSomething() {
		System.out.println("We can have static methods inside an interface !!!");
	}
	
	static void addFormatting() {
		System.out.println("-------------------");
	}
	
	// Default methods are implicitly public
	default void printNothing() {
		InterfaceExample.addFormatting();
		System.out.println("Nothing !!!");
	}
	
	void doSomething() throws IOException;
	
	// This won't work as a static method would require a body
	// static void doNothing();
}

class Interface1 implements InterfaceExample {
	
	public void printNothing() {
		System.out.println("Can implement the interface's default method if specifier is changed to a higher scope");
	}

	@Override
	public void doSomething() throws IOException {
		// TODO Auto-generated method stub
		
	}
}

class Interface2 implements InterfaceExample, Cloneable {

	@Override
	public void doSomething() throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected Interface2 clone() throws CloneNotSupportedException {
		
		return new Interface2();
	}
	
	
	
}