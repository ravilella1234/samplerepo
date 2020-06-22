package suiteParallel;

import java.util.Arrays;

import org.testng.TestNG;

public class RunSuiteParallel 
{

	public static void main(String[] args) 
	{
		/*
		 * String[] s = new String[10]; s[0]="10"; s[1]="20";
		 * 
		 * String[] s1 = new String[] {"ravi","lella"};
		 */
		
		TestNG t = new TestNG();
		t.setTestSuites(Arrays.asList(System.getProperty("user.dir")+"//megasuite.xml"));
		t.setSuiteThreadPoolSize(2);
		t.run();

	}

}
