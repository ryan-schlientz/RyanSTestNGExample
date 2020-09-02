package com.revature.sample;

public class Work {
	
	public boolean login(String username, String password) {
		
		if(("ryan").equals(username) && ("pass").equals(password)) {
			return true;
		} else {
			return false;
		}
		
	}
	
	public double arraySum(int[] numbers) {
		
		double sum = 0;
		
		if(numbers != null) {
			for(int i = 0; i < numbers.length; i++) {
				sum += numbers[i];
			}
		}
		
		return sum;
	}

}
