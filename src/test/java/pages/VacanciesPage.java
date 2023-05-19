package pages;

import io.qameta.allure.Step;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class VacanciesPage {

    @Step("Открыть страницу поиска вакансий")
    public VacanciesPage openVacanciesPage(){
        open("/vacancies/");
        return this;
    }
    @Step("Проверить открытие страницы поиска вакансий")
    public VacanciesPage checkOpenVacanciesPage(){
        $(".big-heading.big-heading_2.small-intro__heading").shouldHave(text("Вакансии"));
        return this;
    }
    @Step("Нажать на поле выбора локации")
    public VacanciesPage clickToSelectLocation(){
        $("select[name='location']").click();
        return this;
    }
    @Step("Сверка списка доступных локаций с ожидаемым списком")
    public VacanciesPage checkLocationsList(List expectedLocations){
        $$("select[name='location'] .form__select__option").shouldHave(texts(expectedLocations));
        return this;
    }
    @Step("Нажимать на поле выбора специализации")
    public VacanciesPage clickToSelectSpecField(){
        $("select[name='spec']").click();
        return this;
    }
    @Step("Выбирть специализацию")
    public VacanciesPage clickToSelectSpec(String spec){
        $(byText(spec)).click();
        return this;
    }
    @Step("Нажать на кнопку Поиск")
    public VacanciesPage clickToSearchButton(){
        $("button[type='submit']").click();
        return this;
    }
    @Step("Проверить результат выдачи на соответствие фильтру")
    public VacanciesPage checkSelectedSpec(String expectedSpec){
        $(".onehire__table__tr").shouldHave(text(expectedSpec));
        return this;
    }
    @Step("Ввести в поле поиска ключевое слово")
    public VacanciesPage setKeyWord(String keyWord){
        $("input[name='keyword']").setValue(keyWord).pressEnter();
        return this;
    }
    @Step("Проверить результата поиска по ключевому слову")
    public VacanciesPage checkExpectedWord(String expectedWord){
        $(".onehire__table__tr").shouldHave(text(expectedWord));
        return this;
    }
    @Step("Кликнуть на ссылку с названием вакансии")
    public VacanciesPage clickToVacancyName(){
        $("a[data-sign='Специализация'][href^='/vacancies/']").click();
        return this;
    }

}
