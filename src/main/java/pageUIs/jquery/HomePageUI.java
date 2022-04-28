package pageUIs.jquery;

public class HomePageUI {

	public static final String PAGING_DYNAMIC = "xpath=//ul[@class='qgrd-pagination-ul']//li[%s]//a";
	public static final String PAGING_DYNAMIC_DISPLAY = "xpath=//a[@class='qgrd-pagination-page-link active' and text()='%s']";
	public static final String HEADER_DYNAMIC = "xpath=//div[@class='qgrd-header-text'and text()=\"%s\"]//parent::div//following-sibling::input";

	public static final String COLUMN_INDEX_BY_NAME = "xpath=//tr/td[text()='%s']//preceding-sibling::td";
	public static final String TEXTBOX_BY_COLUMN_AND_ROW_INDEX = "xpath=(//tbody//tr[%s]//input)[%s]";

}
