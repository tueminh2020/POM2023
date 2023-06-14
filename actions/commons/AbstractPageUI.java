package commons;

public class AbstractPageUI {
	public static final String HOMEPAGE_LINK ="//a[contains(text(),'Manager')]";
	public static final String NEW_CUSTOMER_LINK ="//a[contains(text(),'New Customer')]";
	public static final String EDIT_CUSTOMER_LINK ="//a[contains(text(),'Edit Customer')]";
	public static final String DELETE_CUSTOMER_LINK ="//a[contains(text(),'Delete Customer')]";
	public static final String NEW_ACCOUNT_LINK ="//a[contains(text(),'New Account')]";
	public static final String EDIT_ACCOUNT_LINK ="//a[contains(text(),'Edit Account')]";
	public static final String DELETE_ACCOUNT_LINK ="//a[contains(text(),'Delete Account')]";
	public static final String DEPOSIT_LINK ="//a[contains(text(),'Deposit')]";
	public static final String WITHDRAW_LINK ="//a[contains(text(),'Withdrawal')]";
	public static final String FUND_TRANSFER_LINK ="//a[contains(text(),'Fund Transfer')]";
	public static final String CHANGE_PASS_LINK ="//a[contains(text(),'Change Password')]";
	public static final String BALANCE_ENQUIRY_LINK ="//a[contains(text(),'Balance Enquiry')]";
	public static final String MINI_STATEMENT_LINK ="//a[contains(text(),'Mini Statement')]";
	public static final String CUSTOMISED_LINK ="//a[contains(text(),'Customised Statement')]";
	public static final String LOG_OUT_LINK ="//a[contains(text(),'Log out')]";
	
	//DYNAMIC link cho 14 link tren
	public static final String DYNAMIC_LINK_PAGE ="//a[(text()='%s')]";
}
