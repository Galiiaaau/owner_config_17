package qa.guru.owner;


import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import qa.guru.owner.config.WebConfig;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class MovieFoneTests extends TestBase{

    private static final WebConfig webConfig = ConfigFactory.create(WebConfig.class, System.getProperties());
    @Test
    @Tag("remote")
    @DisplayName("Check the website is open")
    void MovieSearch() {

        step("Open movie website", () -> {
            open(webConfig.baseUrl());
        });

        step("Search a specific text", () -> {
            $("[data-type='showtimes']").shouldHave(exactText("Showtimes & Tickets"));
        });
}
}