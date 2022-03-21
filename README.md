### 


# Diplom

Дипломный проект представляет собой автоматизацию тестирования комплексного сервиса, взаимодействующего с СУБД и API Банка.

## Начало работы

1. Запустить Idea.
2. В терминале Idea указать команду "clone https://github.com/l0197d/Diplom.git".
3. Дождаться окончания закрузки и индексации файлов.
4. Выполнить шаги описанные в разделе "Установка и запуск."

### Prerequisites
Для работы с проектом установить:
1. IntelliJ IDEA
2. Docker Desktop
3. Расширения для IntelliJ IDEA:
- Docker
- DataBaseTool and Sql
- Node.js



### Установка и запуск

Для запуска тестов необходимо:
1. Запустить контейнеры командой 'docker-compose up -d'
2. Запустить приложение командой 'java -jar ./artifacts/aqa-shop.jar' (по умолчанию приложение работает с базой MySQl. 
Для работы с базой PostgreSQL запустить приложение командой 'java "-Dspring.datasource.url=jdbc:postgresql://localhost:5432/app" -jar artifacts/aqa-shop.jar
   '.
3. Запустить автотесты командой ./gradlew clean test "-Ddb.url=jdbc:mysql://localhost:3306/app" . 
Для работы с базой PostgreSQL запустить автотесты командой './gradlew clean test 
   -Ddb=jdbc:postgresql://localhost:5432/app   '.
4. Для создания отчета Allure запустить команду './gradlew allureReport' и './gradlew allureServe'.


## Лицензия

ОС: Windows 10 х64.
версия Java: 11.0.9.1

## [Раздел с документацией](https://github.com/l0197d/Diplom/tree/master/docs)
## [Отчет по тестированию](https://github.com/l0197d/Diplom/tree/master/docs/Report.md)
## [Отчет по итогам автоматизации](https://github.com/l0197d/Diplom/tree/master/docs/Summary.md)
