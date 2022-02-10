**План автоматизации тестирования**

**Перечень автоматизируемых сценариев**

**Оплата картой:**

1. Покупка одобрена:
2. Покупка отклонена:
3. Покупка отклонена:
4. Невалиданое имя при заполнении формы
5. Невалиданый месяц действия карты при заполнении формы
6. Невалиданый год действия карты при заполнении формы
7. Невалиданый CVC при заполнении формы
8. Невалиданый месяц действия карты при заполнении формы
9. "0" значения в поле год действия карты при заполнении формы
10. "0" значения в поле CVC при заполнении формы
11. "0" значения в поле Номеры карты при заполнении формы
12. Пустое значение в поле год действия карты при заполнении формы
13. Пустое значение в поле CVC при заполнении формы
14. Пустое значение в поле Номеры карты при заполнении формы
15. Пустое значение месяц действия карты при заполнении формы
16. Спецсимволы в поле Владелец при заполнении формы

Подробно тесткейсы приведены в "Дать ссылку"

**Оплата в кредит:**

1. Покупка одобрена
2. Покупка отклонена, карта declined 
3. Покупка отклонена, карта не из набора
4. Невалиданое имя при заполнении формы
5. Невалиданый месяц действия карты при заполнении формы
6. Невалиданый год действия карты при заполнении формы
7. Невалиданый CVC при заполнении формы
8. Невалиданый месяц действия карты при заполнении формы
9. "0" значения в поле год действия карты при заполнении формы
10. "0" значения в поле CVC при заполнении формы
11. "0" значения в поле Номеры карты при заполнении формы
12. Пустое значение в поле год действия карты при заполнении формы
13. Пустое значение в поле CVC при заполнении формы
14. Пустое значение в поле Номеры карты при заполнении формы
15. Пустое значение месяц действия карты при заполнении формы
16. Спецсимволы в поле Владелец при заполнении формы

Подробно тесткейсы приведены в "Дать ссылку"

**Перечень используемых инструментов** 
- Docker для развертывания контейнеров БД
- JUnit5 для тестирования в Java
- Selenide для тестирования UI
- Allure для оформления отчетов о тестировании
- Gradle сборщик проектов на Java 
- Faker для генерации данных
- Lombok для упрощения кода
- Idea среда разработки
- Java язык программирования

**Перечень и описание возможных рисков при автоматизации**

-Отсутствие легко находимых локаторов для запросов, таких как id, test_id, увеличивает время написания тестов

-Недостаточная мощность сервера, он может не выдержать дополнительных нагрузок

-Без допусков к базе данных и API сайта невозможно проверить, какие данные уходят на сервер

-Отсутствие квалифицированных специалистов.

**Интервальная оценка с учётом рисков (в часах)**

30 часов для написания автотестов. 

5 часов на дебагинг.

5 часов на отладку стенда.

2 часа на оформление отчетных документов.


**План сдачи работ (когда будут авто-тесты, результаты их прогона и отчёт по автоматизации)**

-Автотесты - 13.02.2022

-Результаты прогона автотестов - 14.02.2022

-Отчет по автоматизации - 14.02.2022