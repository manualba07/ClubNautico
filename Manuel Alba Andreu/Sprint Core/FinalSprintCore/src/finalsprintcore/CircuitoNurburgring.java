package finalsprintcore;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component("Nurburgring")
@PropertySource("classpath:finalsprintcore/caracteristicasNurburgring.properties")
public class CircuitoNurburgring implements CreacionCircuito {

    @Value("${nurburgring.longitud}")
    private double longitud;

    @Value("${nurburgring.curvas}")
    private int curvas;

    @Value("${nurburgring.pais}")
    private String pais;

    @Override
    public String getCircuito() {
        return "Caracterísitcas del circuito:"
                + " Longitud:" + longitud + "km "
                + " Curvas:" + curvas
                + " País:" + pais;
    }

}
