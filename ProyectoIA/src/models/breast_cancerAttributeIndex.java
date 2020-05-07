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
public enum breast_cancerAttributeIndex {
    //Atributos del modelo de prediccion de cancer de mama
    age (0),
    Menopause (1),
    Tamaño_Tumor (2),
    inv_nodes (3),
    node_caps (4),
    deg_malig (5),
    breast (6),
    breast_quad (7),
    irradiat (8),
    Class (9);

    private int index;

    breast_cancerAttributeIndex(int index) {
        this.index = index;
    }

    public static breast_cancerAttributeIndex newInstance(int index) {
        for (breast_cancerAttributeIndex breast_cancerAttributeValues : breast_cancerAttributeIndex.values()) {
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
