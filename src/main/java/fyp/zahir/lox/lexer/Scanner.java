package fyp.zahir.lox.lexer;

import java.util.List;

import fyp.zahir.lox.error.CanReportErrors;

public interface Scanner extends CanReportErrors {

    static Scanner createDefault(String sourceCode) {
        return new SimpleScanner(sourceCode);
    }

    List<Token> scanTokens();
}
