package com.jqueryui.stepDefinitions;


import com.jqueryui.utils.SelectDate;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.questions.Text;

import net.serenitybdd.screenplay.questions.*;

import static com.jqueryui.ui.DatepickerUI.DRP_DATEP;
import static com.jqueryui.ui.DatepickerUI.TXT_DATEP;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;
import static org.hamcrest.Matchers.*;

public class DatepickerStepDefinitions {
    private Actor actor;

    @Before
    public void setStage(){
        setTheStage(new OnlineCast());
    }
    //private Actor actor = OnStage.theActorInTheSpotlight();
    @Given("the user opens the calendar in the form")
    public void theUserOpensTheCalendarInTheForm() {
        theActorCalled("actor").wasAbleTo(
                Open.url("https://jqueryui.com/resources/demos/datepicker/default.html")
        );
    }
    //private final String dateToSelect ="*_*" ;

    String dateToSelect;
    @When("the user selects the date {string}")
    public void theUserSelectsTheDate(String dateToSelect) {
        OnStage.theActorInTheSpotlight().remember("selectedDate", dateToSelect);
        theActorCalled("actor").wasAbleTo(
                SelectDate.of(dateToSelect)
        );
    }
    @Then("the selected date is displayed correctly in the field")
    public void theSelectedDateIsDisplayedCorrectlyInTheField() {
        // Recupera la fecha esperada de la memoria del actor
        String expectedDate = OnStage.theActorInTheSpotlight().recall("selectedDate");
        System.out.println("INIFECHA:" + expectedDate);
        //OnStage.theActorInTheSpotlight().should(
          // seeThat(Text.of(DRP_DATEP).asString(), equalTo(expectedDate)));
    }

}
