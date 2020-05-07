/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Alfredo Mota
 */
public enum DiabetesAttributeIndex {
    //Atributos del modelo de prediccion de cancer de mama
    preg (0),
    plas (1),
    preassure (2),
    skin (3),
    insu (4),
    IMC (5),
    pedi (6),
    age (7),
    Class (8);

    private int index;

    DiabetesAttributeIndex(int index) {
        this.index = index;
    }

    public static DiabetesAttributeIndex newInstance(int index) {
        for (DiabetesAttributeIndex DiabetesAttributeValues : DiabetesAttributeIndex.values()) {
            if (index == DiabetesAttributeValues.index) {
                return DiabetesAttributeValues;
            }
        }
        throw new IllegalArgumentException("Index not found");
    }

    public int getIndex() {
        return index;
    }
}
