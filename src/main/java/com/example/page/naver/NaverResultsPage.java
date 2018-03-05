package com.example.page.naver;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.RequiredArgsConstructor;
import lombok.Value;

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
}
