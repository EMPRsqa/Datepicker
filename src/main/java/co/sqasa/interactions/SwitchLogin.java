package co.sqasa.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;

public class SwitchLogin implements Interaction
{
    //private WebDriver driver;
    //public SwitchLogin(WebDriver driver){this.driver = driver; }
    @Override
    public <T extends Actor> void performAs(T actor)
    {
        //Alert alert = driver.switchTo().newWindow();
        //alert.accept();
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        String mainWindow = driver.getWindowHandle();

        for (String windowHandle : driver.getWindowHandles())
        {
            if (!windowHandle.equals(mainWindow))
            {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        try {Thread.sleep(5000);}
        catch (InterruptedException e) {e.printStackTrace();}

    }
    //public static SwitchLogin onPop(WebDriver driver){return new SwitchLogin(driver); }
    public static SwitchLogin onPop()
    {
        return new SwitchLogin();
    }

}
