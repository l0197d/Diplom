package ru.netology.data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DataHelper {

    private Faker faker = new Faker();

    private String getCardNumber(String card) {
        if (card.equalsIgnoreCase("approved")) {
            return "4444 4444 4444 4441";
        } else if (card.equalsIgnoreCase("declined")) {
            return "4444 4444 4444 4442";
        } else return card;
    }

    private String generateMonth() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("MM");
        String date = LocalDate.now().plusMonths(3).format(format);
        return date;
    }

    private String generateYear() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yy");
        String date = LocalDate.now().plusYears(3).format(format);
        return date;
    }

    private String generateOwnerName() {
        String ownerName = faker.name().lastName().toUpperCase() + " " + faker.name().firstName().toUpperCase();
        return ownerName;
    }

    private String generateCvc() {
        return Integer.toString(faker.number().numberBetween(100, 999));
    }

    @Value
    public static class CardInfo {
        String cardNumber;
        String month;
        String year;
        String ownerName;
        String cvc;
    }

    // раскидать на новые кейсы
    public CardInfo getValidCardInfo(String card) {
        return new CardInfo(getCardNumber(card), generateMonth(), generateYear(), generateOwnerName(), generateCvc());
    }


    public CardInfo getInvalidNameCardInfo(String card) {
        return new CardInfo(getCardNumber(card), generateMonth(), generateYear(), "Иванов Иван", generateCvc());
    }

    public CardInfo getInvalidMonthCardInfo(String card) {
        return new CardInfo(getCardNumber(card), "13", generateYear(), generateOwnerName(), generateCvc());
    }

    public CardInfo getInvalidYearCardInfo(String card) {
        return new CardInfo(getCardNumber(card), generateMonth(), "32", generateOwnerName(), generateCvc());
    }

    public CardInfo getInvalidCVCCardInfo(String card) {
        return new CardInfo(getCardNumber(card), generateMonth(), generateYear(), generateOwnerName(), "99");
    }

    public CardInfo getInvalidMonthZeroCardInfo(String card) {
        return new CardInfo(getCardNumber(card), "00", generateYear(), generateOwnerName(), generateCvc());
    }

    public CardInfo getInvalidYearZeroCardInfo(String card) {
        return new CardInfo(getCardNumber(card), generateMonth(), "00", generateOwnerName(), generateCvc());
    }

    public CardInfo getInvalidCVCZeroCardInfo(String card) {
        return new CardInfo(getCardNumber(card), generateMonth(), generateYear(), generateOwnerName(), "00");
    }

    public CardInfo getInvalidFormatCardInfo(String card) {
        return new CardInfo(getCardNumber(card), generateMonth(), generateYear(), generateOwnerName(), generateCvc());
    }


    public CardInfo getInvalidYearEmptyCardInfo(String card) {
        return new CardInfo(getCardNumber(card), generateMonth(), " ", generateOwnerName(), generateCvc());
    }

    public CardInfo getInvalidMonthEmptyCardInfo(String card) {
        return new CardInfo(getCardNumber(card), "  ", generateYear(), generateOwnerName(), generateCvc());
    }

    public CardInfo getInvalidCVCEmptyCardInfo(String card) {
        return new CardInfo(getCardNumber(card), generateMonth(), generateYear(), generateOwnerName(), "  ");
    }


}
