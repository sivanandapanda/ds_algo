package ds.stack;

import java.util.Stack;

public class DijkstraInterpreter {

    private final Stack<String> operationStack;
    private final Stack<Double> valueStack;

    public DijkstraInterpreter() {
        this.operationStack = new Stack<>();
        this.valueStack = new Stack<>();
    }

    public void interpretExpression(String expression) {
        var expressionArray = expression.split(" ");

        for (String s : expressionArray) {
            if(s.equals("(")) {
                //do nothing
            } else if(s.equals("+") || s.equals("*")) {
                this.operationStack.push(s);
            } else if (s.equals(")")) {
                var operation = this.operationStack.pop();

                if(operation.equals("+")) {
                    this.valueStack.push(this.valueStack.pop() + this.valueStack.pop());
                } else if(operation.equals("*")) {
                    this.valueStack.push(this.valueStack.pop() * this.valueStack.pop());
                }
            } else {
                this.valueStack.push(Double.parseDouble(s));
            }
        }
    }

    public Double result () {
        return this.valueStack.pop();
    }
}
