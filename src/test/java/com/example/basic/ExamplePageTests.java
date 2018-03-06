package com.example.basic;

import com.example.AbstractTests;
import com.example.Settings;
import org.junit.Test;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

/**
 * Test for Example Search.
 *
 * @author HyungCheol Kim
 *
 */
public class ExamplePageTests extends AbstractTests {
    @Autowired
    private Settings settings;

    /**
     * Test for keyword "selenide".
     *
     */
    @Test
    public void testExampleSearch() {
        open(settings.getGooglePage());
        $(By.name("q")).val("selenide").pressEnter();
        $("#ires .g").shouldHave(text("Selenide: concise UI tests in Java"));
    }
}
