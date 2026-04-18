package models;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SchedulerEvent
{
	private String eventDesc;
	private String fwdEmail;
	private Date date;
	private Frequency frequency;
	private boolean alarm;

	@Override
	public String toString()
	{
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");

		return sdf.format(this.date) + ";" + eventDesc +
				";" + frequency + ";" + fwdEmail + ";" +
				(alarm ? "1" : "0");
	}

	public String getEventDesc() { return eventDesc; }
	public void setEventDesc(String eventDesc) { this.eventDesc = eventDesc; }

	public String getFwdEmail() { return fwdEmail; }
	public void setFwdEmail(String fwdEmail) { this.fwdEmail = fwdEmail; }

	public Date getDate() { return date; }
	public void setDate(Date date) { this.date = date; }

	public Frequency getFrequency() { return frequency; }
	public void setFrequency(Frequency frequency) { this.frequency = frequency; }

	public boolean getAlarm() { return alarm; }
	public void setAlarm(boolean alarm) { this.alarm = alarm; }
}