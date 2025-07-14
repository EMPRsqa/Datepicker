package co.sqasa.interactions;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;

public class SwitchToMainWindow implements Interaction
{

    @Override
    public <T extends Actor> void performAs(T actor)
    {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        String mainWindow = driver.getWindowHandles().iterator().next();
        driver.switchTo().window(mainWindow);
        /*
        try {Thread.sleep(10000);}
        catch (InterruptedException e) {e.printStackTrace();}

         */
    }

    public static SwitchToMainWindow now()
    {

        return new SwitchToMainWindow();
    }
}