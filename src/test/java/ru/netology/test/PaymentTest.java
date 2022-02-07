package ru.netology.test;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import lombok.val;
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
        val cardInfo = new DataHelper().getValidCardInfo("approved");
        val paymentPage = new OrderPage().goToPayment();
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
        val cardInfo = new DataHelper().getValidCardInfo("declined");
        val paymentPage = new OrderPage().goToPayment();
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
        val cardInfo = new DataHelper().getInvalidFormatCardInfo("4444 4444 4444 4443");
        val paymentPage = new OrderPage().goToPayment();
        paymentPage.payment(cardInfo);
        paymentPage.invalidCardNotification();
    }

    @Epic(value = "Functional Negative test")
    @Feature(value = "Невалидные значения")
    @Story(value = "Невалиданое имя при заполнении формы")
    @Test
// Тест номер 4
    void shouldGetInvalidName() {
        val cardInfo = new DataHelper().getInvalidNameCardInfo("approved");
        val paymentPage = new OrderPage().goToPayment();
        paymentPage.payment(cardInfo);
        paymentPage.invalidCardNotification();
    }

    @Epic(value = "Functional Negative test")
    @Feature(value = "Невалидные значения")
    @Story(value = "Невалиданый месяц действия карты при заполнении формы")
    @Test
// Тест номер 5
    void shouldGetInvalidMonth() {
        val cardInfo = new DataHelper().getInvalidMonthCardInfo("approved");
        val paymentPage = new OrderPage().goToPayment();
        paymentPage.payment(cardInfo);
        paymentPage.invalidCardNotification();
    }

    @Epic(value = "Functional Negative test")
    @Feature(value = "Невалидные значения")
    @Story(value = "Невалиданый год действия карты при заполнении формы")
    @Test
// Тест номер 6
    void shouldGetInvalidYear() {
        val cardInfo = new DataHelper().getInvalidYearCardInfo("approved");
        val paymentPage = new OrderPage().goToPayment();
        paymentPage.payment(cardInfo);
        paymentPage.invalidCardNotification();
    }

    @Epic(value = "Functional Negative test")
    @Feature(value = "Невалидные значения")
    @Story(value = "Невалиданый CVC карты при заполнении формы")
    @Test
// Тест номер 7
    void shouldGetInvalidCVC() {
        val cardInfo = new DataHelper().getInvalidCVCCardInfo("approved");
        val paymentPage = new OrderPage().goToPayment();
        paymentPage.payment(cardInfo);
        paymentPage.wrongFormatNotification();
    }


    @Epic(value = "Functional Negative test")
    @Feature(value = "Невалидные значения")
    @Story(value = "Невалиданый месяц (00) действия карты при заполнении формы")
    @Test
// Тест номер 8
    void shouldGetInvalidMonthZero() {
        val cardInfo = new DataHelper().getInvalidMonthZeroCardInfo("approved");
        val paymentPage = new OrderPage().goToPayment();
        paymentPage.payment(cardInfo);
        paymentPage.wrongFormatNotification();
    }

    @Epic(value = "Functional Negative test")
    @Feature(value = "Невалидные значения")
    @Story(value = "\"0\" значения в поле год действия карты при заполнении формы")
    @Test
// Тест номер 9
    void shouldGetInvalidYearZero() {
        val cardInfo = new DataHelper().getInvalidYearZeroCardInfo("approved");
        val paymentPage = new OrderPage().goToPayment();
        paymentPage.payment(cardInfo);
        paymentPage.wrongFormatNotification();
    }

    @Epic(value = "Functional Negative test")
    @Feature(value = "Невалидные значения")
    @Story(value = "\"0\" значения в поле CVC при заполнении формы")
    @Test
// Тест номер 10
    void shouldGetInvalidCVCZero() {
        val cardInfo = new DataHelper().getInvalidCVCZeroCardInfo("approved");
        val paymentPage = new OrderPage().goToPayment();
        paymentPage.payment(cardInfo);
        paymentPage.wrongFormatNotification();
    }

    @Epic(value = "Functional Negative test")
    @Feature(value = "Невалидные значения")
    @Story(value = "0\" значения в поле Номеры карты при заполнении формы")
    @Test
// Тест номер 11
    void shouldGetNotificationZeroNumberCard() {
        val cardInfo = new DataHelper().getInvalidFormatCardInfo("0000 0000 0000 0000");
        val paymentPage = new OrderPage().goToPayment();
        paymentPage.payment(cardInfo);
        paymentPage.wrongFormatNotification();
    }

    @Epic(value = "Functional Negative test")
    @Feature(value = "Невалидные значения")
    @Story(value = "Пустое значение в поле год действия карты при заполнении формы")
    @Test
// Тест номер 12
    void shouldGetInvalidEmptyYear() {
        val cardInfo = new DataHelper().getInvalidYearEmptyCardInfo("approved");
        val paymentPage = new OrderPage().goToPayment();
        paymentPage.payment(cardInfo);
        paymentPage.emptyFieldNotification();
    }


    @Epic(value = "Functional Negative test")
    @Feature(value = "Невалидные значения")
    @Story(value = "Пустое значение в поле CVC при заполнении формы")
    @Test
// Тест номер 13
    void shouldGetInvalidEmptyCVC() {
        val cardInfo = new DataHelper().getInvalidCVCEmptyCardInfo("approved");
        val paymentPage = new OrderPage().goToPayment();
        paymentPage.payment(cardInfo);
        paymentPage.emptyFieldNotification();
    }

    @Epic(value = "Functional Negative test")
    @Feature(value = "Невалидные значения")
    @Story(value = "Пустое значение в поле Номеры карты при заполнении формы")
    @Test
// Тест номер 14
    void shouldGetNotificationEmptyNumberCard() {
        val cardInfo = new DataHelper().getInvalidFormatCardInfo("    ");
        val paymentPage = new OrderPage().goToPayment();
        paymentPage.payment(cardInfo);
        paymentPage.emptyFieldNotification();
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
        paymentPage.emptyFieldNotification();
    }





/*

    @Test
    void shouldGetNotificationInvalidCard() {
        val cardInfo = new DataHelper().getInvalidCardInfo("approved");
        val paymentPage = new OrderPage().goToPayment();
        paymentPage.payment(cardInfo);
        paymentPage.invalidCardNotification();
    }



    @Test
    void shouldGetNotificationEmptyFields() {
        val paymentPage = new OrderPage().goToPayment();
        paymentPage.emptyFieldNotification();
    }

 */
}
