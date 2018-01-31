package TestRunners;

import java.io.IOException;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import TestCases.CheckHeaderTest;
import TestCases.CheckIncorrectLogin;
import TestCases.CheckInvalidRegistration;
import TestCases.CheckMissedEmail;


public class SomeTestScenarios extends TestRunner {
	
	public static void main(String[] args) throws IOException {
		
			//This statement is to load all type of results in the result object
			Result result = JUnitCore.runClasses(CheckHeaderTest.class, CheckMissedEmail.class, CheckIncorrectLogin.class, CheckInvalidRegistration.class);
			//Here it is getting the run count from the result object
			System.out.println("Total number of tests " + result.getRunCount());
			//This is to get the failure count from the result object
			System.out.println("Total number of tests failed " + result.getFailureCount());
			//open html			
			setUp(result, "SometestScenarios");
			//creating tests summary
			succeedCases(result);
			//add to html each failure		
			for(Failure failure : result.getFailures())
			{	
				//This will print message only in case of failure
				System.out.println(failure.getMessage());
				System.out.println(failure.getTestHeader());
				reportFailure(failure.getTestHeader(),  failure.getMessage());
			}
			//commit just to check something
			//close html doc
			tearDown();
			//This will print the overall test result in boolean type
			System.out.println(result.wasSuccessful());
	}
}

