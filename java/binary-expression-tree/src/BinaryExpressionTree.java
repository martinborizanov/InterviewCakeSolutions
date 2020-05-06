public class BinaryExpressionTree {

    private class Node {

        public char contents;
        public Node left;
        public Node right;

        public boolean isLeaf(){
            return (left==null && right==null);
        }
    }

    public Node root;

    public Node buildExpressionTree(String expression ){

        Node focusNode = new Node();
        if(root == null ) root = focusNode;

        if( expression.length() == 1 ){
            focusNode.contents = expression.charAt(0);
            return focusNode;
        };

        char nextOperator = '\0';
        int  nextOperatorPosition = -1;

        // Model precedence, in reverse order
        String charsToCheck = expression.contains("+") || expression.contains("-") ? "+-" : "/*";

        // Finds the rightmost operator
        for( int idx = 0; idx < expression.length(); idx ++ ) {

            char thisChar = expression.charAt(idx);

            if (charsToCheck.indexOf(thisChar) != -1) {
                nextOperator = thisChar;
                nextOperatorPosition = idx;
            }
        }

        focusNode.contents = nextOperator;

        String leftSide = expression.substring( 0, nextOperatorPosition );
        String rightSide = expression.substring( nextOperatorPosition + 1 );

        focusNode.left  = buildExpressionTree( leftSide );
        focusNode.right = buildExpressionTree( rightSide );

        return focusNode;
    }

    public static void printTree( Node node ){

        if( node.left != null ) {
            System.out.print("(");
            printTree(node.left);
        }

        System.out.printf("%s",node.contents);

        if( node.right != null ){
            printTree(node.right);
            System.out.print(")");
        }

        return;
    }

    public static void main(String[] args) {

        String expression = "1*2/3+4/5*6+7-8*9";

        BinaryExpressionTree binaryExpressionTree = new BinaryExpressionTree();
        binaryExpressionTree.buildExpressionTree(expression);

        Node root = binaryExpressionTree.root;

        printTree(root);

    }
}
