
package springn3;


public class Main {

    public static void main(String[] args) {
        
        Coche c1 = new Coche(new CocheImpOracle());
        
        c1.getInsertarcoche();
        c1.geteliminarcocheById(1);
    }
    
}
