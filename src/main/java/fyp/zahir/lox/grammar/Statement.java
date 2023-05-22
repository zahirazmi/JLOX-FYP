package fyp.zahir.lox.grammar;

import java.util.List;

import fyp.zahir.lox.lexer.Token;

public sealed interface Statement {

    <R> R accept(Visitor<R> visitor);

    interface Visitor<R> {

        R visitBlockStatement(Block statement);

        R visitClassStatement(Class statement);

        R visitExpressionStatement(Expression statement);

        R visitFunctionStatement(Function statement);

        R visitIfStatement(If statement);

        R visitPrintStatement(Print statement);

        R visitReturnStatement(Return statement);

        R visitVariableStatement(Variable statement);

        R visitWhileStatement(While statement);
    }

    record Block(List<Statement> statements) implements Statement {

        public <R> R accept(Visitor<R> visitor) {
            return visitor.visitBlockStatement(this);
        }
    }

    record Class(Token name, fyp.zahir.lox.grammar.Expression.Variable superclass,
                 List<Statement.Function> methods) implements Statement {

        public <R> R accept(Visitor<R> visitor) {
            return visitor.visitClassStatement(this);
        }
    }

    record Expression(fyp.zahir.lox.grammar.Expression expression) implements Statement {

        public <R> R accept(Visitor<R> visitor) {
            return visitor.visitExpressionStatement(this);
        }
    }

    record Function(Token name, List<Token> parameters, List<Statement> body) implements Statement {

        public <R> R accept(Visitor<R> visitor) {
            return visitor.visitFunctionStatement(this);
        }
    }

    record If(fyp.zahir.lox.grammar.Expression condition, Statement thenBranch,
              Statement elseBranch) implements Statement {

        public <R> R accept(Visitor<R> visitor) {
            return visitor.visitIfStatement(this);
        }
    }

    record Print(fyp.zahir.lox.grammar.Expression expression) implements Statement {

        public <R> R accept(Visitor<R> visitor) {
            return visitor.visitPrintStatement(this);
        }
    }

    record Return(Token keyword, fyp.zahir.lox.grammar.Expression value) implements Statement {

        public <R> R accept(Visitor<R> visitor) {
            return visitor.visitReturnStatement(this);
        }
    }

    record Variable(Token name, fyp.zahir.lox.grammar.Expression initializer) implements Statement {

        public <R> R accept(Visitor<R> visitor) {
            return visitor.visitVariableStatement(this);
        }
    }

    record While(fyp.zahir.lox.grammar.Expression condition, Statement body) implements Statement {

        public <R> R accept(Visitor<R> visitor) {
            return visitor.visitWhileStatement(this);
        }
    }
}
