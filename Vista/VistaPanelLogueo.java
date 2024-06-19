package Vista;
import Controlador.ControladorLogueoUsuarios;
import Exceptions.InvalidUserDoesntExists;
import Exceptions.InvalidWrongPasswordFormat;
import Exceptions.InvalidWrongUserFormat;
import Modelo.Usuario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class VistaPanelLogueo {

    public static Usuario ingresarUsuario(String usuario, String contraseña,ControladorLogueoUsuarios controladorLogueoUsuarios) {

        Usuario usuarioLogueado = null;
        try {
            usuarioLogueado = controladorLogueoUsuarios.loguearUsuario(usuario, contraseña);

            if(usuarioLogueado != null) {

            }
        }
        catch(InvalidWrongUserFormat | InvalidWrongPasswordFormat | InvalidUserDoesntExists exception) {
            System.out.println("Error: " + exception.getMessage());
        }
        return usuarioLogueado;
    }


    private void botonLogueoActionPerformed(ActionEvent evt) {
//        String nombreUsuario = this.campoUsuario.getText();
//        char[] caracteresContraseña = this.campoContraseña.getPassword();
//        String contraseñaUsuario = new String(caracteresContraseña);
//        usuarioLogueado = VistaPanelLogueo.ingresarUsuario(nombreUsuario, contraseñaUsuario, controladorLogueoUsuarios);

        //ESTO ES LO QUE ESTAMOS ANALIZANDO
//        if(usuarioLogueado != null) {
//            cartelUsuarioLogueo.setVisible(true);
//            System.out.println(usuarioLogueado.toString());
//            Timer temporizador = new Timer(2000, new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    panelLateralLogueo.setVisible(false);
//                    panelLateralBilleteras.setVisible(true);
//                }
//            });
//            temporizador.setRepeats(false);
//            temporizador.start();
//        }
//        else {
//            cartelUsuarioInvalido.setVisible(true);
//        }
//
//    }



}
