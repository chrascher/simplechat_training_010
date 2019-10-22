package at.cgsit.training.api.soap;

import at.cgsit.training.api.soap.client.UserSoap;
import at.cgsit.training.api.soap.client.UserSoapService;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

//@ Ignore
public class UserSoapClientTest {

    private static UserSoapService userSoapService;
    private static UserSoap userSoapPort;

    @Before
    public void setUp() {
        userSoapService = new UserSoapService(getClass().getClassLoader().getResource("wsdl/UserSoapService.wsdl"));
        userSoapPort = userSoapService.getUserSoapPort();
    }

    @Test
    public void callUserSoapService() {
        assertEquals("Hello World", userSoapPort.message());
    }

}
