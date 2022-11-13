package unsw.calculator.model;

import unsw.calculator.model.tree.BinaryOperatorNode;
import unsw.calculator.model.tree.NumericNode;

public class EvaluatorVisitor implements Visitor{
    private int result;

    @Override
    public int visitBinaryOperatorNode(BinaryOperatorNode node) {
        int left = node.acceptLeft(this);
        int right = node.acceptRight(this);
        result = node.compute(left, right);
        return result;
    }

    @Override
    public int visitNumericNode(NumericNode node) {
        return node.getValue();
    }

    public int getValue() {
        return result;
    }

    
}