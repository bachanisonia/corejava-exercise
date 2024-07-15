package com.learnjava.corejava;

import com.learnjava.corejava.Pizza.PizzaStatus;

public class EnumBasics {

	
	public static void main(String[] args) {
		
		Pizza testPizza = new Pizza();
		testPizza.setPizzaStatus(PizzaStatus.READY);
		testPizza.printTimeToDeliver();
		
		if (testPizza.isDeliverable()) {
			System.out.println("Pizza is ready to be delivered...!!!");
		}
		else {
			System.out.println(testPizza.getPizzaStatus().getTimeToDelivery() + " more mins before the Pizza will be delivered...!!!");
		}
	}

}

class Pizza {
	
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


	public PizzaStatus getPizzaStatus() {
		return pizzaStatus;
	}


	public void setPizzaStatus(PizzaStatus pizzaStatus) {
		this.pizzaStatus = pizzaStatus;
	}
	
	
	
	
}