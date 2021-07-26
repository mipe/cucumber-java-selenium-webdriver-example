package com.automatedtest.sample.searchresultpage;

import java.util.List;
import java.util.stream.IntStream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automatedtest.sample.basepage.BasePage;

public class SearchResultPage extends BasePage {

    private static final String RESULTS_TITLE_SELECTOR = "h2 a";

    @FindBy(css = RESULTS_TITLE_SELECTOR)
    private List<WebElement> results;

    SearchResultPage() {
        PageFactory.initElements(driver, this);
    }

    boolean isInResults(String expectedTitle, int nbOfResultsToSearch) {
        wait.forPresenceOfElements(5, By.cssSelector(RESULTS_TITLE_SELECTOR), "Result title");
        return IntStream.range(0, Math.min(this.results.size(), nbOfResultsToSearch))
                .anyMatch(index -> this.results.get(index).getText().contains(expectedTitle));
    }
}

