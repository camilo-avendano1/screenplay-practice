package co.edu.udea.screenplay.screenplay.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.questions.Visibility;

import static co.edu.udea.screenplay.screenplay.userinterfaces.UserInterface.USER_LOGGED;
import static co.edu.udea.screenplay.screenplay.userinterfaces.UserInterface.USER_UNLOGGED;

public class ValidationLogin {

    public static Question<Boolean> mensajeContieneTexto(String textoEsperado) {
        return Question.about("si el mensaje contiene el texto: " + textoEsperado)
                .answeredBy(actor ->
                        Text.of(USER_LOGGED).answeredBy(actor)
                                .contains(textoEsperado)
                );
    }

    public static Question<Boolean> rechazoLogin(String textoEsperado) {
        return Question.about("si el usuario es rechazado: " + textoEsperado)
                .answeredBy(actor ->
                        Text.of(USER_UNLOGGED).answeredBy(actor)
                                .contains(textoEsperado)
                );
    }
}