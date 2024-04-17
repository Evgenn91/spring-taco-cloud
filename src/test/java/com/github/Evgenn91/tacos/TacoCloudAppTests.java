package com.github.Evgenn91.tacos;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/* Аннотация @SpringBootTest настраивает JUnit на запуск теста с под-
    держкой возможностей Spring Boot. Подобно @SpringBootApplication,
    @SpringBootTest – это составная аннотация, которая сама снабжена
    аннотацией @ExtendWith(SpringExtension.class), добавляющей под-
    держку возможностей тестирования Spring в JUnit 5. */
@SpringBootTest
public class TacoCloudAppTests {
    /* этот тестовый класс
        выполняет важную проверку – успешность загрузки контекста
        приложения Spring.*/
    @Test
    public void contextLoads() {
    }
}
