package co.edu.udea.screenplay.screenplay.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.edu.udea.screenplay.screenplay.userinterfaces.UserInterface.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;



public class InteractionLogin implements Interaction {
    private String email;
    private String password;
    private boolean fullFlow;


    public InteractionLogin(String email, String password, boolean fullFlow) {
        this.email = email;
        this.password = password;
        this.fullFlow = fullFlow;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        if(fullFlow) {
            executeFullLoginFlow(actor);
        } else {
            executeSingleAction(actor);
        }
    }

    private <T extends Actor> void executeFullLoginFlow(T actor) {
        actor.attemptsTo(
                WaitUntil.the(LOGIN_BUTTON, isClickable()).forNoMoreThan(10).seconds(),
                Click.on(LOGIN_BUTTON),

                WaitUntil.the(EMAIL_INPUT, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(email).into(EMAIL_INPUT),

                Enter.theValue(password).into(PASSWORD_INPUT),

                WaitUntil.the(LOGIN_BUTTON_CONFIRMATION, isClickable()).forNoMoreThan(10).seconds(),
                Click.on(LOGIN_BUTTON_CONFIRMATION)
        );
    }

    private <T extends Actor> void executeSingleAction(T actor) {
        actor.attemptsTo(
                WaitUntil.the(LOGIN_BUTTON_CONFIRMATION, isClickable()).forNoMoreThan(10).seconds(),
                Click.on(LOGIN_BUTTON_CONFIRMATION)
        );
    }

    public static InteractionLogin fullFlow(String email, String password) {
        return new InteractionLogin(email, password, true);
    }

    public static InteractionLogin justConfirm() {
        return new InteractionLogin(null, null, false);
    }
}