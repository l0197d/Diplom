package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataHelper;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class PaymentPage {
    private SelenideElement heading = $$(".heading").find(exactText("Оплата по карте"));
    private SelenideElement cardNumber = $(".input [placeholder='0000 0000 0000 0000']");
    private SelenideElement month = $(".input [placeholder='08']");
    private SelenideElement year = $(".input [placeholder='22']");
    private SelenideElement fieldCardOwner = $$(".input__top").find(text("Владелец")).parent();
    private SelenideElement cardOwner = fieldCardOwner.$(".input__control");
    private SelenideElement cvc = $(".input [placeholder='999']");
    private SelenideElement proceedButton = $(".form-field button");
    private SelenideElement approvedNotification = $(".notification_status_ok");
    private SelenideElement declinedNotification = $(".notification_status_error");
    private SelenideElement wrongMonthError = $(withText("Неверно указан срок действия карты"));
    private SelenideElement wrongYearError = $(withText("Истёк срок действия карты"));
    private SelenideElement wrongNameError = $(withText("Неверно указано имя владельца карты"));
    private SelenideElement emptyFieldError = $(withText("Поле обязательно для заполнения"));
    private SelenideElement wrongCardNumberError = $(withText("Неверный формат"));
    private SelenideElement wrongCVCError = $(withText("Неверный формат"));

    private SelenideElement request = $(withText("Отправляем запрос"));


    public PaymentPage() {
        heading.shouldBe(visible);
    }

    public void payment(DataHelper.CardInfo info) {
        cardNumber.setValue(info.getCardNumber());
        month.setValue(info.getMonth());
        year.setValue(info.getYear());
        cardOwner.setValue(info.getOwnerName());
        cvc.setValue(info.getCvc());
        proceedButton.click();
    }

    public void approved() {
        approvedNotification.shouldBe(visible, Duration.ofSeconds(15));
    }

    public void declined() {
        declinedNotification.shouldBe(visible, Duration.ofSeconds(15));
    }


    public void wrongMonth() {
        request.shouldNotBe(visible, Duration.ofSeconds(4));
        wrongMonthError.shouldBe(visible, Duration.ofSeconds(3));
    }

    public void wrongYear() {
        request.shouldNotBe(visible, Duration.ofSeconds(4));
        wrongYearError.shouldBe(visible, Duration.ofSeconds(3));
    }

    public void wrongName() {
        request.shouldNotBe(visible, Duration.ofSeconds(4));
        wrongNameError.shouldBe(visible, Duration.ofSeconds(3));
    }

    public void wrongCVC() {
        request.shouldNotBe(visible, Duration.ofSeconds(4));
        wrongCVCError.shouldBe(visible, Duration.ofSeconds(3));
    }

    public void wrongNumberCard() {
        request.shouldNotBe(visible, Duration.ofSeconds(4));
        wrongCardNumberError.shouldBe(visible, Duration.ofSeconds(3));
    }


    public void emptyField() {
        request.shouldNotBe(visible, Duration.ofSeconds(4));
        emptyFieldError.shouldBe(visible, Duration.ofSeconds(3));
    }


}
