package com.learnjava.corejava;

public class Trade implements Cloneable {
	
	private static int id;
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	private String instr;
	
	public Trade() {
		id++;
	}
	
	public Trade(String instr) {
		this();
		instr="ABC";
		
		// Not Allowed
		// Constructor calls like this() and super() must be the first statements in a constructor.
		// this();
	}
	
	
	public int getId() {
		return id;
	}

	private void setId(int id) {
		this.id = id;
	}

	public String getInstr() {
		return instr;
	}

	private void setInstr(String instr) {
		this.instr = instr;
	}

	// No specifier is package private. Method won't be accessible to even child classes in a different package
	protected void printTrade() {
		System.out.print("This trade [" + this.id + "] and instr [" + this.instr + "] belong to " );
	}
	
	public static void printTrade(int c) {
		System.out.println(c);
	}

}


