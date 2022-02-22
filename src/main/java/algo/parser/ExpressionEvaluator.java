package algo.parser;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class ExpressionEvaluator {

    public double evaluateExpression(String expression) {
        try {
            ScriptEngineManager mgr = new ScriptEngineManager();
            ScriptEngine engine = mgr.getEngineByName("JavaScript");
            Object eval = engine.eval(expression);

            if(eval instanceof Double) {
                return (double) eval;
            } else if (eval instanceof Integer) {
                return (int) eval;
            } else {
                throw new IllegalArgumentException("Invalid expression " + expression);
            }
        } catch (ScriptException e) {
            throw new IllegalArgumentException("Invalid expression " + expression);
        }
    }
}