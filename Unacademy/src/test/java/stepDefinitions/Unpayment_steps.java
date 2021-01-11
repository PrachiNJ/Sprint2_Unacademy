package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.Card;
import pages.Login;
import pages.Netbanking;
import pages.UPI;
import pages.Wallet;

public class Unpayment_steps {
	
	Login l= new Login();
	UPI u= new UPI();
	Netbanking n= new Netbanking();
	Wallet w= new Wallet();
	Card c=new Card();
	
	@Given("^the user is on payment page$")
    public void the_user_is_on_payment_page() throws Throwable {
		l.openurl();
        l.subscription();
        l.signin();
    }
	
	@When("^user clicks on change duration option$")
    public void user_clicks_on_change_duration_option() throws Throwable {
        l.changeduration();
    }

    @Then("^subscription page will be displayed$")
    public void subscription_page_will_be_displayed() throws Throwable {
        l.backtopayment();
    }
    
    @When("^clicked on Card Option$")
    public void clicked_on_card_option() throws Throwable {
        c.selectcard();
    }

    @Then("^the user should be directed to further steps$")
    public void the_user_should_be_directed_to_further_steps() throws Throwable {
        c.cardtransac();
    }

    @And("^entered any value for (.+),(.+),(.+),(.+) and (.+)$")
    public void entered_any_value_for_and(String cardno, String mm, String yy, String cvv, String cardname) throws Throwable {
        c.entervalues(cardno, mm, yy, cvv, cardname);
    }

    @And("^click on cardpay$")
    public void click_on_cardpay() throws Throwable {
        c.card_pay();
    }
    
    @When("^clicked on Netbanking option$")
    public void clicked_on_netbanking_option() throws Throwable {
        n.selectnet();
    }

    @Then("^the user should be directed to the respective bank page$")
    public void the_user_should_be_directed_to_the_respective_bank_page() throws Throwable {
        n.nettransac();
    }

    @And("^click on any bank$")
    public void click_on_any_bank() throws Throwable {
        n.selectbank();
    }

    @And("^click on pay$")
    public void click_on_pay() throws Throwable {
        n.netbanking_pay();
    }
    
    @When("^clicked on UPI option$")
    public void clicked_on_upi_option() throws Throwable {
        u.selectupi();
    }

    @Then("^a new page will be displayed for further steps$")
    public void a_new_page_will_be_displayed_for_further_steps() throws Throwable {
        u.upitransac();
    }

    @And("^enter the (.+)$")
    public void enter_the(String phoneno) throws Throwable {
        u.enter_no(phoneno);
    }

    @And("^click on upiPay$")
    public void click_on_upipay() throws Throwable {
        u.upipay();
    }
    
    @When("^clicked on Wallet option$")
    public void clicked_on_wallet_option() throws Throwable {
        w.selectwall();
    }

    @Then("^a Wallet page will be displayed for further steps$")
    public void a_wallet_page_will_be_displayed_for_further_steps() throws Throwable {
        w.waltransac();
    }

    @And("^select any wallet ,enter the (.+)$")
    public void select_any_wallet_enter_the(String phno) throws Throwable {
        w.choosewal(phno);
    }

    @And("^click on Wallet Pay button$")
    public void click_on_wallet_pay_button() throws Throwable {
        w.wallet_pay();
    }

}
