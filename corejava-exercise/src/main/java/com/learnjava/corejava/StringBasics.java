package com.learnjava.corejava;

import org.apache.commons.lang3.StringUtils;

public class StringBasics {

	public static void main(String[] args) {
		
		
		String s1 = new String("Sonia");
		
		// Same reference
		String s2 = "Sonia";
		String s3 = "Sonia";
		
		if (s1==s2) System.out.println("s1==s2");
		if (s1.equals(s2)) System.out.println("s1.equals(s2)");

		if (s2==s3) System.out.println("s2==s3");
		if (s2.equals(s3)) System.out.println("s2.equals(s3)");
		
		
		String s4 = "Sonia";
		// New reference
		String s5 = new String("Sonia");
		
		if (s4==s5) System.out.println("s4==s5");
		if (s4.equals(s5)) System.out.println("s4.equals(s5)");
		

		// Still creates a new reference
		String s6 = s5.intern();
		
		if (s5==s6) System.out.println("s5==s6");
		if (s5.equals(s6)) System.out.println("s5.equals(s6)");
		
		String s7 = null;
		
		if (s6==s7) System.out.println("s6==s7");
		if (s6.equals(s7)) System.out.println("s6.equals(s7)");
		
		String s8 = null;
		
		// returns true
		if (s7==s8) System.out.println("s7==s8");
		
		// nullpointerexception, can use Apache Comms StringUtils
		//if (s7.equals(s8)) System.out.println("s7.equals(s8)");
		
		if (StringUtils.equals(s7, s8)) System.out.println("StringUtils.equals(s7, s8)");
		
	}

}
