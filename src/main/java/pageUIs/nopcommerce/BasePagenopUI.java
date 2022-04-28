package pageUIs.nopcommerce;

public class BasePagenopUI {
	public final static String TOP_MENU_LIST = "xpath=(//li[contains(string(),'%s')])[1]";
	public final static String SUB_MENU_LIST = "xpath=(//li[contains(string(),'%s')])[1]//a[string()='%s']";
	public final static String DROPDOWN_DESKOP_LIST = "xpath=//select[@id='products-orderby']";
	public static final String DESKOP_DESCRIPTION = "xpath=//h2[@class='product-title']";
	public static final String DESKOP_PRICES = "xpath=//div[@class='prices']";
}
