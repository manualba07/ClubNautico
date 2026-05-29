
package com.clubnautico.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import com.clubnautico.clases.*;


public interface PatronRepositorio extends JpaRepository<Patron, Integer> {
    
}
