/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoia;

import java.util.Random;
import models.breast_cancerAttributeIndex;
import models.breast_cancerAttributeValues;
import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.trees.J48;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ArffLoader;

/**
 *
 * @author Alfredo Mota
 */
public class Modelo_cancer_mama {

    public static final String CONFIDENT_FACTOR = "-C";
    public static final String CONFIDENT_FACTOR_VALUE = "0.5";
    public static final String MINNUMOBJ = "-M";
    public static final String MINNUMOBJ_VALUE = "2";
    Instances instances;
    J48 tree = new J48();

    public Modelo_cancer_mama() {

    }

    public void crear_modelo() throws Exception {
        String finelname = "breast-cancer.arff";
        ArffLoader loader = new ArffLoader();
        loader.setSource(Modelo_cancer_mama.class.getClassLoader().getResource("resources/" + finelname));
        instances = loader.getDataSet();
        instances.setClassIndex(instances.numAttributes() - 1);
        System.out.println("----------------------------breast-cancer--------------------------------------");
        System.out.println(instances.numInstances() + " Instancias Cargadas");
//        System.out.println(instances.toString());
        String[] options = new String[]{CONFIDENT_FACTOR, CONFIDENT_FACTOR_VALUE, MINNUMOBJ, MINNUMOBJ_VALUE};
        tree.setOptions(options);
        tree.buildClassifier(instances);
        Classifier treeClassifier = new J48();
        Evaluation treeEvaluation = new Evaluation(instances);
        int numFolds = 5;
        Random random = new Random(1);
        treeEvaluation.crossValidateModel(treeClassifier, instances, numFolds, random);
        System.out.println(treeEvaluation.toSummaryString());

        double[][] confusionMatrix = treeEvaluation.confusionMatrix();
        System.out.println(treeEvaluation.toMatrixString());
    }
    public String Evaluar_instancia(String a, String b, String c, String d, String e, String f, String g, String h,String i) throws Exception{
        String resultado= "";
        Instance instance = new DenseInstance(9);
        instance.setDataset(instances);
        instance.setValue(breast_cancerAttributeIndex.age.getIndex(), a);
        instance.setValue(breast_cancerAttributeIndex.Menopause.getIndex(), b);
        instance.setValue(breast_cancerAttributeIndex.Tamaño_Tumor.getIndex(), c);
        instance.setValue(breast_cancerAttributeIndex.inv_nodes.getIndex(), d);
        instance.setValue(breast_cancerAttributeIndex.node_caps.getIndex(), e);
        instance.setValue(breast_cancerAttributeIndex.deg_malig.getIndex(), f);
        instance.setValue(breast_cancerAttributeIndex.breast.getIndex(), g);
        instance.setValue(breast_cancerAttributeIndex.breast_quad.getIndex(), h);
        instance.setValue(breast_cancerAttributeIndex.irradiat.getIndex(), i);
        int result = (int) tree.classifyInstance(instance);
        resultado = breast_cancerAttributeValues.newInstance(result).toString();
        return resultado;
    }

}
