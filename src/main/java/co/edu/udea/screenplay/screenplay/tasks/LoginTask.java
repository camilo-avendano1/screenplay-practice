package co.edu.udea.screenplay.screenplay.tasks;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import co.edu.udea.screenplay.screenplay.interactions.LoginInteractions;
import co.edu.udea.screenplay.screenplay.userinterfaces.UserInterface;

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
    public <T extends net.serenitybdd.screenplay.Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.browserOn(new UserInterface()),
                LoginInteractions.withCredentials(email, password)
        );
    }
}