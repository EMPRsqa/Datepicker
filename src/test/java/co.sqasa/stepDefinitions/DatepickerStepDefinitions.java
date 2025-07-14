package co.sqasa.stepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.actors.OnStage.*;

public class DatepickerStepDefinitions {
    @Before
    public void setStage(){
        setTheStage(new OnlineCast());
    }

    @Given("the user opens the calendar in the form")
    public void theUserOpensTheCalendarInTheForm() {
        theActorCalled("actor").wasAbleTo(
                Open.url("https://jqueryui.com/datepicker/")

                /*SpecialRefoundAVTask.specialRefoundAV(),
                PreLoginTask.preLogin(),
                SwitchLogin.onPop(),
                LoginTask.withCredentials(),
                SwitchToMainWindow.now(),
                PostLoginTask.postLogin()
                 */
        );
    }

    @When("they navigate to August {int} and select the 15th day")
    public void theyNavigateToAugustAndSelectThe15thDay(Integer int1) {
    }
    @Then("the selected date is displayed correctly in the field")
    public void theSelectedDateIsDisplayedCorrectlyInTheField() {
    }

}
