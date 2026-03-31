Time Servlet Web Application

###Опис проєкту

Цей проєкт реалізує простий Java веб-застосунок на базі Servlet API та Apache Tomcat, який відображає поточний час.

Основна функціональність:

    відображення часу у форматі UTC 
    підтримка параметра timezone
    валідація введеного часового поясу через фільтр
    обробка HTTP-запитів

Використані технології:

    Java 21
    Servlet API (javax.servlet)
    Apache Tomcat 9
    Maven (WAR packaging)

###Запуск проєкту

1. Клонування репозиторію
   git clone https://github.com/saltykov-neovwrsity/JAVA_WEB_HW1.1_SALTYKOV.git
2. Збірка проєкту
   mvn clean package

Після виконання команди буде створено файл:

target/time-app.war

3. Розгортання в Tomcat

Скопіюйте .war файл у директорію:

apache-tomcat/webapps/

Запустіть Tomcat:

startup.bat

4. Перевірка роботи

Відкрийте у браузері:

    http://localhost:8080/time-app/time

###Функціональність

Отримання часу (UTC)

    /time

Результат:

    2026-03-31 08:16:03 UTC

Використання параметра timezone

    /time?timezone=UTC+2

Результат:

    2026-03-31 10:16:03 UTC+2

###Валідація timezone

Валідація реалізована через TimezoneValidateFilter.

Некоректний запит:

    /time?timezone=ABC

Результат:

    HTTP 400
    Invalid timezone

###Структура проєкту

    src/main/java/org/example/
    ├── TimeServlet.java
    ├── TimezoneValidateFilter.java
    └── TimezoneUtil.java

Логіка роботи
1. TimeServlet — обробляє HTTP-запити та повертає HTML
2. TimezoneValidateFilter — перевіряє коректність параметра timezone
3. TimezoneUtil — містить допоміжні методи для парсингу та нормалізації

Обмеження
1. Підтримуються часові пояси у форматі: UTC±N
2. Допустимий діапазон: UTC-12 до UTC+14
