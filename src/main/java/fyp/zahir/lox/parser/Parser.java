package fyp.zahir.lox.parser;

import java.util.List;

import fyp.zahir.lox.error.CanReportErrors;
import fyp.zahir.lox.grammar.Statement;
import fyp.zahir.lox.lexer.Token;

public interface Parser extends CanReportErrors {

    static Parser createDefault(List<Token> tokens) {
        return new RecursiveDescentParser(tokens);
    }

    List<Statement> parse();
}
