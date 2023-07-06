package bankguru;

public class newCustomerUI {
	public static final String ADD_NEW_CUSTOMER_TEXT = "//p[contains(text(),'Add New Customer')]";
	public static final String CUSTOMER_NAME_TEXTBOX = "//input[@name='name']";
	public static final String ERR_MSG_CUSTOMER_NAME = "//input[@name='name']//following-sibling::label[(text()='Customer name must not be blank')]";
	public static final String ERR_NUMERIC_CUSTOMER_NAME = "//input[@name='name']//following-sibling::label[(text()='Numbers are not allowed')]";
	public static final String ERR_SPECIAL_CUSTOMER_NAME = "//input[@name='name']//following-sibling::label[(text()='Special characters are not allowed')]";
	public static final String ERR_FIRSTBLANK_CUSTOMER_NAME = "//input[@name='name']//following-sibling::label[(text()='First character can not have space')]";

	public static final String GENDER_CHECKBOX = "//input[@value='f']";
	public static final String DATE_OF_BIRTH = "//input[@name='dob']";
	public static final String ERR_MSG_DATE_OF_BIRTH = "//label[(text()='Date Field must not be blank')]";

	public static final String ADDRESS_AREABOX = "//textarea[@name='addr']";
	public static final String ERR_MSG_ADDRESS_AREABOX = "//textarea[@name='addr']//following-sibling::label[(text()='Address Field must not be blank')]";
	public static final String ERR_FIRSTBLANK_ADDRESS = "//textarea[@name='addr']//following-sibling::label[text()='First character can not have space']";

	public static final String CITY_TEXTBOX = "//input[@name='city']";
	public static final String ERR_MSG_CITY_TEXTBOX = "//input[@name='city']//following-sibling::label[(text()='City Field must not be blank')]";
	public static final String ERR_NUMERIC_CITY = "//input[@name='city']//following-sibling::label[text()='Numbers are not allowed']";
	public static final String ERR_SPECIAL_CITY ="//input[@name='city']//following-sibling::label[text()='Special characters are not allowed']";
	public static final String ERR_FIRTBLANK_CITY ="//input[@name='city']//following-sibling::label[text()='First character can not have space']";

	
	public static final String STATE_TEXTBOX = "//input[@name='state']";
	public static final String ERR_MSG_STATE_TEXTBOX = "//label[(text()='State must not be blank')]";
	public static final String ERR_NUMERIC_STATE ="//input[@name='state']//following-sibling::label[(text()='Numbers are not allowed')]";
	public static final String ERR_SPECIAL_STATE ="//input[@name='state']//following-sibling::label[(text()='Special characters are not allowed')]";
	public static final String ERR_FIRTBLANK_STATE ="//input[@name='state']//following-sibling::label[(text()='First character can not have space')]";

	//PIN
	public static final String PIN_TEXTBOX = "//input[@name='pinno']";
	public static final String ERR_MSG_PIN_TEXTBOX = "//label[(text()='PIN Code must not be blank')]";
	public static final String ERR_CHAR_PIN ="//input[@name='pinno']//following-sibling::label[(text()='Characters are not allowed')]";
	public static final String ERR_LESSER_6_DIGIT_PIN ="//input[@name='pinno']//following-sibling::label[(text()='PIN Code must have 6 Digits')]";
	public static final String ERR_SPECIAL_PIN ="//input[@name='pinno']//following-sibling::label[(text()='Special characters are not allowed')]";
	public static final String ERR_FIRSTBLANK_PIN ="//input[@name='pinno']//following-sibling::label[(text()='First character can not have space')]";
	
	
	public static final String MOBILE_TEXTBOX = "//input[@name='telephoneno']";
	public static final String ERR_MSG_MOBILE_TEXTBOX = "//label[(text()='Mobile no must not be blank')]";
	public static final String ERR_FIRSTBLANK_MOBILE="//input[@name='telephoneno']//following-sibling::label[(text()='First character can not have space')]";
	public static final String ERR_SPECIAL_MOBILE="//input[@name='telephoneno']//following-sibling::label[(text()='Special characters are not allowed')]";
	
	
	public static final String EMAIL_TEXTBOX = "//input[@name='emailid']";
	public static final String ERR_MSG_EMAIL_TEXTBOX = "//label[(text()='Email-ID must not be blank')]";
	public static final String ERR_INCORRECT_EMAIL ="//input[@name='emailid']//following-sibling::label[(text()='Email-ID is not valid')]";
	public static final String ERR_FIRSTBLANK_EMAIL ="//input[@name='emailid']//following-sibling::label[(text()='First character can not have space')]";

	
	public static final String PASSWORD_TEXTBOX = "//input[@name='password']";
	public static final String ERR_MSG_PASSWORD_TEXTBOX = "//label[(text()='Password must not be blank')]";
	public static final String SUBMIT_BUTTON = "//input[@name='sub']";
	
	public static final String ADDRESS_BOX = "//textarea[@name='addr']";
	public static final String REGIS_SUCCESS_MSG ="//p[text()='Customer Registered Successfully!!!']";

	//Successul Customer Created
	public static final String CUSTOMER_ID ="//td[text()='Customer ID']//following-sibling::td";
}
