package fyp.zahir.lox.interpreter;

import java.util.List;

interface LoxCallable {

    int arity();

    Object call(Interpreter interpreter, List<Object> arguments);
}
