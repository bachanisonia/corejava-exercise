package com.learnjava.corejava;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collectors;

import com.learnjava.corejava.PizzaSet.PizzaStatus;

public class EnumSetExercise {

	public static void main(String[] args) {
		
		List<PizzaSet> pizzaSets = new ArrayList<>();
		
		PizzaSet pizza1 = new PizzaSet();
		pizza1.setPizzaStatus(PizzaStatus.DELIVERED);
		
		PizzaSet pizza2 = new PizzaSet();
		pizza2.setPizzaStatus(PizzaStatus.READY);
		
		PizzaSet pizza3 = new PizzaSet();
		pizza3.setPizzaStatus(PizzaStatus.ORDERED);
		
		PizzaSet pizza4 = new PizzaSet();
		pizza4.setPizzaStatus(PizzaStatus.ORDERED);
		
		pizzaSets.add(pizza1);
		pizzaSets.add(pizza2);
		pizzaSets.add(pizza3);
		pizzaSets.add(pizza4);
		
		System.out.println("There are " + PizzaSet.getAllUndeliveredPizzas(pizzaSets).size() + " undelivered pizzas");
		
	}
	

}


class PizzaSet {
	
	private static EnumSet<PizzaStatus> undeliveredPizzaStatuses = EnumSet.of(PizzaStatus.ORDERED, PizzaStatus.READY);
	
	public enum PizzaStatus {
		
		ORDERED(5) {
			@Override
			public boolean isOrdered() {
				return true;
			}
		},
		READY(2) {
			@Override
			public boolean isReady() {
				return true;
			}
		},
		DELIVERED(0) {
			@Override
			public boolean isDelivered() {
				return true;
			}
		};
	
		private int timeToDelivery;
	
		public boolean isOrdered() {return false;}
		public boolean isReady() {return false;}
		public boolean isDelivered() {return false;}
	
		public int getTimeToDelivery() { return timeToDelivery; }
	
		PizzaStatus(int timeToDelivery) {
			this.timeToDelivery = timeToDelivery;
		}
		
		public void setTimeToDelivery(int timeToDelivery) {
			this.timeToDelivery = timeToDelivery;
		}
		
	}
	
	private PizzaStatus pizzaStatus;
	
	public boolean isDeliverable() {
		return this.pizzaStatus.isReady();
	}
	
	
	public void printTimeToDeliver() {
		System.out.println("Time to delivery is : " + this.getPizzaStatus().getTimeToDelivery());
	}
	
	public static List<PizzaSet> getAllUndeliveredPizzas(List<PizzaSet> input) {
		
		return input.stream().filter( (s) -> undeliveredPizzaStatuses.contains(s.getPizzaStatus()))
			.toList();
	}


	public PizzaStatus getPizzaStatus() {
		return pizzaStatus;
	}


	public void setPizzaStatus(PizzaStatus pizzaStatus) {
		this.pizzaStatus = pizzaStatus;
	}
}