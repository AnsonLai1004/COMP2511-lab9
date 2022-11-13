package unsw.calculator.model;

import unsw.calculator.model.tree.TreeNode;

/**
 * This class is just here to help you test things out with printing, etc.
 */
public class Main {
    public static void main(String[] args)  {
        Parser aparser = new Parser("1 + 2 - 3 * 10 / 5"); // spaces are vital!!
	    TreeNode anode = aparser.parse();
        Visitor infixVisitor = new InFixPrintVisitor();
        anode.accept(infixVisitor);
    }
}