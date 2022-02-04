package chainofResponsibility;

public abstract class AbstractLogger {
	   static final int INFO = 1;
	   static final int DEBUG = 2;
	   static final int ERROR = 3;

	   protected int level;

	   
	   protected AbstractLogger nextLogger;

	   public void setNextLogger(AbstractLogger nextLogger){
	      this.nextLogger = nextLogger;
	   }

	   public void doLogging(int level, String message){
	      if(this.level <= level){
	         write(message);
	      }
	      if(nextLogger !=null){
	         nextLogger.doLogging(level, message);
	      }
	   }

	   abstract protected void write(String message);
		
}


