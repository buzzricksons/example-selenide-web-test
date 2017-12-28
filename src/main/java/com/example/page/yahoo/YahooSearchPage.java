package com.example.page.yahoo;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

/**
 * Page Object for Yahoo.co.jp Search.
 *
 * @author HyungCheol Kim
 */
public class YahooSearchPage {
    @FindBy(how = How.NAME, using = "p")
    private SelenideElement searchBox;

    public YahooResultsPage search(String query) {
        searchBox.setValue(query).pressEnter();
        return page(YahooResultsPage.class);
    }
}
