
package finalsprintcore;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        
        System.out.println("\nCREACIÓN DE COCHES Y CIRCUITOS\n");
        
        AnnotationConfigApplicationContext contexto = new AnnotationConfigApplicationContext (CircuitoConfig.class);
        
        CreacionCircuito Silverstone = contexto.getBean("Silverstone",CreacionCircuito.class);
        CreacionCircuito Monaco = contexto.getBean("Monaco",CreacionCircuito.class);
        CreacionCircuito Nurburgring = contexto.getBean("Nurburgring",CreacionCircuito.class);
        
        CreacionCoche f1 = contexto.getBean("F1",CreacionCoche.class);
        CreacionCoche audi = contexto.getBean("Audi",CreacionCoche.class);
        CreacionCoche ferrari = contexto.getBean("Ferrari",CreacionCoche.class);
        
        System.out.println("\nF1");
        System.out.println("CV: " + f1.getCV());
        System.out.println("Modelo: " + f1.getMarca());
        System.out.println(f1.getCircuito());
        
        
        System.out.println("\nFerrari");
        System.out.println("CV: " + ferrari.getCV());
        System.out.println("Modelo: " + ferrari.getMarca());
        System.out.println(ferrari.getCircuito());
        
        
        System.out.println("\nAudi");
        System.out.println("CV: " + audi.getCV());
        System.out.println("Modelo: " + audi.getMarca());
        System.out.println(audi.getCircuito());
        
        System.out.println("");
        
        contexto.close();
    }
}
