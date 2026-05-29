
package springn3;

public class CocheImpOracle implements ICoche{

    @Override
    public void Insertarcoche() {
        System.out.println("Insertando coche en oracle");
    }

    @Override
    public void eliminarcoche(int id ) {
        System.out.println("Eliminando coche en oracle");
    }
    
}
