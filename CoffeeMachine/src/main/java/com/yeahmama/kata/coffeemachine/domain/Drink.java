package com.yeahmama.kata.coffeemachine.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Drink {
    CHOCOLATE("Hh", 0.5),
    COFFEE("Ch", 0.6),
    ORANGE("O", 0.6),
    TEA("Th", 0.4);

    private String code;
    private double price;
}
