package com.example.page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.$;

/**
 * Page Object for Google Search Result.
 *
 * @author HyungCheol Kim
 */
public class GoogleResultsPage {
    @FindBy(how = How.CSS, using = "#ires .g")
    public ElementsCollection results;

    public ElementsCollection results() {
        return results;
    }

    public SelenideElement getResult(int index) {
        return $("#ires .g", index);
    }
}
