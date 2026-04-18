package controllers;

import javax.swing.JTable;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import core.Controller;
import models.SchedulerIO;

public class EliminarEventoController extends Controller
{
    private JTable tabla;

    public EliminarEventoController(JTable tabla) {
        this.tabla = tabla;
    }

    @Override
    public void run() {}

    public void seleccionarTodos() {
        for (int i = 0; i < tabla.getRowCount(); i++) {
            tabla.setValueAt(true, i, 5);
        }
    }

    public void eliminarSeleccionados() {

        int confirm = JOptionPane.showConfirmDialog(
                null,
                "¿Eliminar eventos seleccionados?",
                "Confirmar",
                JOptionPane.YES_NO_OPTION
        );

        if (confirm != JOptionPane.YES_OPTION) return;

        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();

        try {
            SchedulerIO io = new SchedulerIO();

            for (int i = tabla.getRowCount() - 1; i >= 0; i--) {
                Boolean sel = (Boolean) tabla.getValueAt(i, 5);

                if (sel != null && sel) {
                    modelo.removeRow(i);
                    io.eliminarEvento(i);
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar");
        }
    }
}