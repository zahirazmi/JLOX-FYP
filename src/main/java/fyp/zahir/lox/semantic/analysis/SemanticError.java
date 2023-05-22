package fyp.zahir.lox.semantic.analysis;

import fyp.zahir.lox.error.Error;
import fyp.zahir.lox.lexer.Token;

record SemanticError(Token token, String message) implements Error {

    @Override
    public String toString() {
        return String.format("[line %d] SemanticError: at '%s' %s", token.line(), token.lexeme(), message);
    }
}
