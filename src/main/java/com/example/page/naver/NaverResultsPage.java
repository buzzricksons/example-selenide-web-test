package com.example.page.naver;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$;

/**
 * Page Object for Naver.com Search Result.
 *
 * @author HyungCheol Kim
 */
public class NaverResultsPage {
    public ElementsCollection results() {
        return $$(".main_pack");
    }

    public SelenideElement getResultBy(int index) {
        return $$(".main_pack").get(index);
    }
}
