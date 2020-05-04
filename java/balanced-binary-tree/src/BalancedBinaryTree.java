class BinaryTreeNode {

    public int value;
    public int depth;
    public BinaryTreeNode left;
    public BinaryTreeNode right;

    public BinaryTreeNode(int value) {
        this.value = value;
        this.depth = 1;
    }

    public void insert( int value ){

        if( this.value > value ){ // Left

            if( this.left == null ) insertLeft(value);
                else this.left.insert(value);

        } else if( this.value < value ){ // Right

            if( this.right == null ) insertRight(value);
                else this.right.insert(value);

        }
    }

    public BinaryTreeNode insertLeft(int leftValue) {

        this.left = new BinaryTreeNode(leftValue);
        this.left.depth = this.depth+1;
        return this.left;

    }

    public BinaryTreeNode insertRight(int rightValue) {

        this.right = new BinaryTreeNode(rightValue);
        this.right.depth = this.depth+1;
        return this.right;

    }

    public int getMaxDepth() {

        int maxDepth = 0;

        if( this.left != null)
            maxDepth = Math.max(maxDepth, this.left.getMaxDepth());

        maxDepth = Math.max( maxDepth, this.depth );

        if (this.right != null )
            maxDepth = Math.max( maxDepth, this.right.getMaxDepth() );

        return maxDepth;
    };

    public int getMinDepth() {

        if (this == null) return 0;

        if( this.left == null && this.right == null )
            return 1;

        if( this.left == null) {
            return this.right.getMinDepth()+1;
        }

        if (this.right != null ) {
            return this.left.getMinDepth()+1;
        }

        return Math.min( this.left.getMinDepth(), right.getMinDepth());
    };

    public boolean isSuperbalanced() {

        int maxDepth = getMaxDepth();
        int minDepth = getMinDepth();

        return maxDepth - minDepth > 1 ? false : true;

    }

    @Override
    public String toString() {

        String output = "";

        if( this.left != null )
            output = output + this.left.toString();

        output = output + String.valueOf(value) + ",";

        if( this.right != null )
            output = output + this.right.toString();

        return output;
    };

}


