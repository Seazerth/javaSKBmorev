Boot AOP Rate Limiter

Студент: Морев Владислав Витальевич 
Преподаватель: Никита Карсканов

 Условие задания

Реализовать Spring Boot приложение с использованием AOP, которое:

- Считает количество обращений к API методам
- Блокирует дальнейшие вызовы после достижения лимита
- Выбрасывает исключение при превышении лимита



Конфигурация (application.yml)

**yaml**:

rate-limit:
  max-requests: 5

spring:
  security:
    user:
      name: user
      password: password

**API эндпоинты**
Метод	URL	Описание
GET	/hello	Простой приветственный ответ
GET	/status	Возвращает статус сервиса

Пример теста в PowerShell
Проверка доступности:

Invoke-WebRequest -Uri "http://localhost:8080/hello" -Method GET

Проверка лимита (7 вызовов):

$auth = "user:password"
$encoded = [Convert]::ToBase64String([Text.Encoding]::ASCII.GetBytes($auth))
$headers = @{ Authorization = "Basic $encoded" }

1..7 | ForEach-Object {
    Write-Host "Попытка $_"
    try {
        Invoke-WebRequest -Uri "http://localhost:8080/hello" -Method GET -Headers $headers
    } catch {
        Write-Host "Ошибка: $($_.Exception.Message)"
    }
}

Ожидаемое поведение

    С 1 по 5 вызов: возвращается Привет, мир!

    Начиная с 6-го вызова: выбрасывается исключение Превышен лимит вызовов API (статус: 429 Too Many Requests)

