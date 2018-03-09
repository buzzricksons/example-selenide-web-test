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
     * Test for keyword "selenide" by basic pattern.
     *
     */
    @Test
    public void testExampleSearchByBasic() {
        open(settings.getGooglePage());
        $(By.name("q")).val("selenide").pressEnter();
        $("#ires .g").shouldHave(text("Selenide: concise UI tests in Java"));
        $$("#ires .g").shouldHaveSize(10);
    }

    /**
     * Test for keyword "selenide" by Page Object Model pattern.
     *
     */
    @Test
    public void testExampleSearchByPOMPattern() {
        GoogleSearchPage searchPage = open(settings.getGooglePage(), GoogleSearchPage.class);
        GoogleResultsPage resultsPage = searchPage.keywordSearchBy("selenide");
        resultsPage.results().get(0).shouldHave(text("Selenide: concise UI tests in Java"));
        resultsPage.results().shouldHaveSize(10);
    }
}
