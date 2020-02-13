package logger.core;

import java.util.List;
import java.util.stream.Stream;

import logger.models.Log;
import logger.models.Log.CompareByPrio;

public class LogWrapper {
	
	private List<Log> logs;
	
	public Stream<Log> wrap(List<Log> logs){
		
		this.logs = logs;
		logs.sort(new Log.CompareByPrio());
		return logs.stream();
		
	}
	
	public boolean addLog(String message) {
		
		Log log = new Log(message);
		
		return this.logs.add(log);
	}
	
	//GLOBALS
	public static Stream<Log> toStream(List<Log> logs){
		logs.sort(new Log.CompareByPrio());
		return logs.stream();
	}
	
	
	public static void log(String message) {
		Log.printLog(message);
	}

	public static void log(String message, String className) {
		Log.printLog(message,className);
		
	}
}
