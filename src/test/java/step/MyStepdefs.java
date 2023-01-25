package step;

import com.codeborne.selenide.*;
import io.cucumber.java.en.*;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class MyStepdefs {
    private final SelenideElement searchField = $x("//input[@id='text']");
    private final SelenideElement searchButton = $x("//button[text()='Найти']");
    private final SelenideElement closeButton = $x("//div[@aria-label='Закрыть']");
    private final SelenideElement orgSite = $x("//li[@class='OrgContacts-Item OrgContacts-Item_type_site']");
    @When("Открываем браузер {string}")
    public void openEdge(String browser){
        Configuration.browser = browser;
    }

    @And("Открываем сайт {string}")
    public void openSite(String url) {
        open(url);
    }

    @And("Вводим в поле поиска {string}")
    public void enterSearchField(String searchStr) {
        if (closeButton.isDisplayed())
            closeButton.click();
        searchField.setValue(searchStr);
    }

    @And("Нажимаем кнопку поиска")
    public void clickSearchButton() {
        searchButton.click();
    }

    @Then("Фиксируем что в поиске отобразится сайт {string}")
    public void fixingSite(String searchedSite) {
        orgSite.shouldHave(text(searchedSite));
    }
}

