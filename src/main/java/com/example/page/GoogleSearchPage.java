package com.example.page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class GoogleSearchPage {
    @FindBy(how = How.NAME, using = "q")
    private SelenideElement searchBox;

    public GoogleResultsPage search(String query) {
        searchBox.setValue(query).pressEnter();
        return page(GoogleResultsPage.class);
    }
}
