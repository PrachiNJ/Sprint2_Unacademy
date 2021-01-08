package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.Un_Startlearning;



public class Un_StartlearningSteps
{
	Un_Startlearning u=new Un_Startlearning();
	
	@Given("^user opens unacademy url$")
    public void user_opens_unacademy_url() {
        u.openurl();
    }

    @Given("^user is on exam module page$")
    public void user_is_on_exam_module_page() throws Throwable {
       u.exam_module();
    }

    @When("^select start learning$")
    public void select_start_learning() throws Throwable {
        u.validate_button();
    }

    @When("^user selects an exam$")
    public void user_selects_an_exam() throws Throwable {
        
    }

    @When("^user selects a course$")
    public void user_selects_a_course() throws Throwable {
        
    }

    @Then("^display exam module page$")
    public void display_exam_module_page() throws Throwable {
        u.exam_module();
    }

    @Then("^display courses offered$")
    public void display_courses_offered() throws Throwable {
        
    }

    @Then("^displays subscription page$")
    public void displays_subscription_page() throws Throwable {
        
    }
}
