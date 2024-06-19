package Interface;
import java.util.Random;

public interface GeneradorAlias {
    default String generarAlias(){
        String[] palabras = {
                "Cirujano", "Arena","Pasado","Flores","Basto","Juicio","Tablero","Alfajor","Florero","Mochila",
                "Abrigo","Reina","Remo","Matemática","Olímpico","Escoba","Vestuario","Silo","Fideos","Ropa",
                "Gaseosa","Guiñar","Grueso","Canguro","Jabón","Altura","Gemelo","Felicidad","Funcionario",
                "Amarillo","Alma","Lagarto","Pantalón","Limón","Lava","Mariposa","Dado","Aluminio","Aire",
                "Mesa","Fino","Entero","Lupa","Consulta","Cruz","Canal","Armario","Baul","Diamante", "Brisa","Rocio",
                "Nako","Hacker","Arajo","Baraja","Turno","Marisco","Arado","Espalda","Biceps","Abogado","Brocolí",
                "Zanahoria","Zapallo","Tomate","Lechuga","Carne","Pollo","Gato","Perro","Lobo","Pajaro","Cantar","Hueco",
                "Cucurucho","Ardilla","Horizonte","Internet","Robo","Arrastrar","Oficial","Joya","Anillo","Reloj","Corazón",
                "Anteojos","León","Ardilla","Tiburón","Pescado","Tinta","Belleza","Fibra","Color","Rabino","Alucinar","Marihuana",
                "Maiz","Cogollo","Flota","Auto","Moto","Barco","Puñetazo","Mosca","Pelo","Flecha","Arco","Volante","Puerta","Madera"
        };
        int longitud = 2;
        StringBuilder sb = new StringBuilder();
        Random rand = new Random();
        for (int i = 0; i < longitud; i++){
            sb.append(palabras[rand.nextInt(palabras.length)]);
            if(i < longitud - 1)  sb.append(".");
        }
        return String.valueOf(sb);
    }
}
