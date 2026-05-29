
package finalsprintcore;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component ("Monaco")
@PropertySource("classpath:finalsprintcore/caracteristicasMonaco.properties")
public class CircuitoMónaco implements CreacionCircuito {

    @Value("${monaco.pais}")
    private String pais;
    
    @Value("${monaco.longitud}")
    private double longitud;
    
    @Value("${monaco.curvas}")
    private int curvas;
    
    @Override
    public String getCircuito() {
        return "Caracterísitcas del circuito:"
                + " Longitud:" + longitud + "km "
                + " Curvas:" + curvas
                + " País:"+ pais; 
    }
    
}
