package views;

import javax.swing.*;
import controllers.RegistrarInvitadoController;
import core.Model;
import core.View;

@SuppressWarnings("serial")
public class RegistrarInvitadoView extends JPanel implements View
{
    //-----------------------------------------------------------------------
    // Attributes
    //-----------------------------------------------------------------------
    private RegistrarInvitadoController controller;

    //-----------------------------------------------------------------------
    // Constructor
    //-----------------------------------------------------------------------
    public RegistrarInvitadoView(RegistrarInvitadoController controller)
    {
        this.controller = controller;

        setLayout(null);

        // Nombre
        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(20, 20, 100, 25);
        add(lblNombre);

        JTextField txtNombre = new JTextField();
        txtNombre.setBounds(120, 20, 150, 25);
        add(txtNombre);

        // Celular
        JLabel lblCelular = new JLabel("Celular:");
        lblCelular.setBounds(20, 60, 100, 25);
        add(lblCelular);

        JTextField txtCelular = new JTextField();
        txtCelular.setBounds(120, 60, 150, 25);
        add(txtCelular);

        // Género
        JLabel lblGenero = new JLabel("Género:");
        lblGenero.setBounds(20, 100, 100, 25);
        add(lblGenero);

        JRadioButton rbM = new JRadioButton("M");
        rbM.setBounds(120, 100, 50, 25);

        JRadioButton rbF = new JRadioButton("F");
        rbF.setBounds(170, 100, 50, 25);

        ButtonGroup grupo = new ButtonGroup();
        grupo.add(rbM);
        grupo.add(rbF);

        add(rbM);
        add(rbF);

        // Dirección
        JLabel lblDireccion = new JLabel("Dirección:");
        lblDireccion.setBounds(20, 140, 100, 25);
        add(lblDireccion);

        JTextField txtDireccion = new JTextField();
        txtDireccion.setBounds(120, 140, 150, 25);
        add(txtDireccion);

        // Términos
        JCheckBox chk = new JCheckBox("Aceptar términos");
        chk.setBounds(120, 180, 180, 25);
        add(chk);

        // Botón
        JButton btn = new JButton("Registrar");
        btn.setBounds(120, 220, 120, 30);
        add(btn);

        // Acción del botón
        btn.addActionListener(e -> {
            String genero = rbM.isSelected() ? "M" : "F";

            controller.registrarInvitado(
                    txtNombre.getText(),
                    txtCelular.getText(),
                    genero,
                    txtDireccion.getText(),
                    chk.isSelected()
            );
        });
    }

    //-----------------------------------------------------------------------
    //Metodo
    //-----------------------------------------------------------------------
    @Override
    public void update(Model model, Object data)
    {
    }
}