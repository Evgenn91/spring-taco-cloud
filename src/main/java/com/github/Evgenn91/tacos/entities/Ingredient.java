package com.github.Evgenn91.tacos.entities;

import lombok.Data;

@Data //создает конструктор, геттеры, сеттеры, equals и hashcode
public class Ingredient {
    private final String id;
    private final String name;
    private final Type type;

    public enum Type {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }
}
