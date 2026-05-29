
package springn3;

public class Coche {
    
    ICoche coch;

    public Coche( ICoche coch) {   
        this.coch = coch;
    }    
    
    public void getInsertarcoche(){
        coch.Insertarcoche();
    }
    
    public void geteliminarcocheById(int id){
        coch.eliminarcoche(id);
    }
}
