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
public enum breast_cancerAttributeValues {
    no_recurrence_events (0),
    recurrence_events (1);

    private int index;

    breast_cancerAttributeValues(int index) {
        this.index = index;
    }

    public static breast_cancerAttributeValues newInstance(int index) {
        for (breast_cancerAttributeValues breast_cancerAttributeValues : breast_cancerAttributeValues.values()) {
            if (index == breast_cancerAttributeValues.index) {
                return breast_cancerAttributeValues;
            }
        }
        throw new IllegalArgumentException("Index not found");
    }

    public int getIndex() {
        return index;
    }
}
