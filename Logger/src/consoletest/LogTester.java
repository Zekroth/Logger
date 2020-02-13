package consoletest;

import logger.models.Log;
import logger.core.*;

public class LogTester {

	public static void main(String[] args) {

		LogWrapper lw = new LogWrapper();
		lw.log("First log");
		StackTraceElement[] starr = Thread.currentThread().getStackTrace();
		lw.log("Second Log",starr[starr.length-1].getClassName());
	}

}
