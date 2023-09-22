package org.pom;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage extends BaseClass{
	
	public RegistrationPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="firstname")
	private WebElement txtFirstName;
	@FindBy(name="lastname")
	private WebElement txtLastName;
	@FindBy(name="reg_email__")
	private WebElement txtPh;
	@FindBy(xpath="(//a[@role='button'])[2]")
	private WebElement btnCreate;
	@FindBy(name="websubmit")
	private WebElement btnsignUp;
	
	public WebElement getTxtFirstName() {
		return txtFirstName;
	}
	public WebElement getTxtLastName() {
		return txtLastName;
	}
	public WebElement getTxtPh() {
		return txtPh;
	}
	public WebElement getBtnCreate() {
		return btnCreate;
	}
	public WebElement getBtnsignUp() {
		return btnsignUp;
	}
	
	
	

}
