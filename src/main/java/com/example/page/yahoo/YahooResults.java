package com.example.page.yahoo;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

/**
 * Page Object for Yahoo.co.jp Search Result.
 *
 * @author HyungCheol Kim
 */
public class YahooResults {
    @Getter
    private final ElementsCollection result = $$("#WS2m .w");

    public SelenideElement firstResultSectionText() {
        return result.get(0);
    }
}
