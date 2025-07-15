package co.edu.udea.screenplay.screenplay.stepdefinitions;

import co.edu.udea.screenplay.screenplay.questions.ValidationLogin;
import co.edu.udea.screenplay.screenplay.tasks.LoginTask;
import co.edu.udea.screenplay.screenplay.tasks.OpenBrowserTask;
import co.edu.udea.screenplay.screenplay.tasks.WaitForCaptcha;
import co.edu.udea.screenplay.screenplay.userinterfaces.UserInterface;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import org.openqa.selenium.WebDriver;


import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.*;
public class LoginSteps {

    @Managed(driver = "chrome")
    private WebDriver driver;

    private Actor customer;

    @Before
    public void setUp() {
        OnStage.setTheStage(new OnlineCast());
        customer = OnStage.theActorCalled("customer");
        customer.can(BrowseTheWeb.with(driver));
    }

    @Given("Estoy en la página de inicio de sesión")
    public void enLaPaginaDeInicioSesion() {
        customer.attemptsTo(
                OpenBrowserTask.onLoginPage()
        );
    }

    @Given("Estoy en la pagina principal")
    public void enLaPaginaDeInicio() {
        customer.attemptsTo(
                OpenBrowserTask.onLoginPage()
        );
    }

    @When("intento iniciar sesión con correo {string} y contraseña {string}")
    public void intentoLoginFallido(String email, String password) {
        customer.attemptsTo(
                LoginTask.withCredentials(email, password)
        );
    }

    @When("doy click en el botón de inicio de sesion")
    public void clickBotonInicioSesion() {
        customer.attemptsTo(
                Click.on(UserInterface.LOGIN_BUTTON)
        );
    }

    @Then("el sistema muestra un mensaje de error {string}")
    public void verificarMensajeError(String mensajeErrorEsperado) {
        customer.should(
                seeThat("El mensaje de error",
                        ValidationLogin.rechazoLogin(mensajeErrorEsperado),
                        is(true)
                )
        );
    }

    @Then("deberia ver el texto {string}")
    public void verificarUsuarioLogueado(String mensajeEsperado) {
        customer.should(
                seeThat("El mensaje de bienvenida",
                        ValidationLogin.mensajeContieneTexto(mensajeEsperado),
                        is(true)
                )
        );
    }
}