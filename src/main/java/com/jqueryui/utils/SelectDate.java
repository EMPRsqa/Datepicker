package com.jqueryui.utils;

import com.jqueryui.ui.DatepickerUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.questions.Visibility;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.By;
import net.serenitybdd.screenplay.targets.Target;

import java.util.Calendar;

import static com.jqueryui.ui.DatepickerUI.DRP_DATEP;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.hamcrest.Matchers.equalTo;

public class SelectDate implements Task {
    public String inputValue;
    private final int targetYear;
    private final int targetMonth; // 1 = January, 12 = December
    private final int targetDay;

    private SelectDate(int year, int month, int day) {
        this.targetYear = year;
        this.targetMonth = month;
        this.targetDay = day;
    }

    // Método estático que recibe la fecha en formato MM/DD/YYYY
    public static SelectDate of(String date) {
        if (date == null || !date.matches("\\d{2}/\\d{2}/\\d{4}")) {
            throw new IllegalArgumentException("format MM/DD/YYYY");

        }

        String[] parts = date.split("/");
        int month = Integer.parseInt(parts[0]);
        int day = Integer.parseInt(parts[1]);
        int year = Integer.parseInt(parts[2]);

        return new SelectDate(year, month, day);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(DatepickerUI.DRP_DATEP),
                WaitUntil.the(DatepickerUI.BTN_NEXTM, isVisible()).forNoMoreThan(10).seconds()
        );


        Calendar calendar = Calendar.getInstance();
        int currentYear = calendar.get(Calendar.YEAR);
        int currentMonth = calendar.get(Calendar.MONTH) + 1; // Calendar.MONTH es 0-based

        int monthsToClick = calculateMonthsDifference(currentYear, currentMonth, targetYear, targetMonth);

        for (int i = 0; i < monthsToClick; i++) {
            actor.attemptsTo(
                    Click.on(DatepickerUI.BTN_NEXTM)
            );
        }

        Target dayTarget = Target.the("Day " + targetDay)
                .located(By.xpath("//a[text()='" + targetDay + "']"));

        Target TXT_DATE = Target.the("confirm date")
.locatedBy("//*[text()='13'][ancestor::td[@data-month='6' and @data-year='2025' and (@class=\"  ui-datepicker-current-day\" or @class=\" ui-datepicker-week-end  ui-datepicker-current-day\")]]\n" +
        " ");


        actor.attemptsTo(
                Click.on(dayTarget),
                Click.on(DRP_DATEP)
        );
        seeThat("El mensaje de confirmación está visible",
                Visibility.of(TXT_DATE).asBoolean(),
                equalTo(true)
        );

        this.inputValue = DRP_DATEP.resolveFor(actor).getText();  //Text.of(DRP_DATEP).answeredBy(theActorInTheSpotlight());
          System.out.println("Contenido del otro input: " + this.inputValue);
        //
    }

    private int calculateMonthsDifference(int currentYear, int currentMonth, int targetYear, int targetMonth) {
        return (targetYear - currentYear) * 12 + (targetMonth - currentMonth);
    }
}
