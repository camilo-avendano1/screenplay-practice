package co.edu.udea.screenplay.screenplay.interactions;


import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import co.edu.udea.screenplay.screenplay.userinterfaces.UserInterface;

public class LoginInteractions implements Interaction {

    private final String email;
    private final String password;

    private LoginInteractions(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public static LoginInteractions withCredentials(String email, String password) {
        return new LoginInteractions(email, password);
    }

    @Override
    public <T extends net.serenitybdd.screenplay.Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(UserInterface.LOGIN_BUTTON),
                Enter.theValue(email).into(UserInterface.EMAIL_INPUT),
                Enter.theValue(password).into(UserInterface.PASSWORD_INPUT),
                Click.on(UserInterface.LOGIN_BUTTON_CONFIRMATION)
        );
    }

    @Override
    public String toString() {
        return "intenta iniciar sesión con credenciales proporcionadas";
    }
}