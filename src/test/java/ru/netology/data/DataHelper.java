package ru.netology.data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DataHelper {

    private static Faker faker = new Faker();
    public static Faker fakerrus = new Faker(new Locale("ru"));

    private static String getCardNumber(String card) {
        if (card.equalsIgnoreCase("approved")) {
            return "4444 4444 4444 4441";
        } else if (card.equalsIgnoreCase("declined")) {
            return "4444 4444 4444 4442";
        } else return card;
    }

    private static String generateMonth() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("MM");
        String date = LocalDate.now().plusMonths(3).format(format);
        return date;
    }

/*
    private static String generateFakeMonth() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("MM");
        String FakeDate = LocalDate.now().plusMonths(44).format(format);
        return FakeDate;
    }
*/


    private static String generateYear() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yy");
        String date = LocalDate.now().plusYears(3).format(format);
        return date;
    }
    /*
    private static String generateFakeYear() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yy");
        String FakeYear = LocalDate.now().minusYears(8).format(format);
        return FakeYear;
    }
*/
    private static String generateOwnerName() {
        String ownerName = faker.name().lastName().toUpperCase() + " " + faker.name().firstName().toUpperCase();
        return ownerName;
    }


    private static String generateInvalidOwnerName() {
        String ownerName = fakerrus.name().lastName().toUpperCase() + " " + fakerrus.name().firstName().toUpperCase();
        return ownerName;
    }

    private static String generateCvc() {
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

    public static CardInfo getValidCardInfo(String card) {
        return new CardInfo(getCardNumber(card), generateMonth(), generateYear(), generateOwnerName(), generateCvc());
    }


    public static CardInfo getInvalidNameCardInfo(String card) {
        return new CardInfo(getCardNumber(card), generateMonth(), generateYear(), generateInvalidOwnerName(), generateCvc());
    }

    public static CardInfo getInvalidMonthCardInfo(String card) {
        return new CardInfo(getCardNumber(card), "44", generateYear(), generateOwnerName(), generateCvc());
    }

    public static CardInfo getInvalidYearCardInfo(String card) {
        return new CardInfo(getCardNumber(card), generateMonth(), "15", generateOwnerName(), generateCvc());
    }

    public static CardInfo getInvalidCVCCardInfo(String card) {
        return new CardInfo(getCardNumber(card), generateMonth(), generateYear(), generateOwnerName(), "99");
    }

    public static CardInfo getInvalidMonthZeroCardInfo(String card) {
        return new CardInfo(getCardNumber(card), "00", generateYear(), generateOwnerName(), generateCvc());
    }

    public static CardInfo getInvalidYearZeroCardInfo(String card) {
        return new CardInfo(getCardNumber(card), generateMonth(), "00", generateOwnerName(), generateCvc());
    }

    public static CardInfo getInvalidCVCZeroCardInfo(String card) {
        return new CardInfo(getCardNumber(card), generateMonth(), generateYear(), generateOwnerName(), "00");
    }

    public static CardInfo getInvalidFormatCardInfo(String card) {
        return new CardInfo(getCardNumber(card), generateMonth(), generateYear(), generateOwnerName(), generateCvc());
    }


    public static CardInfo getInvalidYearEmptyCardInfo(String card) {
        return new CardInfo(getCardNumber(card), generateMonth(), " ", generateOwnerName(), generateCvc());
    }

    public static CardInfo getInvalidMonthEmptyCardInfo(String card) {
        return new CardInfo(getCardNumber(card), "  ", generateYear(), generateOwnerName(), generateCvc());
    }

    public static CardInfo getInvalidCVCEmptyCardInfo(String card) {
        return new CardInfo(getCardNumber(card), generateMonth(), generateYear(), generateOwnerName(), "  ");
    }


}
