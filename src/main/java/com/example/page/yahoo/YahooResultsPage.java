package com.example.page.yahoo;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.$;

/**
 * Page Object for Yahoo.co.jp Search Result.
 *
 * @author HyungCheol Kim
 */
public class YahooResultsPage {
    @FindBy(how = How.CSS, using = "#WS2m .w")
    public ElementsCollection results;

    public ElementsCollection results() {
        return results;
    }

    public SelenideElement getResult(int index) {
        return $("#WS2m .w", index);
    }
}
