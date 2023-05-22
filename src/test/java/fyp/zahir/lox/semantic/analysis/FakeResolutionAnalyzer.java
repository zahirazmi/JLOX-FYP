package fyp.zahir.lox.semantic.analysis;

import java.util.HashMap;
import java.util.Map;

import fyp.zahir.lox.grammar.Expression;
import fyp.zahir.lox.semantic.analysis.ResolutionAnalyzer;

class FakeResolutionAnalyzer implements ResolutionAnalyzer {

    final Map<Expression, Integer> depthPerExpression = new HashMap<>();

    @Override
    public void resolve(Expression expression, int depth) {
        depthPerExpression.put(expression, depth);
    }
}
