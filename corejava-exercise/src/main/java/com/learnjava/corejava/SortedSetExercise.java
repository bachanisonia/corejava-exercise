package com.learnjava.corejava;

import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class SortedSetExercise {

	public static void main(String[] args) {
		
		Student s1 = new Student("Sonia", "15/06/1987");
		Student s2 = new Student("Sonia H", "15/06/1987");
		Student s3 = new Student("Sonia", "15/06/1987");

		Set<Student> setOfStudents = new TreeSet<>();
		setOfStudents.add(s1);
		setOfStudents.add(s2);
		setOfStudents.add(s3);
		
		System.out.println("Printing the set of students : ");
		setOfStudents.stream().forEach(System.out::println);
		
	}

}



class Student implements Comparable<Student> {
	
	String name;
	String dob;
	
	public Student(String name, String dob) {
		this.name = name;
		this.dob = dob;
	}

	@Override
	public int compareTo(Student o) {
		
		return this.dob.compareTo(o.dob);
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", dob=" + dob + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(dob, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(dob, other.dob) && Objects.equals(name, other.name);
	}

	
	
	
}