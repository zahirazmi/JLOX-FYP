package fyp.zahir.lox.interpreter;

import java.util.HashMap;
import java.util.Map;

import fyp.zahir.lox.lexer.Token;

class LoxInstance {

    private final LoxClass clazz;
    private final Map<String, Object> fields = new HashMap<>();

    LoxInstance(LoxClass clazz) {
        this.clazz = clazz;
    }

    public Object get(Token name) {
        if (fields.containsKey(name.lexeme())) {
            return fields.get(name.lexeme());
        }

        var method = clazz.findMethod(this, name.lexeme());
        if (method != null) return method;

        throw new RuntimeError(name, "undefined property.");
    }

    public void set(Token name, Object value) {
        fields.put(name.lexeme(), value);
    }

    @Override
    public String toString() {
        return clazz + " instance";
    }
}
