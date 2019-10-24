package at.cgsit.training.test;

/**
 * common shared POJO
 */
class TestOne {
	
	private String testMessage;

	public TestOne(String in) {
		testMessage = in;
	}	
	
	public TestOne() {
		testMessage = null;
	}
	
	public String getTestMessage() {
		return testMessage;
	}

	public void setTestMessage(String testMessage) {
		this.testMessage = testMessage;
	}


}
