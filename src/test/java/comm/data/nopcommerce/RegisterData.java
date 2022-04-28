package comm.data.nopcommerce;

import commons.BasePage;

public class RegisterData extends BasePage {
	public static String firstName = generateRandomName();
	public static String lastName = generateRandomName();
	public static String email = generateRandomName()+"@gmail.com";
	
	public static String password = generateRandomName()+"123";
 
}
