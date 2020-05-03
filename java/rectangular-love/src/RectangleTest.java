import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RectangleTest {

    @Test
    void topLeft() {
        Rectangle givenRectangle = new Rectangle(5,5,5,5);
        Rectangle anotherRectangle = new Rectangle(0,9,5,5);

        Assertions.assertTrue( givenRectangle.intersectsWith(anotherRectangle) );
    }

    @Test
    void topRight() {
        Rectangle givenRectangle = new Rectangle(5,5,5,5);
        Rectangle anotherRectangle = new Rectangle(9,9,5,5);

        Assertions.assertTrue( givenRectangle.intersectsWith(anotherRectangle) );
    }


    @Test
    void bottomRight() {
        Rectangle givenRectangle = new Rectangle(5,5,5,5);
        Rectangle anotherRectangle = new Rectangle(9,0,5,5);

        Assertions.assertTrue( givenRectangle.intersectsWith(anotherRectangle) );
    }


    @Test
    void bottomLeft() {
        Rectangle givenRectangle = new Rectangle(5,5,5,5);
        Rectangle anotherRectangle = new Rectangle(0,0,6,6);

        Assertions.assertTrue( givenRectangle.intersectsWith(anotherRectangle) );
    }

    @Test
    void noOverlap() {
        Rectangle givenRectangle = new Rectangle(5,5,5,5);
        Rectangle anotherRectangle = new Rectangle(0,0,4,4);

        Assertions.assertFalse( givenRectangle.intersectsWith(anotherRectangle) );
    }




}