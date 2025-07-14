package co.sqasa.utils;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.By;
import net.serenitybdd.screenplay.targets.Target;

import java.util.Calendar;

import static co.sqasa.ui.DatepickerUI.BTN_NEXTM;
import static co.sqasa.ui.DatepickerUI.DRP_DATEP;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SelectDate implements Task {

    private final int targetYear;
    private final int targetMonth; // 1 = January, 12 = December
    private final int targetDay;

    // Constructor privado para forzar uso del método estático con formato MM/DD/YYYY
    private SelectDate(int year, int month, int day) {
        this.targetYear = year;
        this.targetMonth = month;
        this.targetDay = day;
    }

    // Método estático que recibe la fecha en formato MM/DD/YYYY
    public static SelectDate of(String date) {
        // Validar formato básico
        if (date == null || !date.matches("\\d{2}/\\d{2}/\\d{4}")) {
            throw new IllegalArgumentException("La fecha debe tener formato MM/DD/YYYY");
        }

        String[] parts = date.split("/");
        int month = Integer.parseInt(parts[0]);
        int day = Integer.parseInt(parts[1]);
        int year = Integer.parseInt(parts[2]);

        return new SelectDate(year, month, day);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        // Abrir el datepicker
        actor.attemptsTo(
                Click.on(DRP_DATEP),
                WaitUntil.the(BTN_NEXTM, isVisible()).forNoMoreThan(5).seconds()
        );

        // Obtener fecha actual del sistema
        Calendar calendar = Calendar.getInstance();
        int currentYear = calendar.get(Calendar.YEAR);
        int currentMonth = calendar.get(Calendar.MONTH) + 1; // Calendar.MONTH es 0-based

        // Calcular cuántos clicks en BTN_NEXTM se necesitan para llegar al mes y año objetivo
        int monthsToClick = calculateMonthsDifference(currentYear, currentMonth, targetYear, targetMonth);

        // Hacer clic en BTN_NEXTM la cantidad de veces necesarias
        for (int i = 0; i < monthsToClick; i++) {
            actor.attemptsTo(
                    Click.on(BTN_NEXTM)
            );
        }

        // Seleccionar el día
        Target dayTarget = Target.the("Day " + targetDay)
                .located(By.xpath("//a[text()='" + targetDay + "']"));

        actor.attemptsTo(
                Click.on(dayTarget)
        );
    }

    private int calculateMonthsDifference(int currentYear, int currentMonth, int targetYear, int targetMonth) {
        return (targetYear - currentYear) * 12 + (targetMonth - currentMonth);
    }
}
