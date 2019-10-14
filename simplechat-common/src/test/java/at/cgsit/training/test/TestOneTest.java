package at.cgsit.training.test;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.Assert;

public class TestOneTest {
	
	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();
	

	private static final String testMessage = "test message";
	
	private TestOne testedClass = new TestOne();
	
    @Before
    public void setUp() {
    	System.out.println("setUp");
    	testedClass = new TestOne();
    	testedClass.setTestMessage(testMessage); // default 
    }
    
    @Test
    public void testeins() {	
    	System.out.println("testeins");
    	
    	testedClass.setTestMessage(testMessage);    	
    	String result = testedClass.getTestMessage();
    	
    	Assert.assertEquals(testMessage, result);
    	
    	testedClass.setTestMessage("hugo");
	}
	
    @Test(expected = NullPointerException.class)
	public void testNullPointer() {	
    	System.out.println("testNullPointer");	
    	testedClass.setTestMessage(null);    	
    	String result = testedClass.getTestMessage();
    	result.toLowerCase();
	}
    
    @Test
	public void test() {	
        exceptionRule.expect(NullPointerException.class);
       
    	testedClass.setTestMessage(null);    	
    	String result = testedClass.getTestMessage();
    	result.toLowerCase();
	}
    
    @Test
	public void testRule() {	
        exceptionRule.expect(RuntimeException.class);
        exceptionRule.expectMessage("my error message 222");
      
        throw new RuntimeException("my error message");

	}
        
    
    
}
