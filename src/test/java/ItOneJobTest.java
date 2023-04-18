import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Tag("quick_tests")
public class ItOneJobTest extends TestBase{

    List <String> expectedLocation = List.of("Любой город", "Moscow", "Omsk", "Remote work");

    @Test
    @DisplayName("Открытие страницы поиска вакансий")
    void openItOneVacancyPageTest(){

        step("Открываем страницу поиска вакансий", () -> {
            open("/vacancies/");
        });
        step("Проверяем, что страница открыта успешно", () -> {
        $(".big-heading.big-heading_2.small-intro__heading").shouldHave(text("Вакансии"));
        });
    }

    @Test
    @DisplayName("Проверка списка доступных локаций")
    void checkLocationListTest(){

        step("Открываем страницу поиска вакансий", () -> {
            open("/vacancies/");
        });
        step("Нажимаем на поле выбора локации", () -> {
            $("select[name='location']").click();
        });
        step("Проверяем список доступных локаций с ожидаемым результатом", () -> {
            $$("select[name='location'] .form__select__option").shouldHave(texts(expectedLocation));
        });
    }

    @Test
    @DisplayName("Проверка поиска по фильтру специализации")
    void checkSpecializationFilterTest() {

        step("Открываем страницу поиска вакансий", () -> {
            open("/vacancies/");
        });
        step("Нажимаем на поле выбора специализации", () -> {
            $("select[name='spec']").click();
        });
        step("Выбираем специализацию QA Automation", () -> {
            $("select[name='spec'] option[value='QA Automation']").click();
        });
        step("Нажимаем на кнопку Поиск", () -> {
            $("button[type='submit']").click();
        });
        step("Проверяем результат выдачи на соответствие фильтру", () -> {
            $(".onehire__table__tr").shouldHave(text("QA Automation"));
        });
    }

        @Test
        @DisplayName("Проверка поиска по ключевому слову и нажатию кнопки Enter")
        void checkKeyWordSearchTest(){

            step("Открываем страницу поиска вакансий", () -> {
                open("/vacancies/");
            });
            step("Вводим в поле поиска ключевое слово", () -> {
                $("input[name='keyword']").setValue("Автотестировщик").pressEnter();
            });
            step("Проверка результата поиска по ключевому слову", () -> {
                $(".onehire__table__tr").shouldHave(text("Автотестировщик"));
            });
    }

    @Test
    @DisplayName("Проверка перехода на страницу описания вакансии")
    void goToVacancyPageTest() {

        step("Открываем страницу поиска вакансий", () -> {
            open("/vacancies/");
        });
        step("Вводим в поле поиска ключевое слово", () -> {
            $("input[name='keyword']").setValue("Автотестировщик").pressEnter();
        });
        step("Переходим на страницу с описанием вакансии", () -> {
            $("a[data-sign='Специализация'][href^='/vacancies/']").click();
        });
        step("Проверяем, что находимся на странице с описанием вакансии", () -> {
            $("main").shouldHave(text("Автотестировщик"), text("Описание вакансии"));
        });
    }
}



