package pageUIs.nopcommerce;

public class RegisterPageUI {
	public static final String FIRST_NAME_TEXTBOX ="xpath=//*[@id=\"FirstName\"]";
	public static final String LAST_NAME_TEXTBOX ="xpath=//*[@id=\"LastName\"]";
	public static final String EMAIL_TEXTBOX ="xpath=//*[@id=\"Email\"]";
	public static final String PASSWORD_TEXTBOX ="xpath=//*[@id=\"Password\"]";
	public static final String CONFIRM_PASSWORD_TEXTBOX ="xpath=//*[@id=\"ConfirmPassword\"]";
	public static final String REGISTER_BUTTON ="xpath=//*[@id=\"register-button\"]";
	public static final String FIRST_NAME_ERROR_MESSAGE="xpath=//*[@id=\"FirstName-error\"]";
	public static final String LAST_NAME_ERROR_MESSAGE="xpath=//*[@id=\"LastName-error\"]";
	public static final String EMAIL_ERROR_MESSAGE="xpath=//*[@id=\"Email-error\"]";
	public static final String PASSWORD_ERROR_MESSAGE="xpath=//*[@id=\"Password-error\"]";
	public static final String CONFIRM_PASSWORD_ERROR_MESSAGE="xpath=//*[@id=\"ConfirmPassword-error\"]";
	public static final String REGISTER_SUCCESS_MESSAGE="xpath=//div[@class='result']";
	public static final String MAIN_ERROR_MESSAGE="xpath=//div[@class='message-error validation-summary-errors']//li";
	public static final String LOG_OUT_BUTTON = "xpath=//a[text()='Log out']";
	public static final String VALIDATION_ERROR_BY_DATA_VALUE = "xpath=//span[@data-valmsg-for='%s']//span";
}
