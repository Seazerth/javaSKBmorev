# 📊 Домашнее задание: Обслуживание и метрики в Spring Boot

**ФИО:** Морев Владислав Витальевич  
**Преподаватель:** Никита Карсканов

---

## ✅ Условие задания

Разработать Spring Boot приложение, которое реализует мониторинг и метрики, используя `Micrometer` и `Spring Boot Actuator`.

---

## 📌 Функциональность

### 🔢 Метрики

1. **Количество HTTP-запросов**
    - Используется фильтр `RequestMetricsFilter`, фиксирующий обращения к каждому эндпоинту.
    - Метрика: `http.server.requests.custom` с тэгом `uri`.

2. **Время выполнения запроса**
    - Измеряется через `Timer` внутри фильтра `RequestMetricsFilter`.
    - Метрика сохраняется в `MeterRegistry`.

3. **Собственная метрика количества покупок шоколадок**
    - Класс `CandyMetrics` регистрирует счётчики (`Counter`) по типу шоколада (`KitKat`, `Snickers`, `Twix` и др.)
    - Метрика: `choco.purchases` с тэгом `type`.

### 🛠 Актуатор

- Создан кастомный актуатор `CustomLogEndpoint`
- Эндпоинт: `/actuator/customlog`
- При вызове в консоль выводится сообщение с текущими датой и временем
- Возвращает JSON с `status` и `timestamp`

---

## 🔗 API эндпоинты

| Метод | URL               | Описание                         |
|-------|-------------------|----------------------------------|
| POST  | `/choco/buy`      | Покупка шоколадки по типу и кол-ву |
| GET   | `/actuator/customlog` | Вызов пользовательского актуатора  |

**Пример запроса:**
```
POST http://localhost:8080/choco/buy?type=Snickers&amount=3
```

---

## Авторизация

Basic Auth (если настроена):
- Пользователь: `user`
- Пароль: `password`

---

## Пример метрик (через Prometheus):

```
# HELP choco_purchases_total Count of chocolate purchases
# TYPE choco_purchases_total counter
choco_purchases_total{type="Snickers",} 3.0

# HELP http_server_requests_custom_seconds Timer for HTTP requests
# TYPE http_server_requests_custom_seconds summary
```

---

## Структура

- `controller/ChocoController.java` — REST контроллер
- `service/ChocoService.java` — бизнес-логика
- `metrics/CandyMetrics.java` — пользовательские метрики
- `metrics/RequestMetricsFilter.java` — таймер запросов
- `actuator/CustomLogEndpoint.java` — кастомный актуатор

---

## Конфигурация

```yaml
management:
  endpoints:
    web:
      exposure:
        include: "*"
  endpoint:
    customlog:
      enabled: true

logging:
  level:
    root: INFO
```

---

**Ожидаемое поведение:**
- При покупке — обновляются счётчики и логируется покупка
- При любом запросе — логируется длительность
- При вызове актуатора — сообщение в консоль и JSON с временем
