package controllers;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import core.Controller;

public class BuscarEventoController extends Controller
{
    private JTable tabla;

    public BuscarEventoController(JTable tabla) {
        this.tabla = tabla;
    }

    @Override
    public void run() {}

    public void buscar(String texto) {
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(modelo);
        tabla.setRowSorter(sorter);

        sorter.setRowFilter(javax.swing.RowFilter.regexFilter(texto));
    }
}