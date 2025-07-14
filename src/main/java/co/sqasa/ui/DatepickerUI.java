package co.sqasa.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class DatepickerUI {
    public static Target DRP_DATEP = Target.the("Activate DROPDOWN")
            .located(By.xpath("//input[contains(@placeholder, 'dd/mm/aaaa')]"));
    public static Target EXPN_PASSENGER_1 = Target.the("expansion panel Pasajero 1")
            .locatedBy("//span[text() = ' Añadir Pasajero ']/ancestor::mat-card//span[@style='transform: rotate(0deg);']");
                    // (By.id("mat-expansion-panel-header-0"));

    public static Target EXPN_PASSENGER_2 = Target.the("CheckBox panel Pasajeros")
            .located(By.xpath(("(//*[@toggleposition= 'after'])[1]")));
    public static Target CHB_PASSENGER = Target.the("CheckBox Un mark Pasajeros")
            .located(By.xpath(("//*[@toggleposition= 'after']")));
    public static Target TAG_OTRA = Target.the("expansion panel Otra persona")
            .located(By.xpath("//span/b[text()='Otra persona']"));
    public static Target TAG_NAME = Target.the("expansion panel 2 Nombres")
            .located(By.id("mat-input-7"));
    public static Target TAG_LNAME = Target.the("expansion panel 2 Apellidos")
            .located(By.id("mat-input-8"));
    public static Target TAG_EMAIL = Target.the("expansion panel 2 Correo electrónico")
            .located(By.id("mat-input-0"));
    public static Target TAG_CEMAIL = Target.the("expansion panel 2 Confirmar Correo electrónico")
            .located(By.id("mat-input-1"));
    public static Target UPL_FILE = Target.the("expansion panel 2 Seleccionar archivo")
            .located(By.xpath("//input[@type='file']"));   //label[text()='Seleccionar archivo']"));
    public static Target BTN_CONTINUE2 = Target.the("Click on continue to next step")
            .located(By.id("options1"));
}
