package chainofResponsibility;

public class ChainPatternDemo {
	
	   private static AbstractLogger ChainOfLoggers(){

	      AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
	      AbstractLogger fileLogger = new FileLogger(AbstractLogger.DEBUG);
	      AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.INFO);

	      errorLogger.setNextLogger(fileLogger);
	      fileLogger.setNextLogger(consoleLogger);

	      return errorLogger;	
	   }

	   public static void main(String[] args) {
	      AbstractLogger loggerChain = ChainOfLoggers();
	      System.out.println("First Message:");
	      loggerChain.doLogging(AbstractLogger.INFO, 
	         "This is an information.");

	      System.out.println("Second Message:");
	      loggerChain.doLogging(AbstractLogger.DEBUG, 
	         "This is an debug level information.");
	      
	      System.out.println("Third Message:");
	      loggerChain.doLogging(AbstractLogger.ERROR, 
	         "This is an error information.");
	   }
	}