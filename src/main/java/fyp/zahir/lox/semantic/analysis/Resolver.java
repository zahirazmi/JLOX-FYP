package fyp.zahir.lox.semantic.analysis;

import java.util.List;

import fyp.zahir.lox.error.CanReportErrors;
import fyp.zahir.lox.grammar.Statement;
import fyp.zahir.lox.interpreter.Interpreter;

public interface Resolver extends CanReportErrors {

    static Resolver createDefault(Interpreter interpreter) {
        return new VariableResolver(interpreter);
    }

    void resolve(List<Statement> statements);
}
