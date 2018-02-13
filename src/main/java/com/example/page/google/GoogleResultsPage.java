package com.example.page.google;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

/**
 * Page Object for Google Search Result.
 *
 * @author HyungCheol Kim
 */
public class GoogleResultsPage {
    public ElementsCollection results() {
        return $$("#ires .g");
    }

    public SelenideElement getResultBy(int index) {
        return $$("#ires .g").get(index);
    }
}
