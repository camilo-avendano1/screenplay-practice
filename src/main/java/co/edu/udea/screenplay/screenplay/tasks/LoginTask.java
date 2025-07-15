package co.edu.udea.screenplay.screenplay.tasks;

import co.edu.udea.screenplay.screenplay.interactions.InteractionLogin;
import co.edu.udea.screenplay.screenplay.userinterfaces.UserInterface;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class LoginTask implements Task {

    private final String email;
    private final String password;

    private LoginTask(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public static LoginTask withCredentials(String email, String password) {
        return new LoginTask(email, password);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(UserInterface.LOGIN_BUTTON),
                Enter.theValue(email).into(UserInterface.EMAIL_INPUT),
                Enter.theValue(password).into(UserInterface.PASSWORD_INPUT),
                Click.on(UserInterface.LOGIN_BUTTON_CONFIRMATION)
        );
    }
}