package com.example.page.yahoo;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

/**
 * Page Object for Yahoo.co.jp Search Result.
 *
 * @author HyungCheol Kim
 */
public class YahooResultsPage {
    public ElementsCollection results() {
        return $$("#WS2m .w");
    }

    public SelenideElement getResult(int index) {
        return $("#WS2m .w", index);
    }
}
