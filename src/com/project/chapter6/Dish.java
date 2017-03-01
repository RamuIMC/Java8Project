package com.project.chapter6;

public class Dish {
	
	private int calories;
	private String type;
	private String item;
	private boolean vegetarian;
	
	public Dish() {
		
	}

	public Dish(int calories) {
		//super();
		this.calories = calories;
	}

	
	
	public Dish(int calories, String type, String item) {
		
		this.calories = calories;
		this.type = type;
		this.item=item;
	}
	
	

	public Dish(int calories, String type, String item, boolean vegetarian) {
		this.calories = calories;
		this.type = type;
		this.item = item;
		this.vegetarian = vegetarian;
	}

	public int getCalories() {
		return calories;
	}

	public void setCalories(int calories) {
		this.calories = calories;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public boolean isVegetarian() {
		return vegetarian;
	}

	public void setVegetarian(boolean vegetarian) {
		this.vegetarian = vegetarian;
	}

	/*@Override
	public String toString() {
		return "Dish [type=" + type + "]";
	}*/

	

}
