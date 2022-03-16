package ru.netology.page;

import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataHelper;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CreditPage {
    private final SelenideElement heading = $$(".heading").find(exactText("Кредит по данным карты"));
    private final SelenideElement cardNumber = $(".input [placeholder='0000 0000 0000 0000']");
    private final SelenideElement month = $(".input [placeholder='08']");
    private final SelenideElement year = $(".input [placeholder='22']");
    private final SelenideElement fieldCardOwner = $$(".input__top").find(text("Владелец")).parent();
    private final  SelenideElement cardOwner = fieldCardOwner.$(".input__control");
    private final SelenideElement cvc = $(".input [placeholder='999']");
    private final SelenideElement proceedButton = $(".form-field button");
    private final SelenideElement approvedNotification = $(".notification_status_ok");
    private final SelenideElement declinedNotification = $(".notification_status_error");
    private final SelenideElement wrongMonthError = $(withText("Неверно указан срок действия карты"));
    private final SelenideElement wrongYearError = $(withText("Истёк срок действия карты"));
    private final SelenideElement wrongNameError = $(withText("Неверно указано имя владельца карты"));
    private final SelenideElement emptyFieldError = $(withText("Поле обязательно для заполнения"));
    private final SelenideElement wrongCardNumberError = $(withText("Неверный формат"));
    private final SelenideElement wrongCVCError = $(withText("Неверный формат"));

    private SelenideElement request = $(withText("Отправляем запрос"));


    public CreditPage() {
        heading.shouldBe(visible);
    }

    public void credit(DataHelper.CardInfo info) {
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
