package com.example.page.google;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$$;

/**
 * Page Object for Google Search Result.
 *
 * @author HyungCheol Kim
 */
public class GoogleResults {
    @Getter
    private final ElementsCollection result = $$("#ires .g");

    public SelenideElement firstSectionTitle() {
        return result.get(0);
    }
}
