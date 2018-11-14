package test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {
	public static void main(String[] args) {
		System.out.println("Running Symbol Table Tests");
		Result result = JUnitCore.runClasses(SymbolTableTests.class);

		for (Failure failure : result.getFailures()) {
		 System.out.println(failure.toString());
		}

		if(result.wasSuccessful()){
			System.out.println("All tests passed");
		}
		else{
			System.out.println("Test failures have occured");
		}
	}
}  