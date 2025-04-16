ФИО: Морев Владислав Витальевич
Преподаватель: Никита Карсканов

Условие задания

Реализовать Spring Boot приложение с использованием механизма Application Events & Listeners.
Требования:

    Создать три слушателя событий:

        @EventListener — обычный

        @Async + @EventListener — асинхронный

        @TransactionalEventListener — с учётом транзакции

    Для каждого из них — порождать соответствующее событие

    Для @TransactionalEventListener:

        Породить два события

        Обработать одно, другое — пропустить

    Логировать каждый шаг: генерацию и обработку событий

API эндпоинты
Метод	URL	Описание
POST	/events/normal	Генерация и обработка обычного события
POST	/events/async	Генерация и асинхронная обработка события
POST	/events/transactional	Генерация двух событий с транзакционной логикой
Авторизация

    Используется Basic Authentication

    Пользователь: user
    Пароль: password

⚙Пример запросов (PowerShell)

$auth = "user:password"
$encoded = [Convert]::ToBase64String([Text.Encoding]::ASCII.GetBytes($auth))
$headers = @{ Authorization = "Basic $encoded" }

Invoke-WebRequest -Uri "http://localhost:8080/events/normal" -Method POST -Headers $headers
Invoke-WebRequest -Uri "http://localhost:8080/events/async" -Method POST -Headers $headers
Invoke-WebRequest -Uri "http://localhost:8080/events/transactional" -Method POST -Headers $headers

Ожидаемое поведение

    NormalEvent: сразу логируется генерация и обработка

    AsyncEvent: логируется с небольшой задержкой (в фоне)

    TransactionalEvent:

        TRUE — обрабатывается

        FALSE — логируется как пропущенное