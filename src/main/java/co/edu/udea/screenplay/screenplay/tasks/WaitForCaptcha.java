package co.edu.udea.screenplay.screenplay.tasks;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Actor;

public class WaitForCaptcha implements Task {
    private final int seconds;

    public WaitForCaptcha(int seconds) {
        this.seconds = seconds;
    }

    public static WaitForCaptcha forSeconds(int seconds) {
        return new WaitForCaptcha(seconds);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}