package logger.models;

import java.io.PrintStream;
import java.util.Calendar;
import java.util.Date;

public class Log {
	
	private String message;
	private String caller;
	private int prio;
	private Date timestamp;
	
	public static PrintStream out;
	
	private Log() {
		this.prio = Integer.MAX_VALUE;
		this.timestamp = Calendar.getInstance().getTime();
		this.caller = "Unknown";
	}
	private Log(int prio) {
		this.prio = prio;
		this.timestamp = Calendar.getInstance().getTime();
		this.caller = "Unknown";
	}
	public Log(String message) {
		this();
		this.message = message;
		
		Log.out.println(message);
		
	}
	public Log(String message, int prio, Object[] args) {
		//TODO Log with args callable constructor body
	}
	public Log(String message, int prio) {
		this(prio);
		this.message = message;
	}
	
	
	
	public String getMessage() {
		return this.message;
	}
	
	public String getCaller() {
		return this.caller;
	}
	
	public Date getTimeStamp() {
		return this.timestamp;
	}
	
}
