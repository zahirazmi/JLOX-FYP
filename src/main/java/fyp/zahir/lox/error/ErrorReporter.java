package fyp.zahir.lox.error;

public interface ErrorReporter {

    static ErrorReporter console() {
        return new ConsoleErrorReporter();
    }

    void handle(Error error);

    boolean receivedError();

    void reset();
}
