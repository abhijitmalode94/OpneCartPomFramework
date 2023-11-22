package Com.qa.opencart.constat;

import java.util.Arrays;
import java.util.List;

public class AppConstants {
	//Crested this class for the wait timeout hard coded value so any dev or qa can use it according to the application
	
	public static final int DEFAULT_MEDIUM_TIMEOUT=10;
	public static final int DEFAULT_SHOT_TIMEOUT=5;
	public static final int DEFAULT_LONG_TIMEOUT=15;
	
	public static final String LOGIN_PAGE_TITLE_VALUES="Account Login";
	// the use of this if we add account login  at many place and
	// sunddenly title change so we need chnage that all due this we need to change here only
	public static final String LOGIN_PAGE_URL_FRACTION_VALUES="route=account";
	public static final int ACCOUNT_PAGE_HEADERS_COUNT=4;
	
	//create one static final arraylist to check the account page header values
	
	public static final List<String>EXPECTED_ACCOUNT_PAGE_HEADERS_VALUE_lIST=Arrays.asList("My Account","My Orders","My Affiliate Account","Newsletter");
	

}
