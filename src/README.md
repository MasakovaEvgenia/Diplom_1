# Unit Tests for Stellar Burgers

## Описание проекта

Этот проект включает в себя автоматизированные тесты для веб-приложения [Stellar Burgers](https://stellarburgers.nomoreparties.site/). В рамках проекта проводятся юнит-тесты для следующих классов:
- `Bun`
- `Burger`
- `Ingredient`
- `IngredientType`

## Репозиторий

Вы можете клонировать репозиторий с тестами по следующему URL:
[https://github.com/yandex-praktikum/QA-java-diplom-1](https://github.com/yandex-praktikum/QA-java-diplom-1)

## Технологии

В проекте используются следующие технологии:

| Технология | Версия |
|------------|--------|
| Java       | 11     |
| JUnit4     | 4.13.2 |
| Mockito    | 4.11.0 |
| JaCoCo     | 0.8.8  |

## Как сформировать отчет JaCoCo

1. Откройте терминал в вашей IDE (например, IntelliJ IDEA) и выполните команду:
   ```sh
   mvn verify
2. После завершения сборки, перейдите в папку target/site/jacoco/.
Найдите файл index.html, нажмите на него правой кнопкой мыши и выберите "Open In — Browser" для открытия в вашем браузере.