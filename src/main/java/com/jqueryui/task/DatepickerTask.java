package com.jqueryui.task;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.jqueryui.ui.DatepickerUI.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class DatepickerTask implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(DRP_DATEP, isClickable()).forNoMoreThan(10).seconds(),
                Click.on(DRP_DATEP)
                /*
                Click.on(BTN_NEXTM),
                Click.on(LBL_DAY)
                */
        );

    }
    public static Performable dateTask() {
        return instrumented(DatepickerTask.class);}
}
