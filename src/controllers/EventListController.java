package controllers;

import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import core.Controller;
import models.SchedulerIO;
import views.EventListView;

public class EventListController extends Controller
{
	private EventListView view;
	private JTable table;
	private HomeController mainController;

	@Override
	public void run()
	{
		table = new JTable(getDataColumns(), getNameColumns()) {
			@Override
			public Class<?> getColumnClass(int column) {
				if (column == 5) return Boolean.class;
				return String.class;
			}
		};

		view = new EventListView(this, table);
	}

	public void addNewRow(Object[] values)
	{
		((DefaultTableModel) table.getModel()).addRow(values);
	}

	public EventListView getView() { return view; }
	public JTable getTable() { return table; }

	//GET/SET MAIN CONTROLLER
	public void setMainController(HomeController mainController) {
		this.mainController = mainController;
	}

	public HomeController getMainController() {
		return mainController;
	}

	public Vector<String> getNameColumns()
	{
		Vector<String> cols = new Vector<>();
		cols.add("Fecha");
		cols.add("Descripción");
		cols.add("Frecuencia");
		cols.add("Email");
		cols.add("Alarma");
		cols.add("Seleccionar");
		return cols;
	}

	public Vector<Vector<Object>> getDataColumns()
	{
		Vector<Vector<Object>> data = new Vector<>();

		try {
			SchedulerIO io = new SchedulerIO();
			data = io.getEvents();

			for (Vector<Object> fila : data) {
				fila.add(false);
			}

		} catch (Exception ex) {}

		return data;
	}
}