package fyp.zahir.lox.interpreter;

import java.util.List;

import fyp.zahir.lox.error.CanReportErrors;
import fyp.zahir.lox.grammar.Expression;
import fyp.zahir.lox.grammar.Statement;
import fyp.zahir.lox.semantic.analysis.ResolutionAnalyzer;

public interface Interpreter extends ResolutionAnalyzer, CanReportErrors {

    static Interpreter createDefault() {
        var globals = Environment.createGlobal();
        globals.defineNativeMethod("clock", new LoxCallable() {

            @Override
            public int arity() {
                return 0;
            }

            @Override
            public Object call(Interpreter interpreter, List<Object> arguments) {
                return (double) System.currentTimeMillis() / 1_000.0;
            }

            @Override
            public String toString() {
                return "<native fn>";
            }
        });

        return new PostOrderTraversalInterpreter(globals);
    }

    Object interpret(Expression expression);

    void interpret(List<Statement> statements);

    void executeBlock(List<Statement> body, Environment environment);
}
