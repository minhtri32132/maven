package comm.data.nopcommerce;

import commons.BasePage;

public class MyAccountTestData extends BasePage {
	public static String firstName = generateRandomName();
	public static String lastName = generateRandomName();
	public static String gender = "Male";
	public static String date="11";
	public static String month="11";
	public static String year ="1995";
	public static String email = generateRandomName()+"@gmail.com";
	public static String country = "1";
	public static String city= generateRandomName();
	public static String address= generateRandomName();
	public static String zipCode= generateRandomName();
	public static String phoneNumber=generateRandomName() ;
	public static String state="1";
	public static String password=generateRandomName()+generateRandomName();
}
