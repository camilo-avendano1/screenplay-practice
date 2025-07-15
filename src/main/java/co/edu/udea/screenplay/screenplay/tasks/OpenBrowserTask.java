package co.edu.udea.screenplay.screenplay.tasks;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Open;
import co.edu.udea.screenplay.screenplay.userinterfaces.UserInterface;

public class OpenBrowserTask implements Task {

    public static OpenBrowserTask onLoginPage() {
        return new OpenBrowserTask();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.browserOn(new UserInterface()),
                WaitForCaptcha.forSeconds(5)
        );
    }
}