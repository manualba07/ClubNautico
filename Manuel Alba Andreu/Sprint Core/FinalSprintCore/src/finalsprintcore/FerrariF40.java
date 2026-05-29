
package finalsprintcore;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("Ferrari")
public class FerrariF40 implements CreacionCoche,InitializingBean, DisposableBean {
 
    @Autowired
    @Qualifier("Silverstone")
    private CreacionCircuito circuito;

    @Override
    public String getMarca() {
        return "Ferrari";
    }

    @Override
    public int getCV() {
        return 478;
    }

   
    @Override
    public String getCircuito () {
        return circuito.getCircuito();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Creación coche");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Terminado el coche");
    }
}
