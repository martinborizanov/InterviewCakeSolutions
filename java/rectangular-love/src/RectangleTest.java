import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RectangleTest {

    @Test
    void topLeft() {
        Rectangle givenRectangle = new Rectangle(5,5,5,5);
        Rectangle anotherRectangle = new Rectangle(0,9,6,6);

        Rectangle expected = new Rectangle(5,9,1,1);
        Rectangle actual = givenRectangle.getIntersection(anotherRectangle);

        Assertions.assertTrue( expected.sameAs( actual ));
    }

    @Test
    void topRight() {
        Rectangle givenRectangle = new Rectangle(5,5,5,5);
        Rectangle anotherRectangle = new Rectangle(9,9,6,6);

        Rectangle expected = new Rectangle(9,9,1,1);
        Rectangle actual = givenRectangle.getIntersection(anotherRectangle);

        Assertions.assertTrue( expected.sameAs( actual ));
    }


    @Test
    void bottomRight() {
        Rectangle givenRectangle = new Rectangle(5,5,5,5);
        Rectangle anotherRectangle = new Rectangle(9,0,6,6);

        Rectangle expected = new Rectangle(9,5,1,1);
        Rectangle actual = givenRectangle.getIntersection(anotherRectangle);

        Assertions.assertTrue( expected.sameAs( actual ));
    }


    @Test
    void bottomLeft() {
        Rectangle givenRectangle = new Rectangle(5,5,5,5);
        Rectangle anotherRectangle = new Rectangle(0,0,6,6);

        Rectangle expected = new Rectangle(5,5,1,1);
        Rectangle actual = givenRectangle.getIntersection(anotherRectangle);

        Assertions.assertTrue( expected.sameAs( actual ));
    }

    @Test
    void overlapFully() {

        Rectangle givenRectangle = new Rectangle(5,5,5,5);
        Rectangle anotherRectangle = new Rectangle(6,6,3,3);

        Rectangle expected = new Rectangle(6,6,3,3);
        Rectangle actual = givenRectangle.getIntersection(anotherRectangle);

        Assertions.assertTrue( expected.sameAs( actual ));
    }

    @Test
    void noOverlap() {
        Rectangle givenRectangle = new Rectangle(5,5,5,5);
        Rectangle anotherRectangle = new Rectangle(0,0,4,4);

        Assertions.assertTrue( new Rectangle(0,0,0,0)
                                    .sameAs(givenRectangle.getIntersection(anotherRectangle) ));
    }




}