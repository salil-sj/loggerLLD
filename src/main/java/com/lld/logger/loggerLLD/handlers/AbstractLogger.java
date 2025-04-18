    package com.lld.logger.loggerLLD.handlers;

    import com.lld.logger.loggerLLD.constants.LogLevel;
    import com.lld.logger.loggerLLD.observer.LogSubject;
    import com.lld.logger.loggerLLD.observer.Subject;
    import lombok.Getter;
    import lombok.Setter;

    public abstract class AbstractLogger {

        /*
        HANDLER I/F:  CHAIN OF RESPONSIBILITY DESIGN PRINCIPLE
            - ref to next concrete handler
            - method to see, if current handler process req, or delegates it
            - actual core logic, which each working handler will implement

            - Final concrete classes/handlers to make up the functionality

            - Class which will instantiate the chain of handlers
         */
        LogLevel logLevel;  // log level of current handler

        private AbstractLogger nextLogger;

        public AbstractLogger setNextLogger(AbstractLogger nextLogger) {
            this.nextLogger = nextLogger;
            return nextLogger;
        }


        /*
            - decides if this log handler will serve the rew, or will make it go to next handler in the chain
         */
        public void log(int desiredLevel , String message, Subject subject) {
            if(this.logLevel.getLevel() == desiredLevel){
                printLogMessage(message, subject);
            }
            if (this.nextLogger != null) {
                this.nextLogger.log(desiredLevel, message, subject);
            }
        }

        public abstract void printLogMessage(String message, Subject subject);  // method each log concrete handler will implement in its own way


    }
