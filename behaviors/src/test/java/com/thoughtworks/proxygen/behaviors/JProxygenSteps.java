package com.thoughtworks.proxygen.behaviors;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class JProxygenSteps {    

    @Given("an interface method $methodSignature")
    public void given(String methodSignature) {
    }

    @When("a proxy class is generated")
    public void when() {
    }

    @Then("it is the equivalent of $methodBody")
    public void then(String methodBody) {
    }

}
