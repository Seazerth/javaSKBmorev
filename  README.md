# Spring Boot + RabbitMQ: Sender и Receiver

**Студент:** Морев Владислав Витальевич  
**Преподаватель:** Никита Карсканов

---

## 📚 Условие задания

Реализовать микросервисное взаимодействие между двумя Spring Boot приложениями с использованием **RabbitMQ**.

---

## 📦 Структура проекта

### ✅ Sender-приложение (`education-0.0.1-SNAPSHOT.jar`)

- Запускается на порту `8080`
- Принимает JSON по POST-запросу и отправляет его в очередь RabbitMQ (`edu.queue`)
- Использует Spring Boot и RabbitTemplate
- Контроллер: `/send`
- Пример запроса:
```json
{
  "from": "Иван",
  "content": "Привет!"
}

✅ Receiver-приложение (1234-0.0.1-SNAPSHOT.jar)

    Слушает очередь edu.queue

    При получении сообщения — выводит его в консоль

    Использует @RabbitListener с автоматической десериализацией из JSON в объект

🔗 Ссылка на GitHub-репозиторий Receiver-а:
👉 https://github.com/Seazerth/1234
⚙️ Используемые технологии

    Java 21

    Spring Boot 3.4.2

    Spring AMQP (RabbitMQ)

    Docker + Docker Compose

    PowerShell / curl / Postman для тестирования

🚀 Запуск приложения
1. Сборка проектов

Перейди в директории проектов sender и receiver, выполни:

mvn clean package

2. Запуск с помощью Docker Compose

docker-compose up --build

Будут запущены:

    sender на порту 8080

    receiver на порту 8081

    homework-handler на 8082 (если нужен)

    rabbitmq на 5672 и UI на 15672

🧪 Тестирование через PowerShell

$headers = @{ "Content-Type" = "application/json" }

$body = @{
    from = "Иван"
    content = "Привет из PowerShell!"
} | ConvertTo-Json -Depth 3

Invoke-RestMethod -Uri "http://localhost:8080/send" -Method POST -Headers $headers -Body $body

✅ Ожидаемый результат

    Sender вернёт: ✅ Сообщение отправлено!

    Receiver выведет в консоль:

📨 Получено сообщение от [Иван]: Привет из PowerShell!