package co.sqasa.task;

import co.sqasa.utils.SelectDate;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.Upload;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.io.File;
import java.util.List;

import static co.sqasa.ui.DatepickerUI.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class DatepickerTask implements Task {
    //------Datepicker---------
    private final String date;

    public DatepickerTask(String date) {this.date = date;}
    //------Datepicker---------
    public String tag_name = "Demo";
    public String tag_lName = "Tster";
    public String tag_email = "demo@tester.co";

    public int i = 0;

    @Override
    public <T extends Actor> void performAs(T actor) {
//------Datepicker---------
        SelectDate selectDate = new SelectDate(date);
        actor.attemptsTo(
                WaitUntil.the(DRP_DATEP, isClickable()).forNoMoreThan(10).seconds(),
                Click.on(DRP_DATEP),
                Click.on(selectDate.getYear()),
                Click.on(selectDate.getMonth()),
                Click.on(selectDate.getDay())
        );
//------Datepicker---------

        List<WebElementFacade> elementos = EXPN_PASSENGER_1.resolveAllFor(actor);
        List<WebElementFacade> unCHB = CHB_PASSENGER.resolveAllFor(actor);
        System.out.println(elementos.size());
        System.out.println(unCHB.size());
        for (WebElementFacade elemento : elementos) {

                actor.attemptsTo(
                        Scroll.to(elemento),//SCROLL opcional
                        Click.on(elemento)); // da clic en cada elemento
            if (elementos.size() > 1){
                if (i == 0 && unCHB.size() > 1) {
                    actor.attemptsTo(
                            //Scroll.to(elemento),//SCROLL opcional
                            Click.on(EXPN_PASSENGER_2));
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                i++;
            }
        }

        actor.attemptsTo(
                Click.on(TAG_OTRA),
                Enter.theValue(tag_name).into(TAG_NAME),
                Enter.theValue(tag_lName).into(TAG_LNAME),
                Enter.theValue(tag_email).into(TAG_EMAIL),
                Enter.theValue(tag_email).into(TAG_CEMAIL),
                //Click.on(UPL_FILE)
                Upload.theFile(new File("src/test/resources/Data/Dummi.pdf").toPath()).to(UPL_FILE),
                Scroll.to(BTN_CONTINUE2),
                Click.on(BTN_CONTINUE2)
//                WaitUntil.the(DRP_PASS, isVisible()).forNoMoreThan(90).seconds()
        );

    }
    public static Performable pasajeros2Task(String date) {return instrumented(DatepickerTask.class,date);}
}
