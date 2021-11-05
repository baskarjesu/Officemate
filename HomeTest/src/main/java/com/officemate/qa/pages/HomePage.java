package com.officemate.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.officemate.qa.base.BaseClass;

public class HomePage extends BaseClass{

	//Page factory

	@FindBy(xpath="//input[@class='_5vxBY _32CNv _2MLml']")
	WebElement eGlobalSearchInputField;

	@FindBy(xpath="//div[@id='btn-searchResultPage']")
	WebElement eGlobalSearchButton;

	@FindBy(xpath="//div[@class='POZxw']")
	WebElement eSearchResultProductSku;

	@FindBy(xpath="//a[contains(@id,'lbl-ProductPreview-Name')]")
	WebElement eSeachResultProductName;

	@FindBy(xpath="//div[contains(@id,'lbl-ProductList-NormalPrice')]")
	WebElement eSeachResultProductOriginalPrice;

	@FindBy(xpath="//div[contains(@id,'lbl-ProductList-Price')]")
	WebElement eSeachResultProductDiscountedPrice;

	@FindBy(xpath="//iframe[contains(@classname,'sp-fancybox-iframe')]")
	WebElement eDynamicAdvertisementBanner;

	@FindBy(xpath="//i[@class='fa fa-times element-close-button']")
	WebElement eDynamicAdvertisementBannerCloseButton;


	public HomePage() {
		PageFactory.initElements(driver,this);
	}

	public WebElement getDynamicAdvertisementBanner() {
		return eDynamicAdvertisementBanner;
	}

	public WebElement getDynamicAdvertisementBannerCloseButton() {
		return eDynamicAdvertisementBannerCloseButton;
	}

	public WebElement getGlobalSearchInputField() {
		return eGlobalSearchInputField;
	}

	public WebElement getGlobalSearchButton() {
		return eGlobalSearchButton;
	}

	public WebElement getSearchResultProductSku() {
		return eSearchResultProductSku;
	}

	public WebElement getSeachResultProductName() {
		return eSeachResultProductName;
	}

	public WebElement getSeachResultProductOriginalPrice() {
		return eSeachResultProductOriginalPrice;
	}

	public WebElement getSeachResultProductDiscountedPrice() {
		return eSeachResultProductDiscountedPrice;
	}


}
