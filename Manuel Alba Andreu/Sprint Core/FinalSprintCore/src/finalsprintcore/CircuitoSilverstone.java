
package finalsprintcore;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component ("Silverstone")
@PropertySource("classpath:finalsprintcore/caracteristicasSilverstone.properties")
public class CircuitoSilverstone implements CreacionCircuito {
    
    @Value("${silverstone.pais}")
    private String pais;
    
    @Value("${silverstone.longitud}")
    private double longitud;
    
    @Value("${silverstone.curvas}")
    private int curvas;
    
    @Override
    public String getCircuito() {
        return "Caracterísitcas del circuito:"
                + " Longitud:" + longitud + "km "
                + " Curvas:" + curvas
                + " País:"+ pais; 
    }
    
}
