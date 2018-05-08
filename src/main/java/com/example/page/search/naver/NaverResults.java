package com.example.page.search.naver;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$$;

/**
 * Page Object for Naver.com Search Result.
 *
 * @author HyungCheol Kim
 */
public class NaverResults {
    @Getter
    private final ElementsCollection result = $$(".main_pack");

    public SelenideElement firstResultSectionText() {
        return result.get(0).find(".dic_dsc");
    }
}
