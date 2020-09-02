package com.revature.worktests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.revature.sample.Work;

public class WorkTest {
  
//	@Test
//	public void f() throws FileNotFoundException {
////		throw new FileNotFoundException();
//		int x = 2;
//		
//		Assert.assertEquals(x, 3);
//	}
	
	Work work = new Work();
	
	@Test
	public void loginWorks() {
		String username = "ryan";
		String password = "pass";
		
		Assert.assertTrue(work.login(username, password));
	}
	
	@Test
	public void loginFails() {
		String username = "notryan";
		String password = "notpass";
		
		Assert.assertFalse(work.login(username, password));
	}
	
	@Test
	public void sumArrayWorks() {
		
		int[] numbers = {1, 2, 3};
		
		Assert.assertEquals(work.arraySum(numbers), 6.0);
	}
	
	@Test
	public void sumEmptyArray() {
		
		int[] numbers = new int[0];
		
		Assert.assertEquals(work.arraySum(numbers), 0.0);
	}
	
	@Test
	public void sumNullArray() {
		Assert.assertEquals(work.arraySum(null), 0.0);
	}
	
	
	
}
