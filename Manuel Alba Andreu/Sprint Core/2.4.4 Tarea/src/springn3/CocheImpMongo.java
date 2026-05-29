
package springn3;


public class CocheImpMongo implements ICoche {
    
     @Override
    public void Insertarcoche() {
        System.out.println("Insertando coche en Mongo");
    }

    @Override
    public void eliminarcoche(int id ) {
        System.out.println("Eliminando coche en Mongo");
    }
}
