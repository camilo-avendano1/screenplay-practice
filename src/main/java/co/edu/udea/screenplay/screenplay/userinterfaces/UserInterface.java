package co.edu.udea.screenplay.screenplay.userinterfaces;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;



public class UserInterface extends PageObject {
    public static final Target LOGIN_BUTTON = Target.the("Login/Signup button").located(By.xpath("//a[contains(., 'Signup / Login')]"));

    public static final Target EMAIL_INPUT = Target.the("EMAIL_INPUT").locatedBy("//*[@id='form']/div/div/div[1]/div/form/input[2]");

    public static final Target PASSWORD_INPUT = Target.the("PASSWORD_INPUT").locatedBy("//*[@id='form']/div/div/div[1]/div/form/input[3]");

    public static final Target LOGIN_BUTTON_CONFIRMATION = Target.the("Login confirmation button").located(By.xpath("//button[text()='Login']"));

    public static final Target USER_LOGGED = Target.the("USER_LOGGED").locatedBy("//*[@id='header']/div/div/div/div[2]/div/ul/li[10]");


}