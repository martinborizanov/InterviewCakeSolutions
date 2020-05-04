import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BinaryTreeNodeTest {

    @Test
    void testTrees(){

        BinaryTreeNode tree = new BinaryTreeNode(20);

        tree.insert(25);
        tree.insert(10);
        tree.insert(9);
        tree.insert(19);
        tree.insert(21);
        tree.insert(30);
        tree.insert(27);

        String actual = tree.toString();
        String expected = "9,10,19,20,21,25,27,30,";

        Assertions.assertEquals(expected, actual);
    }


    @Test
    void testIsSuperbalanced(){

        BinaryTreeNode tree = new BinaryTreeNode(20);

        tree.insert(25);
        tree.insert(10);
        tree.insert(9);
        tree.insert(19);
        tree.insert(21);
        tree.insert(30);
        tree.insert(27);

        Assertions.assertTrue( tree.isSuperbalanced() );
    }

    @Test
    void testGetMinDepth(){

        BinaryTreeNode tree = new BinaryTreeNode(20);

        tree.insert(25);
        tree.insert(10);
        tree.insert(9);
        tree.insert(19);
        tree.insert(21);
        tree.insert(30);
        tree.insert(27);

        Assertions.assertEquals( 3, tree.getMinDepth() );
    }
       @Test
    void testGetMaxDepth(){

        BinaryTreeNode tree = new BinaryTreeNode(20);

        tree.insert(25);
        tree.insert(10);
        tree.insert(9);
        tree.insert(19);
        tree.insert(21);
        tree.insert(30);
        tree.insert(27);

        Assertions.assertEquals( 4, tree.getMaxDepth() );
    }




}