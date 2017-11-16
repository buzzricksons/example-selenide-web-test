package com.example.page;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.$$;

public class GoogleResultsPage {
    @FindBy(how = How.CSS, using = "#ires li.g")
    public ElementsCollection results;

    public ElementsCollection results() {
        return results;
    }
}
