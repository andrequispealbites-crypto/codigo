package views;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import controllers.HomeController;
import core.Model;
import core.View;

@SuppressWarnings("serial")
public class HomeView extends JPanel implements View
{
	//-----------------------------------------------------------------------
	// Attributes
	//-----------------------------------------------------------------------
	private HomeController homeController;
	private JFrame mainFrame;

	//-----------------------------------------------------------------------
	// Constructor
	//-----------------------------------------------------------------------
	public HomeView(HomeController homeController, JFrame mainFrame)
	{
		this.homeController = homeController;
		this.mainFrame = mainFrame;

		initFrame();
		initUI();
	}

	//-----------------------------------------------------------------------
	@Override
	public void update(Model model, Object data) {}

	//-----------------------------------------------------------------------
	// Inicializa ventana principal
	private void initFrame()
	{
		mainFrame.setTitle("Sistema de Eventos");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setSize(new Dimension(600, 400));
		mainFrame.setLocationRelativeTo(null); // centrar

		setLayout(new BorderLayout());
		setBorder(new EmptyBorder(10, 10, 10, 10));
	}

	//-----------------------------------------------------------------------
	// Interfaz con pestañas
	private void initUI()
	{
		JTabbedPane tabs = new JTabbedPane();

		//PESTAÑAS
		tabs.addTab("📅 Eventos", homeController.getEventListView());
		tabs.addTab("➕ Nuevo Evento", homeController.getNewEventView());
		tabs.addTab("👤 Registrar Invitado", homeController.getRegistrarInvitadoView());

		add(tabs, BorderLayout.CENTER);
	}
}