package com.github.Evgenn91.tacos.controllers;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/* Это специальная тестовая аннотация из Spring
    Boot, которая организует запуск теста в контексте приложения Spring
    MVC. В данном случае она обеспечивает регистрацию класса Home-
    Controlle
    @WebMvcTest также настраивает поддержку тестирования Spring
    MVC в Spring. Для тестирования можно было бы запустить сервер, но
    для наших целей вполне достаточно имитировать механику Spring
    MVC. В тестовый класс внедряется объект MockMvc, чтобы тест мог
    управлять фиктивным объектом.*/
@WebMvcTest(HomeController.class) //Тест для HomeController
public class HomeControllerTest {
    @Autowired
    private MockMvc mockMvc; //Внедрить MockMvc

    @Test
    public void testHomePage() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/")) //Выполнить запрос GET /
                .andExpect(MockMvcResultMatchers.status().isOk()) //Ожидается код ответа HTTP 200
                .andExpect(MockMvcResultMatchers.view().name("home")) //Ожидается имя представления home
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("Welcome to..."))); //Ожидается наличие строки «Welcome to...»
    }
}
