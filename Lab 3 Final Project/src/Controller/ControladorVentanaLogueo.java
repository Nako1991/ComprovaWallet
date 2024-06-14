package Controller;

import Repositorio.Repositorio;

public class ControladorVentanaLogueo {
    private Repositorio repositorio;

    public ControladorVentanaLogueo(Repositorio repositorio) {
        this.repositorio = repositorio;
    }






    /*public static boolean comprobarLogin(String usuario, String contraseña){
        //comprobar el usuario y que devuelva el usuario, luego la contraseña

        return (comprobarUsuario(usuario) && comprobarContraseña(contraseña));
    }*/

    /*private static boolean comprobarUsuario(String usuarioBuscado){
        boolean comprobado = false;


        for( Usuario usuario : usuarios ) {
            if ( usuario.getUsuario().equals(usuarioBuscado) )
                comprobado = true;
        }
        return comprobado;
    }*/

    /*private static boolean comprobarContraseña(String contraseña){
        return 0;
    }*/
}
