package com.example.page.google;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$;

/**
 * Page Object for Google Search Result.
 *
 * @author HyungCheol Kim
 */
public class GoogleResultsPage {
    private final ElementsCollection result = $$("#ires .g");
    public ElementsCollection result() {
        return result;
    }

    public SelenideElement firstSectionText() {
        return result.get(0);
    }
}
