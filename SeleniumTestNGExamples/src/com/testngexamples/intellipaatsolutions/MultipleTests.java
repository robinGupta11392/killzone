// Priority examples along with enabled/disabled

package com.testngexamples.intellipaatsolutions;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MultipleTests {
	
//	Sample Priority Exampls
	/*@Test (enabled = false)
	  public void launch() {
		  System.out.println("Launch Done");
		  Assert.assertEquals('A', 'A');
	  }
  @Test (priority=1)
  public void gmail() {
	  System.out.println("Gmail Done");
	  Assert.assertEquals('A', 'A');
  }
  
  @Test (priority=3, enabled = false)
  public void facebook() {
	  System.out.println("facebook Done");
	  Assert.assertEquals('A', 'A');
  }
  
  @Test (priority=2)
  public void newtours() {
	  System.out.println("newtours Done");
	  Assert.assertEquals('A', 'A');
  }
  
  @Test (priority=4)
  public void sample() {
	  System.out.println("sample Done");
	  Assert.assertEquals('A', 'A');
  }*/
	
//	Below code for WebDriver example
	@Test(priority = 1)
	public void launch() {
		System.out.println("Launch Done");
		Assert.assertEquals('A', 'A');
	}

	@Test(priority = 1)
	public void login() {
		System.out.println("Login Done");
		Assert.assertEquals('A', 'a');
	}

	@Test(priority = 1, dependsOnMethods = { "launch"})
	public void compose() {
		System.out.println("Composing Done");
		Assert.assertEquals('A', 'a');
	}

	@Test(priority = 1, dependsOnMethods = { "compose", "launch" })
	public void logout() {
		System.out.println("Logout Done");
		Assert.assertEquals('A', 'A');
	}
}
