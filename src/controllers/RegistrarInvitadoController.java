package controllers;

import core.Controller;
import views.RegistrarInvitadoView;

import javax.swing.JOptionPane;

public class RegistrarInvitadoController extends Controller
{
    private RegistrarInvitadoView vista;

    @Override
    public void run() {
        vista = new RegistrarInvitadoView(this);
    }

    public void registrarInvitado(String nombre, String celular, String genero,
                                  String direccion, boolean acepta) {

        if (nombre.isEmpty() || celular.isEmpty() || direccion.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Complete todos los campos");
            return;
        }

        if (!acepta) {
            JOptionPane.showMessageDialog(null, "Debe aceptar términos");
            return;
        }

        JOptionPane.showMessageDialog(null, "Invitado registrado");
    }

    public RegistrarInvitadoView getVista() {
        return vista;
    }
}