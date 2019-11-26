package production;
import user.*;
public class TelcomUserProduce extends Produce{
	public User produceUser(){
		return new TelcomUser("17656319795");
	}
}
