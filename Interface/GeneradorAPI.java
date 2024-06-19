package Interface;

import java.util.Random;

public interface GeneradorAPI {
    default String generarAPI(){
        int longitud = 15;
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < longitud; i++) sb.append(caracteres.charAt(random.nextInt(caracteres.length())));
        String api = String.valueOf(sb);
        return api;
    }
}
