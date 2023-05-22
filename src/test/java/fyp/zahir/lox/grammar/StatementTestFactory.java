package fyp.zahir.lox.grammar;

import fyp.zahir.lox.grammar.Expression;
import fyp.zahir.lox.grammar.Statement;
import fyp.zahir.lox.lexer.Token;
import fyp.zahir.lox.lexer.TokenObjectMother;

import static fyp.zahir.lox.lexer.TokenObjectMother.identifier;

import java.util.List;

public class StatementTestFactory {

    private StatementTestFactory() {
    }

    public static Statement.Block blockStatement(Statement... statements) {
        return new Statement.Block(List.of(statements));
    }

    public static Statement.Expression expressionStatement(Expression expression) {
        return new Statement.Expression(expression);
    }

    public static Statement.Function function(String name, List<Token> parameters, List<Statement> body) {
        return new Statement.Function(identifier(name), parameters, body);
    }

    public static Statement.If _if(Expression condition, Statement thenBranch, Statement elseBranch) {
        return new Statement.If(condition, thenBranch, elseBranch);
    }

    public static Statement.Print print(Expression expression) {
        return new Statement.Print(expression);
    }

    public static Statement.Variable variableDeclaration(String name) {
        return new Statement.Variable(identifier(name), null);
    }

    public static Statement.Return _return(Expression value) {
        return new Statement.Return(TokenObjectMother._return(), value);
    }

    public static Statement.Variable variableDeclaration(String name, Expression initializer) {
        return new Statement.Variable(identifier(name), initializer);
    }

    public static Statement.While _while(Expression condition, Statement body) {
        return new Statement.While(condition, body);
    }

    public static Statement.Class _class(String name, List<Statement.Function> methods) {
        return _class(name, null, methods);
    }

    public static Statement.Class _class(String name, Expression.Variable superclass, List<Statement.Function> methods) {
        return new Statement.Class(identifier(name), superclass, methods);
    }
}
