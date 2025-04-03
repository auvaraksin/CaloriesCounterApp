Приложение CaloriesCounterAppApplication является демонстрационным с целью 
показать возможности и способы применения JAVA17 и инструментов из состава
SpringBoot (в том числе Spring Web Services, Spring Data JPA, PostgreSQL Driver, Lombok)
для реализации REST API сервиса с использованием базы данных PostgerSQL при решении задач
учета пользователей сервисом, автоматического расчета суточной нормы калорий пользователя по
формулере Харриса-Бенедикта на основании внесенных данных, а также автоматизированного 
формирования отчетов для каждого пользователя о суточном потреблении продуктов и истории
ежедневного потребления.
Для использования приложения необходимо использовать базу данных PostgreSQL.
Обзор схемы сервиса REST API возможно после запуска приложения с использованием инструментов
Swagger UI (по ссылке http://localhost:8080/swagger-ui/index.html).

Перед запуском приложения необходимо проверить настройки соединения приложения с базой данных
в файле application.properties.
По умолчанию используются следующие настройки
spring.datasource.url = jdbc:postgresql://localhost:5432/testdb
spring.datasource.username = testdb
spring.datasource.password = admin
spring.jpa.hibernate.ddl-auto=create-drop

Для быстрого заполнения базы данных тестовыми данными и тестирования ответа от 
сервиса REST API необходимо испоотзовать коллекцию запросов Postman
CaloriesAppTest.postman_collection.json (см. CaloriesCounterApp\).

ВНИМАНИЕ! При разработке приложения не применялась методология оптимизации работы REST API
и базы данных в части использования DTO и их мэппинг.
ВНИМАНИЕ! При разработке приложения не предусмотрена обработка возможных исключений и проверка
качества вводимых данных, за исключением проверки возраста, массы и роста (при несоответствии
установленным ограничениям применяются значения по умолчанию).
