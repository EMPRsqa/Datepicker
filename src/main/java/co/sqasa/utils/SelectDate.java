package co.sqasa.utils;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

public class SelectDate {

    private final String year;
    private final String month;
    private final String day;
    private final String fullDate;


    public SelectDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.parse(date, formatter);

        this.year = String.valueOf(localDate.getYear());
        // Obtiene el nombre del mes en español y lo capitaliza (e.g., "Ago" para Agosto)
        String monthName = localDate.getMonth().getDisplayName(TextStyle.SHORT, new Locale("es", "ES"));
        this.month = monthName.substring(0, 1).toUpperCase() + monthName.substring(1, 3);
        this.day = String.valueOf(localDate.getDayOfMonth());
        this.fullDate = String.format("Seleccionar %s/%s/%s", this.day, localDate.getMonthValue(), this.year);
    }

    public Target getYear() {
        return Target.the("year " + year)
                .located(By.xpath(String.format("//*[text() = '%s']", year)));
    }

    public Target getMonth() {
        return Target.the("month " + month)
                .located(By.xpath(String.format("//*[text() = '%s']", month)));
    }

    public Target getDay() {
        return Target.the("day " + day)
                .located(By.xpath(String.format("//div[@aria-label='%s']", fullDate)));
    }
}
