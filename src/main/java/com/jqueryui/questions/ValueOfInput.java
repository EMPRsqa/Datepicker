package com.jqueryui.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;

public class ValueOfInput implements Question<String> {

    private final Target inputTarget;

    public ValueOfInput(Target inputTarget) {
        this.inputTarget = inputTarget;
    }

    @Override
    public String answeredBy(Actor actor) {
        // La Question Text.of() es la que realmente obtiene el texto del elemento.
        return Text.of(inputTarget).answeredBy(actor);
    }

    public static ValueOfInput theValueOf(Target inputTarget) {
        return new ValueOfInput(inputTarget);
    }
}
