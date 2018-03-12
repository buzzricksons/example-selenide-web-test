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
public class YahooResults {
    private final ElementsCollection result = $$("#WS2m .w");
    public ElementsCollection result() {
        return result;
    }

    public SelenideElement firstResultSectionText() {
        return result.get(0);
    }
}
