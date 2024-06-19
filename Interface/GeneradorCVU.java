package Interface;
import Exceptions.Validaciones;
import Modelo.Usuario;
import java.util.HashMap;
import java.util.Random;

public interface GeneradorCVU {

     static String generarCVU(HashMap<String, Usuario> repositorio) {

        String digitos = "0123456789";
        int longuitudCVU = 22;
        StringBuilder cvuBuffer = new StringBuilder();
        Random random = new Random();
        String cvuValido = "";
        boolean resultadoValidacion;

        do {
            try {
                for(int i = 0; i < longuitudCVU; i++) {
                    cvuBuffer.append(digitos.charAt(random.nextInt(digitos.length())));
                }
                cvuValido = String.valueOf(cvuBuffer);
                Validaciones.invalidCVUAlreadyExists(cvuValido, repositorio);
                resultadoValidacion = true;
            }
            catch(Exception exception) {
                System.out.println("\nError: " + exception.getMessage());
                resultadoValidacion = false;
            }
        }while(!resultadoValidacion);

        return cvuValido;
    }
}
