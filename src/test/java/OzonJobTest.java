import io.qameta.allure.Description;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

@Tag("quick_tests")
public class OzonJobTest extends TestBase{

    @Test
    @Description("Открытие страницы поиска вакансий")
    void openOzonVacancyPageTest(){

        step("Открываем страницу поиска вакансий", () -> {
            open("/vacancy");
        });
        step("Проверяем, что страница открыта успешно", () -> {
        $(".finder__title").shouldHave(text("Поиск по вакансиям"));
        });
    }
}



