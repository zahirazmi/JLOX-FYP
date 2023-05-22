package fyp.zahir.lox.semantic.analysis;

import fyp.zahir.lox.grammar.Expression;

public interface ResolutionAnalyzer {

    void resolve(Expression expression, int depth);

}
