/*
 * Copyright 2006-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.citrus;

import static com.consol.citrus.DefaultTestActionBuilder.action;

import com.consol.citrus.TestCaseRunner;
import com.consol.citrus.annotations.CitrusResource;
import com.consol.citrus.config.CitrusSpringConfig;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

/**
 * @author Christoph Deppisch
 */
//@SuppressWarnings("SpringJavaAutowiringInspection")
//@CucumberContextConfiguration
//@ContextConfiguration(classes = CitrusSpringConfig.class)
public class TodoSteps {

    @CitrusResource
    private TestCaseRunner runner;

    private List<String> todos;

    @Given("^Todo list is empty$")
    public void empty_todos() {
        runner.given(action((context) -> todos = new ArrayList<>()));
    }

    @When("^(?:I|user) adds? entry \"([^\"]*)\"$")
    public void add_entry(String todoName) {
        runner.when(action((context) -> todos.add("a todo")));
    }


    @Then("^(?:the )?number of todo entries should be (\\d+)$")
    public void verify_todos(int todoCnt) {
        runner.then(action((context) -> Assertions.assertEquals(1, todos.size())));

    }
}
