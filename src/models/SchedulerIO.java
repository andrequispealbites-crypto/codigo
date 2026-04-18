package models;

import java.io.*;
import java.util.*;

import core.Model;
import core.View;

public class SchedulerIO implements Model
{
	private static final String DIRECTORY = ".";
	private static final String FILE = "events.txt";

	private List<View> views = new ArrayList<>();
	private String notice;

	@Override
	public void attach(View view) { views.add(view); }

	@Override
	public void detach(View view) { views.remove(view); }

	@Override
	public void notifyViews() {
		for (View v : views) {
			v.update(this, notice);
		}
	}

	public void saveEvent(SchedulerEvent event) throws Exception
	{
		BufferedWriter writer = new BufferedWriter(
				new FileWriter(new File(DIRECTORY, FILE), true)
		);
		writer.write(event.toString());
		writer.newLine();
		writer.close();
	}

	public Vector<Vector<Object>> getEvents() throws Exception
	{
		Vector<Vector<Object>> response = new Vector<>();

		BufferedReader reader = new BufferedReader(
				new FileReader(new File(DIRECTORY, FILE))
		);

		String line;

		while ((line = reader.readLine()) != null) {
			Vector<Object> row = new Vector<>();
			String[] tokens = line.split(";");

			row.add(tokens[0]);
			row.add(tokens[1]);
			row.add(tokens[2]);
			row.add(tokens[3]);
			row.add(tokens[4].equals("1") ? "ON" : "OFF");

			response.add(row);
		}

		reader.close();
		return response;
	}

	public void eliminarEvento(int index) throws Exception
	{
		List<String> lines = new ArrayList<>();

		BufferedReader reader = new BufferedReader(
				new FileReader(new File(DIRECTORY, FILE))
		);

		String line;
		while ((line = reader.readLine()) != null) {
			lines.add(line);
		}
		reader.close();

		if (index >= 0 && index < lines.size()) {
			lines.remove(index);
		}

		BufferedWriter writer = new BufferedWriter(
				new FileWriter(new File(DIRECTORY, FILE))
		);

		for (String l : lines) {
			writer.write(l);
			writer.newLine();
		}

		writer.close();
	}
}