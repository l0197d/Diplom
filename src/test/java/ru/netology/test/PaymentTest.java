package ru.netology.test;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import ru.netology.data.DataHelper;
import ru.netology.data.DbHelper;
import ru.netology.page.OrderPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class PaymentTest {

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    void setUp() {
        open("http://localhost:8080/");
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    @Epic(value = "Functional Positive test")
    @Feature(value = "Валидные значения")
    @Story(value = "Тест проверяет Happy Path")
    @Test
        // Тест номер 1

    void shouldPaymentApprovedCard() {
        var cardInfo = new DataHelper().getValidCardInfo("approved");
        var paymentPage = new OrderPage().goToPayment();
        paymentPage.payment(cardInfo);
        paymentPage.approved();
        assertEquals("APPROVED", new DbHelper().getPaymentStatus());
        assertEquals(4500000, new DbHelper().getPaymentAmount());
        assertNull(new DbHelper().getCreditId());
    }

    @Epic(value = "Functional Negative test")
    @Feature(value = "Невалидные значения")
    @Story(value = "Покупка отклонена, карта Decline")
    @Test
// Тест номер 2
    void shouldPaymentDeclinedCard() {
        var cardInfo = new DataHelper().getValidCardInfo("declined");
        var paymentPage = new OrderPage().goToPayment();
        paymentPage.payment(cardInfo);
        paymentPage.declined();
        assertEquals("DECLINED", new DbHelper().getPaymentStatus());
        assertNull(new DbHelper().getCreditId());
    }

    @Epic(value = "Functional Negative test")
    @Feature(value = "Невалидные значения")
    @Story(value = "Покупка отклонена, карта не из набора")
    @Test
// Тест номер 3
    void shouldGetNotificationWrongNumberCard() {
        var cardInfo = new DataHelper().getInvalidFormatCardInfo("4444 4444 4444 4443");
        var paymentPage = new OrderPage().goToPayment();
        paymentPage.payment(cardInfo);
        paymentPage.declined();
    }

    @Epic(value = "Functional Negative test")
    @Feature(value = "Невалидные значения")
    @Story(value = "Невалиданое имя при заполнении формы")
    @Test
// Тест номер 4
    void shouldGetInvalidName() {
        var cardInfo = new DataHelper().getInvalidNameCardInfo("approved");
        var paymentPage = new OrderPage().goToPayment();
        paymentPage.payment(cardInfo);
        paymentPage.wrongName();
    }

    @Epic(value = "Functional Negative test")
    @Feature(value = "Невалидные значения")
    @Story(value = "Невалиданый месяц действия карты при заполнении формы")
    @Test
// Тест номер 5
    void shouldGetInvalidMonth() {
        var cardInfo = new DataHelper().getInvalidMonthCardInfo("approved");
        var paymentPage = new OrderPage().goToPayment();
        paymentPage.payment(cardInfo);
        paymentPage.wrongMonth();
    }

    @Epic(value = "Functional Negative test")
    @Feature(value = "Невалидные значения")
    @Story(value = "Невалиданый год действия карты при заполнении формы")
    @Test
// Тест номер 6
    void shouldGetInvalidYear() {
        var cardInfo = new DataHelper().getInvalidYearCardInfo("approved");
        var paymentPage = new OrderPage().goToPayment();
        paymentPage.payment(cardInfo);
        paymentPage.wrongYear();
    }


    @Epic(value = "Functional Negative test")
    @Feature(value = "Невалидные значения")
    @Story(value = "Невалиданый CVC карты при заполнении формы")
    @Test
// Тест номер 7
    void shouldGetInvalidCVC() {
        var cardInfo = new DataHelper().getInvalidCVCCardInfo("approved");
        var paymentPage = new OrderPage().goToPayment();
        paymentPage.payment(cardInfo);
        paymentPage.wrongCVC();
    }


    @Epic(value = "Functional Negative test")
    @Feature(value = "Невалидные значения")
    @Story(value = "Невалиданый месяц (00) действия карты при заполнении формы")
    @Test
// Тест номер 8
    void shouldGetInvalidMonthZero() {
        var cardInfo = new DataHelper().getInvalidMonthZeroCardInfo("approved");
        var paymentPage = new OrderPage().goToPayment();
        paymentPage.payment(cardInfo);
        paymentPage.wrongMonth();
    }

    @Epic(value = "Functional Negative test")
    @Feature(value = "Невалидные значения")
    @Story(value = "\"0\" значения в поле год действия карты при заполнении формы")
    @Test
// Тест номер 9
    void shouldGetInvalidYearZero() {
        var cardInfo = new DataHelper().getInvalidYearZeroCardInfo("approved");
        var paymentPage = new OrderPage().goToPayment();
        paymentPage.payment(cardInfo);
        paymentPage.wrongYear();
    }

    @Epic(value = "Functional Negative test")
    @Feature(value = "Невалидные значения")
    @Story(value = "\"0\" значения в поле CVC при заполнении формы")
    @Test
// Тест номер 10
    void shouldGetInvalidCVCZero() {
        var cardInfo = new DataHelper().getInvalidCVCZeroCardInfo("approved");
        var paymentPage = new OrderPage().goToPayment();
        paymentPage.payment(cardInfo);
        paymentPage.wrongCVC();
    }

    @Epic(value = "Functional Negative test")
    @Feature(value = "Невалидные значения")
    @Story(value = "0\" значения в поле Номеры карты при заполнении формы")
    @Test
// Тест номер 11
    void shouldGetNotificationZeroNumberCard() {
        var cardInfo = new DataHelper().getInvalidFormatCardInfo("0000 0000 0000 0000");
        var paymentPage = new OrderPage().goToPayment();
        paymentPage.payment(cardInfo);
        paymentPage.wrongNumberCard();
    }

    @Epic(value = "Functional Negative test")
    @Feature(value = "Невалидные значения")
    @Story(value = "Пустое значение в поле год действия карты при заполнении формы")
    @Test
// Тест номер 12
    void shouldGetInvalidEmptyYear() {
        var cardInfo = new DataHelper().getInvalidYearEmptyCardInfo("approved");
        var paymentPage = new OrderPage().goToPayment();
        paymentPage.payment(cardInfo);
        paymentPage.emptyField();
    }


    @Epic(value = "Functional Negative test")
    @Feature(value = "Невалидные значения")
    @Story(value = "Пустое значение в поле CVC при заполнении формы")
    @Test
// Тест номер 13
    void shouldGetInvalidEmptyCVC() {
        var cardInfo = new DataHelper().getInvalidCVCEmptyCardInfo("approved");
        var paymentPage = new OrderPage().goToPayment();
        paymentPage.payment(cardInfo);
        paymentPage.emptyField();
    }

    @Epic(value = "Functional Negative test")
    @Feature(value = "Невалидные значения")
    @Story(value = "Пустое значение в поле Номеры карты при заполнении формы")
    @Test
// Тест номер 14
    void shouldGetNotificationEmptyNumberCard() {
        var cardInfo = new DataHelper().getInvalidFormatCardInfo("    ");
        var paymentPage = new OrderPage().goToPayment();
        paymentPage.payment(cardInfo);
        paymentPage.emptyField();
    }


    @Epic(value = "Functional Negative test")
    @Feature(value = "Невалидные значения")
    @Story(value = "Пустое значение месяц действия карты при заполнении формы")
    @Test
// Тест номер 15
    void shouldGetEmptyMonth() {
        var cardInfo = new DataHelper().getInvalidMonthEmptyCardInfo("approved");
        var paymentPage = new OrderPage().goToPayment();
        paymentPage.payment(cardInfo);
        paymentPage.emptyField();
    }


}
