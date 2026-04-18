package controllers;

import core.Controller;
import views.*;

public class HomeController extends Controller
{
	private HomeView homeView;

	private EventListController eventListController = new EventListController();
	private NewEventController newEventController = new NewEventController(eventListController); // 🔥 AGREGADO
	private RegistrarInvitadoController invitadoController = new RegistrarInvitadoController();

	private EliminarEventoController eliminarController;
	private BuscarEventoController buscarController;

	@Override
	public void run()
	{
		eventListController.run();
		newEventController.run(); //AGREGADO
		invitadoController.run();

		//CONEXIÓN CLAVE
		eventListController.setMainController(this);

		eliminarController = new EliminarEventoController(
				eventListController.getTable()
		);

		buscarController = new BuscarEventoController(
				eventListController.getTable()
		);

		homeView = new HomeView(this, mainFrame);
		addView("HomeView", homeView);

		mainFrame.setVisible(true);
	}

	public EventListView getEventListView() {
		return eventListController.getView();
	}

	// Metodo
	public NewEventView getNewEventView() {
		return newEventController.getView();
	}

	public RegistrarInvitadoView getRegistrarInvitadoView() {
		return invitadoController.getVista();
	}

	public EliminarEventoController getEliminarEventoController() {
		return eliminarController;
	}

	public BuscarEventoController getBuscarEventoController() {
		return buscarController;
	}
}