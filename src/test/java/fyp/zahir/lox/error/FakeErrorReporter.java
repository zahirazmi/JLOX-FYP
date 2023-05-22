package fyp.zahir.lox.error;

import fyp.zahir.lox.error.Error;
import fyp.zahir.lox.error.ErrorReporter;

public class FakeErrorReporter implements ErrorReporter {

    private Error error;

    public Error getError() {
        return error;
    }

    @Override
    public void handle(Error error) {
        this.error = error;
    }

    @Override
    public boolean receivedError() {
        return error != null;
    }

    @Override
    public void reset() {
        error = null;
    }
}