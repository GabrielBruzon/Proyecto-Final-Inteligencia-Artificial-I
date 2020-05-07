/*    ----------------------------------------------------------------------
 *    |                         Proyecto Final                             |
 *    |      Arboles de decision para clasificacion de datos medicos       |
 *    |            Laboratorio Nacional de Informatica Avanzada            |
 *    |                Maestria en Computacion Aplicada                    |
 *    |                   Inteligencia Artificial I                        |
 *    |                   Jose Alfredo Mendoza Mota                        |
 *    ----------------------------------------------------------------------
 */
package proyectoia;


/**
 *
 * @author Alfredo Mota
 */
public class ProyectoIA {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception  {
        Modelo_cancer_mama cancer = new Modelo_cancer_mama();
        Modelo_diabetes diabetes = new Modelo_diabetes();
        
        cancer.crear_modelo();
        diabetes.crear_modelo();
//        String resultado = diabetes.Evaluar_instancia();
//        System.out.println("Resultado de clasificar nueva instancia: " + resultado);
    }
    
}
