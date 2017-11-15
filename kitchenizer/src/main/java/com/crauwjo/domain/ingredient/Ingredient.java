package com.crauwjo.domain.ingredient;

import lombok.Value;

import java.util.List;

@Value
public class Ingredient {
    private Integer id;
    private String aisle;
    private String image;
    private String consistency;
    private String name;
    private Integer amount;
    private String unit;
    private String unitShort;
    private String unitLong;
    private String originalString;
    private List<String> metaInformation;
}
