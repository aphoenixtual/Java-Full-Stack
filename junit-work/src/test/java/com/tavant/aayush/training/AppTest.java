package com.tavant.waleed.training;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AppTest {
	
	App theApp;
	
	@BeforeAll
	static void callAtFirst() {
		System.out.println("Before All called...");
	}
	
	@AfterAll
	static void callAtEnd() {
		System.out.println("After All called...");
	}
	
	@BeforeEach
	void callBeforeEach() {
		theApp = new App();
		System.out.println("Before Each called...");
	}
	
	@AfterEach
	void callAfterEachTestMethod() {
		System.out.println("After Each called");
	}

	@DisplayName("Test Case for just Testing")
	@Test
	void testMethod() {
//		fail("We are just testing things here...");
	}
	
	@Test
	@DisplayName("Test case for testing division")
//	@EnabledOnOs(OS.LINUX)
//	@EnabledOnJre(JRE.JAVA_11)
	@Disabled
	void testDivide() {
		
	int result = theApp.divide(35, 5);
//		int result = new App().divide(35, 0);
		
//	assertThrows(ArithmeticException.class, () -> theApp.divide(35, 0));
//	assertDoesNotThrow(null);
		
		
		
		assertEquals(7, result);
//		assertEquals(5, result, "Values don't match");
		
		//assertNotEquals(7, result);
		
//		assertNull(theApp);
//		assertNotNull(theApp);
		
//		assertAll(
//				() -> assertEquals(6, result),
//				() -> assertEquals(7, result),
//				() -> assertEquals(4, result)
//				);
		
	}
	
	
	@DisplayName("Test case for testing palindrome strings")
	@ParameterizedTest
	@ValueSource(strings= {"madam", "sneha", "hanan", "nirmal"})
	void testForPalindrome(String value) {
		assertEquals(true, theApp.checkForPalindrome(value));
	}
	
	
	
	
	
	

}
