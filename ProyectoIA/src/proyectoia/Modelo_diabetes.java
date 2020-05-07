/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoia;

import java.util.Random;
import models.DiabetesAttributeIndex;
import models.DiabetesAttributeValues;
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
public class Modelo_diabetes {
    public static final String CONFIDENT_FACTOR = "-C";
    public static final String CONFIDENT_FACTOR_VALUE = "0.5";
    public static final String MINNUMOBJ = "-M";
    public static final String MINNUMOBJ_VALUE = "2";
    Instances instances;
    J48 tree = new J48();
    
    public Modelo_diabetes() {
        
    }
    public void crear_modelo() throws Exception{
        String finelname = "diabetes.arff";
        ArffLoader loader = new ArffLoader();
        loader.setSource(Modelo_diabetes.class.getClassLoader().getResource("resources/" + finelname));
        instances = loader.getDataSet();
        instances.setClassIndex(instances.numAttributes() - 1);
        System.out.println("----------------------------------diabetes-----------------------------");
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
    public String Evaluar_instancia(int a, int b, int c, int d, int e, double f, double g, int h) throws Exception{
        String resultado= "";
        Instance instance = new DenseInstance(8);
        instance.setDataset(instances);
        instance.setValue(DiabetesAttributeIndex.preg.getIndex(), a);
        instance.setValue(DiabetesAttributeIndex.plas.getIndex(), b);
        instance.setValue(DiabetesAttributeIndex.preassure.getIndex(), c);
        instance.setValue(DiabetesAttributeIndex.skin.getIndex(), d);
        instance.setValue(DiabetesAttributeIndex.insu.getIndex(), e);
        instance.setValue(DiabetesAttributeIndex.IMC.getIndex(), f);
        instance.setValue(DiabetesAttributeIndex.pedi.getIndex(), g);
        instance.setValue(DiabetesAttributeIndex.age.getIndex(), h);

        int result = (int) tree.classifyInstance(instance);

        resultado =  DiabetesAttributeValues.newInstance(result).toString();

        return resultado;
    }
    
}
