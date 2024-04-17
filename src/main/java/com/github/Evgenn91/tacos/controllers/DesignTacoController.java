package com.github.Evgenn91.tacos.controllers;

import com.github.Evgenn91.tacos.entities.Ingredient;
import com.github.Evgenn91.tacos.entities.Taco;
import com.github.Evgenn91.tacos.entities.TacoOrder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j //автоматически генерирует статическое свойство типа Logger (private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(DesignTacoController.class);
@Controller
@RequestMapping("/design") //определяет тип запросов, которые обрабатывает этот контроллер
/* SessionAttributes указывает, что объект TacoOrder,
    объявленный в классе чуть ниже, должен поддерживаться на уровне
    сеанса. Это важно, потому что создание тако также является первым
    шагом в создании заказа, и созданный нами заказ необходимо будет
    перенести в сеанс, охватывающий несколько запросов.*/
@SessionAttributes("tacoOrder")
public class DesignTacoController {
    @ModelAttribute //ингредиенты добавляются в модель и эта модель будет добавлени в методе showDesignForm
    public void addIngredientsToModel(Model model) {
        List<Ingredient> ingredients = Arrays.asList(
                new Ingredient("FLTO", "Flour Tortilla", Ingredient.Type.WRAP),
                new Ingredient("COTO", "Corn Tortilla", Ingredient.Type.WRAP),
                new Ingredient("GRBF", "Ground Beef", Ingredient.Type.PROTEIN),
                new Ingredient("CARN", "Carnitas", Ingredient.Type.PROTEIN),
                new Ingredient("TMTO", "Diced Tomatoes", Ingredient.Type.VEGGIES),
                new Ingredient("LETC", "Lettuce", Ingredient.Type.VEGGIES),
                new Ingredient("CHED", "Cheddar", Ingredient.Type.CHEESE),
                new Ingredient("JACK", "Monterrey Jack", Ingredient.Type.CHEESE),
                new Ingredient("SLSA", "Salsa", Ingredient.Type.SAUCE),
                new Ingredient("SRCR", "Sour Cream", Ingredient.Type.SAUCE)
        );
        Ingredient.Type[] types = Ingredient.Type.values();
        for (Ingredient.Type type : types) {
            model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type));
        }
    }
    /*Объект TacoOrder, упомянутый выше в аннотации @SessionAttributes,
        хранит состояние собираемого заказа, пока клиент выби-
        рает ингредиенты для тако несколькими запросами. Объект Taco по-
        мещается в модель, чтобы представление, отображаемое в ответ на
        запрос GET с путем /design, имело объект для отображения.*/
    @ModelAttribute(name = "tacoOrder")//создается объект для размещения в модели
    public TacoOrder order() {
        return new TacoOrder();
    }
    @ModelAttribute(name = "taco")//создается объект для размещения в модели
    public Taco taco() {
        return new Taco();
    }
    @GetMapping//@GetMapping в сочетании с @RequestMapping на уровне класса опреляет метод, который вызыв для обработки http get запроса
    public String showDesignForm() {
        return "design";
    }

    @PostMapping
    public String processTaco(Taco taco, @ModelAttribute TacoOrder tacoOrder) {
        tacoOrder.addTaco(taco);
        log.info("Processing taco: {}", taco);
        return "redirect:/orders/current";
    }
    private Iterable<Ingredient> filterByType(
            List<Ingredient> ingredients, Ingredient.Type type) {
        return ingredients
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }
}
