
package finalsprintcore;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("Audi")
public class AudiR4 implements CreacionCoche,InitializingBean, DisposableBean {
    
    @Autowired
    @Qualifier("Nurburgring")
    private CreacionCircuito circuito;

    @Override
    public String getMarca() {
        return "Audi";
    }

    @Override
    public int getCV() {
        return 450;
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
