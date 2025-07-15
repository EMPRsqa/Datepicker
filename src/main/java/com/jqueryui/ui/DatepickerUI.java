package com.jqueryui.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class DatepickerUI {
    public static Target DRP_DATEP = Target.the("Activate DROPDOWN")
            .located(By.id("datepicker")); // "//*[@id='datepicker']");
    public static Target TXT_DATEP = Target.the("Activate DROPDOWN")
            .locatedBy("//*[text()='15'][ancestor::td[@data-month='8' and @data-year='2025']]"); // "//*[@id='datepicker']");
    public static Target BTN_NEXTM = Target.the("Next mounth")
            .locatedBy("//span[contains(@class, 'ui-icon-circle-triangle-e')]");  //span[contains(@class, 'ui-icon-circle-triangle-e') and normalize-space()='Next']");
    public static Target PAGE_BODY = Target.the("Page Body").located(By.tagName("body"));

    public static Target LBL_DAY = Target.the("Seleccionar día")
            .located(By.xpath("//a[text()='15']"));
}