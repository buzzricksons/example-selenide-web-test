package com.example.basic;

import com.example.AbstractTests;
import com.example.Settings;
import com.example.page.google.GoogleResultsPage;
import com.example.page.google.GoogleSearchPage;
import org.junit.Test;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

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
        $$("#ires .g").get(0).shouldHave(text("Selenide: concise UI tests in Java"));
    }
}
