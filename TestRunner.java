package pages;


import org.testng.TestNG;
import java.util.Arrays;
import java.util.List;

public class TestRunner {
    public static void main(String[] args) {
        // Create an instance of TestNG
        TestNG testNG = new TestNG();

        // Create a list of test classes to be executed
        List<String> testClasses = Arrays.asList(
            "tests.LoginTest",
            "tests.SearchProductTest",
            "tests.AddToCartTest",
            "tests.CheckoutTest"
        );

        // Set the test classes
        testNG.setTestClasses(getTestClassArray(testClasses));

        // Execute the tests
        testNG.run();
    }

    @SuppressWarnings("rawtypes")
	private static Class[] getTestClassArray(List<String> testClasses) {
        Class[] classes = new Class[testClasses.size()];
        for (int i = 0; i < testClasses.size(); i++) {
            try {
                classes[i] = Class.forName(testClasses.get(i));
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return classes;
    }
}

