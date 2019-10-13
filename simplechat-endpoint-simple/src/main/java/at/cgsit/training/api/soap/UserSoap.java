package at.cgsit.training.api.soap;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(
        name = "UserSoap"
)
public class UserSoap {

	/**
	 * 
	 * @return
	 */
    @WebMethod
    public String message() {
        return "Hello World";
    }

}
