## Отчёт о тестировании.

Было проведено тестирование функциональности сервиса для покупки тура по карте или в кредит.    
Были проверены front-end (работа и оформление сайта) и back-end (работа баз данных MySQL и PostgreSQL, корректность получения иобработки данных).
В ходе тестирования было выполнено 30 тест-кейсов, из них только 53% успешных.Остальные 46% тестов были завершены с 
ошибками.

![Screenshot_1](https://user-images.githubusercontent.com/76581010/159235982-e9bd67fd-9f12-4788-9679-e18f8866c6d9.jpg)

**CreditRequestTest**

shouldGetEmptyMonth() 

shouldGetInvalidEmptyYear()

shouldGetInvalidMonthZero()

shouldGetInvalidName()

shouldGetNotificationEmptyNumberCard()

shouldGetNotificationZeroNumberCard()

shouldPaymentDeclinedCard()
![Screenshot_2](https://user-images.githubusercontent.com/76581010/159235993-5274c2dd-d23e-4c88-8e8b-0aff1b26b11a.jpg)


**PaymentTest**

shouldGetEmptyMonth()

shouldGetInvalidEmptyYear()

shouldGetInvalidMonthZero()

shouldGetInvalidName()

shouldGetNotificationEmptyNumberCard()

shouldGetNotificationZeroNumberCard()

shouldPaymentDeclinedCard()
![Screenshot_3](https://user-images.githubusercontent.com/76581010/159236009-e970a3b5-ea16-4bbf-8387-aba4d8e6766b.jpg)



#### Общие рекомендации
В ходе проведения тестирования были выявлены недочеты в работе сайта. Для улучшения работы сайта можно внести следующие правки:

1.Исправить код приложения - запрет операций картой со статусом DECLINED

2.Исправить код приложения - отражение операции покупки в кредит, как операции покупки в кредит

3.Исправить код приложения - заполнения поля Владелец только на латинице

4.Исправить текст сообщения об ошибке "Неверный формат" на "Поле обязательно для заполнения" если не заполнены поля Месяц, Номер карты, Год, CVC/CVV

5.Исправить код приложения - если не заполнено только поле CVC/CVV, не показывать ошибку в поле Владелец

6.Исправить опечатку в названии города и заголовке страницы

7.Исправить код приложения - ввести маскировку поля CVC/CVV

