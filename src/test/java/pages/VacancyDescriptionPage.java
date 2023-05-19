package pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class VacancyDescriptionPage {

    @Step("Проверка перехода на страницу описания вакансии")
    public VacancyDescriptionPage checkVacancyDescriptionPageIsOpen(String expectedKeyWord, String expectedText){
        $("main").shouldHave(text(expectedKeyWord), text(expectedText));
        return this;
    }
    @Step("Нажать на кнопку Отправить другу")
    public VacancyDescriptionPage clickToSendFriendButton(){
        $(byText("Отправить другу")).click();
        return this;
    }
    @Step("Нажать на кнопку Другие вакансии")
    public VacancyDescriptionPage clickToAllVacanciesButton(){
        $(byText("Другие вакансии")).click();
        return this;
    }
    @Step("Нажать на кнопку Отправить резюме")
    public VacancyDescriptionPage clickToSendResumeButton(){
        $(byText("Отправить резюме")).click();
        return this;
    }
    @Step("Проверить модальное окно с подтверждением копирования ссылки на вакансию")
    public VacancyDescriptionPage checkOpenSubmitModalWindow(String expectedText){
        $(".answer-card__inner").shouldHave(text(expectedText));
        return this;
    }
    @Step("Проверить открытие модального окна для отправки резюме")
    public VacancyDescriptionPage checkOpenWindowSendResume(String expectedText){
        $(".form.resume-form.resume-card__form").shouldHave(text(expectedText));
        return this;
    }
}
