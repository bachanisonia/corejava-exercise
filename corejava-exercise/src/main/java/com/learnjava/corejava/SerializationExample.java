package com.learnjava.corejava;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializationExample {

	public static void main(String[] args) {
	
		Employee emp = new Employee("Sharma", 10000);
		
		System.out.println("Name : " + emp.name);
		System.out.println("Salary : " + emp.salary);
		
		try {
			
			FileOutputStream fileOutputStream = new FileOutputStream("Serialization.txt");
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			
			objectOutputStream.writeObject(emp);
			
			objectOutputStream.close();
			fileOutputStream.close();
			
			System.out.println("Object has been serialized !!!");
			
			FileInputStream fileInputStream = new FileInputStream("Serialization.txt");
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
			
			Employee emp1 = (Employee) objectInputStream.readObject();
			objectInputStream.close();
			fileInputStream.close();
			
			System.out.println("Object has been de-serialized");
			System.out.println("Name : " + emp1.name);
			System.out.println("Salary : " + emp1.salary);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}


class Person implements Serializable {
	
	String name;
	
	public Person(String name) {
		this.name = name;
	}
}


class Employee extends Person {

	float salary;
	
	public Employee(String name, float salary) {
		super(name);
		this.salary = salary;
	}
	
}