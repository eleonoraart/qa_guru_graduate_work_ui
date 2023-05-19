package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.VacanciesPage;
import pages.VacancyDescriptionPage;

import java.util.List;

@Tag("quick_tests")
public class ItOneJobTest extends TestBase {

    VacanciesPage vacanciesPage = new VacanciesPage();
    VacancyDescriptionPage vacancyDescriptionPage = new VacancyDescriptionPage();
    List <String> expectedLocations = List.of("Любой город", "Moscow", "Omsk", "Remote work");

    @Test
    @DisplayName("Открытие страницы поиска вакансий")
    void openItOneVacancyPageTest(){

        vacanciesPage
                .openVacanciesPage()
                .checkOpenVacanciesPage();

    }

    @Test
    @DisplayName("Проверка списка доступных локаций")
    void checkLocationListTest(){

        vacanciesPage
                .openVacanciesPage()
                .checkOpenVacanciesPage()
                .clickToSelectLocation()
                .checkLocationsList(expectedLocations);

    }

    @Test
    @DisplayName("Проверка поиска по фильтру специализации")
    void checkSpecializationFilterTest() {

        vacanciesPage
                .openVacanciesPage()
                .clickToSelectSpecField()
                .clickToSelectSpec("QA Automation")
                .clickToSearchButton()
                .checkSelectedSpec("QA Automation");

    }

    @Test
        @DisplayName("Проверка поиска по ключевому слову и нажатию кнопки Enter")
        void checkKeyWordSearchTest(){

        vacanciesPage
                .openVacanciesPage()
                .setKeyWord("Автотестировщик")
                .checkExpectedWord("Автотестировщик");

    }

    @Test
    @DisplayName("Проверка перехода на страницу описания вакансии")
    void goToVacancyPageTest() {

        vacanciesPage
                .openVacanciesPage()
                .setKeyWord("Автотестировщик")
                .clickToVacancyName();
        vacancyDescriptionPage
                .checkVacancyDescriptionPageIsOpen("Автотестировщик", "Описание вакансии");

    }
    @Test
    @DisplayName("Проверка копирования ссылки вакансии для отправки другу")
    void copyLinkVacancyForFriendTest() {

        vacanciesPage
                .openVacanciesPage()
                .setKeyWord("Автотестировщик")
                .clickToVacancyName();
        vacancyDescriptionPage
                .clickToSendFriendButton()
                .checkOpenSubmitModalWindow("Ссылка на страницу с описанием вакансии скопирована в буфер обмена");

    }
    @Test
    @DisplayName("Проверка перехода на страницу Вакансий со страницы со страницы с описанием Вакансии")
    void goToVacanciesFromVacancyDescriptionPageTest() {

        vacanciesPage
                .openVacanciesPage()
                .setKeyWord("Тестировщик")
                .clickToVacancyName();
        vacancyDescriptionPage
                .clickToAllVacanciesButton();
        vacanciesPage
                .checkOpenVacanciesPage();

    }
    @Test
    @DisplayName("Проверка перехода к отправке резюме на странице с описанием Вакансии")
    void goToSendResumeWindowTest() {

        vacanciesPage
                .openVacanciesPage()
                .setKeyWord("Тестировщик")
                .clickToVacancyName();
        vacancyDescriptionPage
                .clickToSendResumeButton()
                .checkOpenWindowSendResume("Отправка резюме");

    }
}



