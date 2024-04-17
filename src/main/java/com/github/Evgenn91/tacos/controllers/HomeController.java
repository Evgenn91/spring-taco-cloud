package com.github.Evgenn91.tacos.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller /* такую же функцию выполняют аннотации: @Component, @Service и @Repository */
public class HomeController {
    @GetMapping("/")
    public String home() {
        return "home"; /* Имя шаблона состоит из имени логического представления, к ко-
                        торому добавляются префикс пути /templates/ и расширение .html.
                           В результате полный путь к шаблону будет иметь вид: /templates/home.html */
    }
}
