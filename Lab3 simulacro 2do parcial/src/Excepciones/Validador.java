package Excepciones;

import Interfaces.ControladorDeContenedores;
import Modelo.ContenidoAV;

import java.util.HashMap;
import java.util.HashSet;

public class Validador {
    public static void validarID(String id, HashMap< String, HashSet<ContenidoAV>> repositorio) throws IdEnUsoException {
        for ( HashSet<ContenidoAV> contenidos : repositorio.values() )
            for ( ContenidoAV contenido : contenidos )
                if( contenido.getId().equals(id) )
                    throw new IdEnUsoException("El contenido ya se encuentra en la biblioteca.");
    }
}
