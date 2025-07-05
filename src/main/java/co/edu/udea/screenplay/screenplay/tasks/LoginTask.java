package co.edu.udea.screenplay.screenplay.tasks;

import co.edu.udea.screenplay.screenplay.interactions.InteractionLogin;
import co.edu.udea.screenplay.screenplay.userinterfaces.UserInterface;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

public class LoginTask implements Task {
    private final String email;
    private final String password;

    public LoginTask(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                InteractionLogin.fullFlow(email, password)
        );
    }

    public static LoginTask withCredentials(String email, String password) {
        return Tasks.instrumented(LoginTask.class, email, password);
    }
}