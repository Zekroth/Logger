package logger.models;

import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.stream.Stream;
import java.util.Comparator;

public class Log {
	
	private String message;
	private String caller;
	private int prio;
	private Date timestamp;
	
	public static PrintStream out;
	
	private Log() {
		this.prio = Integer.MIN_VALUE;
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
		//Log.printLog(this);
	}
	public Log(String message, String caller) {
		this.prio = Integer.MIN_VALUE;
		this.timestamp = Calendar.getInstance().getTime();
		this.caller = caller;
		this.message = message;
		
		//Log.printLog(this);
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
	@Override
	public String toString() {
		
		return String.format("%s1\tLOG:\t(%s1)\t\t%s2", new SimpleDateFormat("ss:mm:hh dd-MM-yyyy").format(timestamp), caller ,message);
		
	}

	public static void printLog(Log log) {
		String print = String.format("%s\tLOG:\t%-30.30s\t\t%-10s", new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(log.timestamp), '(' + log.caller + ')' ,log.message);
		if(Log.out == null) {
			System.out.println(print);
		}else {
			Log.out.println(print);
		}
		return;
	}
	public static void printLog(String message, String className) {
		printLog(new Log(message, className));
	}
	public static void printLog(String message) {
		printLog(new Log(message));
	}
	
	public static class CompareByPrio implements Comparator<Log>{

		@Override
		public int compare(Log o1, Log o2) {
			// TODO Auto-generated method stub
			return o1.prio - o2.prio;
		}
		
	}

}
