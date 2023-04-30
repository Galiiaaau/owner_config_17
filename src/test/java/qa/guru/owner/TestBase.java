package qa.guru.owner;

import com.codeborne.selenide.WebDriverProvider;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import qa.guru.owner.config.ConfigReader;
import qa.guru.owner.config.ProjectConfig;
import qa.guru.owner.config.WebConfig;

public class TestBase {

    private static final WebConfig config = ConfigReader.Instance.read();
    @BeforeAll
    static void beforeAll() {

        ProjectConfig projectConfiguration = new ProjectConfig(config);
        projectConfiguration.webConfig();

    }


    @BeforeEach
    void addListener () {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void addAttachments () {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}