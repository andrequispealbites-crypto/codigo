package views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.*;
import javax.swing.table.JTableHeader;

import controllers.EventListController;
import core.Model;
import core.View;

@SuppressWarnings("serial")
public class EventListView extends JPanel implements View
{
	private EventListController controller;
	private JTable tabla;

	public EventListView(EventListController controller, JTable tabla)
	{
		this.controller = controller;
		this.tabla = tabla;

		setLayout(new BorderLayout());

		makeTopPanel();
		makeTable();
		makeBottomPanel();
	}

	private void makeTopPanel()
	{
		JPanel panelTop = new JPanel(new FlowLayout(FlowLayout.LEFT));

		JLabel lblBuscar = new JLabel("Buscar:");
		JTextField txtBuscar = new JTextField(20);

		panelTop.add(lblBuscar);
		panelTop.add(txtBuscar);

		//BUSCAR EN TIEMPO REAL
		txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent evt) {
				controller.getMainController()
						.getBuscarEventoController()
						.buscar(txtBuscar.getText());
			}
		});

		add(panelTop, BorderLayout.NORTH);
	}

	private void makeTable()
	{
		JScrollPane scroll = new JScrollPane(tabla);

		JTableHeader header = tabla.getTableHeader();
		header.setReorderingAllowed(false);

		add(scroll, BorderLayout.CENTER);
	}

	private void makeBottomPanel()
	{
		JPanel panelBottom = new JPanel(new FlowLayout(FlowLayout.RIGHT));

		JButton btnSeleccionar = new JButton("Seleccionar todos");
		JButton btnEliminar = new JButton("Eliminar");

		panelBottom.add(btnSeleccionar);
		panelBottom.add(btnEliminar);

		btnSeleccionar.addActionListener(e ->
				controller.getMainController()
						.getEliminarEventoController()
						.seleccionarTodos()
		);

		btnEliminar.addActionListener(e ->
				controller.getMainController()
						.getEliminarEventoController()
						.eliminarSeleccionados()
		);

		add(panelBottom, BorderLayout.SOUTH);
	}

	@Override
	public void update(Model model, Object data) {}
}