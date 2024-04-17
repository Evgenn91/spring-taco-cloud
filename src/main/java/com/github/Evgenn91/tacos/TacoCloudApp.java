package com.github.Evgenn91.tacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/** Данная аннотация объединяет 3 аннотации
 * 1. @SpringBootConfiguration – определяет этот класс как класс кон-
 * фигурации. В данный момент в этом классе не определяется
 * никаких конфигурационных параметров, но если понадобится,
 * в него можно добавить настройки Spring Framework. Эта аннота-
 * ция, по сути, является специализированной формой аннотации
 * @Configuration;
 *
 * 2. @EnableAutoConfiguration – включает автоконфигурацию Spring
 * Boot. Подробнее об автоконфигурации мы поговорим позже,
 * а пока просто имейте в виду, что эта аннотация сообщает Spring
 * Boot о необходимости автоматически настраивать любые ком-
 * поненты, которые могут вам понадобиться;
 *
 * 3. @ComponentScan – включает сканирование компонентов. Меха-
 * низм сканирования позволяет объявлять другие классы с анно-
 * тациями, такими как @Component, @Controller и @Service, чтобы
 * фреймворк Spring автоматически обнаруживал и регистрировал
 * их как компоненты в контексте приложения Spring.
 * */
@SpringBootApplication
public class TacoCloudApp {
    public static void main(String[] args) {
        SpringApplication.run(TacoCloudApp.class, args);
    }
}
