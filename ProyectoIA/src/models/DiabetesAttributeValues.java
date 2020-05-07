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
public enum DiabetesAttributeValues {
    tested_negative (0),
    tested_positive (1);

    private int index;

    DiabetesAttributeValues(int index) {
        this.index = index;
    }

    public static DiabetesAttributeValues newInstance(int index) {
        for (DiabetesAttributeValues DiabetesAttributeValues : DiabetesAttributeValues.values()) {
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
