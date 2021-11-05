package com.officemate.qa.testscripts;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.officemate.qa.base.BaseClass;
import com.officemate.qa.pages.HomePage;
import com.officemate.qa.util.ReadTestData;

public class HomePageTest extends BaseClass {
	HomePage homepage;

	public HomePageTest() {
		super();
	}

	Logger log= Logger.getLogger(HomePageTest.class);

	@BeforeMethod
	public void setUp() {
		log.info("Launching Browser");
		initialization();
		homepage=new HomePage();
	}

	@DataProvider
	public Object[][] getSearchData() {
		Object data[][]=ReadTestData.getTestData("SearchQueries");
		return data;
	}

	@Test(dataProvider="getSearchData")
	public void searchProductWithSku(String sku, String productName, String originalPrice, String discountedPrice) throws InterruptedException {
		driver.switchTo().frame(homepage.getDynamicAdvertisementBanner());       
		homepage.getDynamicAdvertisementBannerCloseButton().click();
		driver.switchTo().defaultContent(); 

		homepage.getGlobalSearchInputField().clear();
		homepage.getGlobalSearchInputField().sendKeys(sku);
		homepage.getGlobalSearchButton().click();
		Thread.sleep(3000);

		String searchResultProductName=homepage.getSeachResultProductName().getText();
		String searchResultProductSku=homepage.getSearchResultProductSku().getText();
		String searchResultProductOriginalPrice=homepage.getSeachResultProductOriginalPrice().getText();
		String searchResultProductDiscountedPrice=homepage.getSeachResultProductDiscountedPrice().getText();
		log.info("Comparing the Actual values with Expected Vlaues");
		Assert.assertEquals(searchResultProductSku, sku);
		Assert.assertEquals(searchResultProductName, productName);
		Assert.assertEquals(searchResultProductOriginalPrice, originalPrice);
		Assert.assertEquals(searchResultProductDiscountedPrice, discountedPrice);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}

