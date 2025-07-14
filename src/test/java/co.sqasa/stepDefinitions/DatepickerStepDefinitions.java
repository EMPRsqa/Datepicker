package co.sqasa.stepDefinitions;

import co.sqasa.utils.SelectDate;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static co.sqasa.task.DatepickerTask.dateTask;
import static net.serenitybdd.screenplay.actors.OnStage.*;

public class DatepickerStepDefinitions {
    @Before
    public void setStage(){
        setTheStage(new OnlineCast());
    }

    @Given("the user opens the calendar in the form")
    public void theUserOpensTheCalendarInTheForm() {
        theActorCalled("actor").wasAbleTo(
                Open.url("https://jqueryui.com/resources/demos/datepicker/default.html"),
                dateTask()//"02/12/2024")

        );
    }

    @When("the user selects the date {string}")
    public void TheUserSelectsTheDate(String dateToSelect) {
        theActorCalled("actor").wasAbleTo(
                SelectDate.of(dateToSelect)
        );
    }
    @Then("the selected date is displayed correctly in the field")
    public void theSelectedDateIsDisplayedCorrectlyInTheField() {
    }

}
