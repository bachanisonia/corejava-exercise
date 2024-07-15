package com.learnjava.corejava;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class EqualsHashCodeExercise {

	public static void main(String[] args) {
		
		Team team1 = new Team("New York", "development");
		Team team2 = new Team("Boston", "development");
		Team team3 = new Team("New York", "development");
		
		if (team1 == team3) { System.out.println("team1 == team3 returns true"); }
		if (team1.equals(team3)) { System.out.println("team1.equals(team3) returns true"); }

		List<Team> teams = new ArrayList<>();
		teams.add(team1);
		teams.add(team2);
		teams.add(team3);
		
		// return true
		System.out.println("Checking if list contains team1" + teams.contains(team1));
		
		// returns true
		System.out.println("Checking if list contains team2" + teams.contains(new Team("Boston", "development") ));
		
		
		Map<Team, String> leaders = new HashMap<>();
		
		leaders.put(new Team("New York", "development"), "Anne");
		leaders.put(new Team("Boston", "development"), "Brian");
		leaders.put(new Team("Boston", "marketing"), "Charlie");
		
		Team myTeam = new Team("New York", "development");
		String myTeamLeader = leaders.get(myTeam);
		
		// returns null before overriding the hashcode method
		// returns the correct value after overriding the hash code method
		System.out.println(myTeamLeader);
		
		// returns false before overriding the hashcode method
		// returns true after overriding the hashcode method
		System.out.println(leaders.containsKey(myTeam));
		
	}

}


class Team {
	
	String city;
	String dept;
	
	public Team(String city, String dept) {
		//super();
		this.city = city;
		this.dept = dept;
	}

	/* Hashcode contract
	 * The value of hashcode may only change if the property in .equals changes
	 * Objects that are equal to each other must return the same hash code
	 * unequal objects may have same hashcode -> hash collision 
	 */
	@Override
	public int hashCode() {
		return Objects.hash(city, dept);
	}
	
	/* Equals contract
	 * Object must be equal to itself
	 * x.equals(y) and y.equals(x) must return the same result
	 * if x.equals(y) and y.equals(z) then x.equals(z)
	 * value of .equals must change only if a property that is contained in .equals changes
	 */
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Team other = (Team) obj;
		return Objects.equals(city, other.city) && Objects.equals(dept, other.dept);
	}
	
	
	
	
}