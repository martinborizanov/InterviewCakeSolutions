public class Rectangle {

    // coordinates of bottom left corner
    private int leftX;
    private int rightX;
    private int bottomY;
    private int topY;

    // dimensions
    private int width;
    private int height;

    public Rectangle() {}

    public Rectangle(int leftX, int bottomY, int width, int height) {
        this.leftX = leftX;
        this.rightX = leftX + width;
        this.bottomY = bottomY;
        this.topY = bottomY + height;

        this.width  = width;
        this.height = height;
    }

    public int getLeftX() {
        return leftX;
    }

    public int getRightX() {
        return rightX;
    }

    public int getBottomY() {
        return bottomY;
    }

    public int getTopY(){
        return topY;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public boolean sameAs( Rectangle rectangle ){
        return rightX == rectangle.getRightX() && leftX == rectangle.getLeftX()
                && topY == rectangle.getTopY() && bottomY == rectangle.getBottomY();
    }



    public Rectangle getIntersection(Rectangle anotherRectangle ){

        int aTopY = anotherRectangle.getTopY();
        int aBottomY = anotherRectangle.getBottomY();
        int aLeftX = anotherRectangle.getLeftX();
        int aRightX = anotherRectangle.getRightX();

        boolean overlapsWith = false;

        int newLeftX;
        int newRightX;
        int newTopY;
        int newBottomY;

        boolean leftXOverlap = withinXCoordinates(aLeftX);
        boolean rightXOverlap = withinXCoordinates(aRightX);
        boolean topYOverlap = withinYCoordinates(aTopY);
        boolean bottomYOverlap = withinYCoordinates(aBottomY);

        newLeftX = leftXOverlap ? aLeftX : leftX;
        newRightX = rightXOverlap ? aRightX : rightX;
        newTopY = topYOverlap ? aTopY : topY;
        newBottomY = bottomYOverlap ? aBottomY : bottomY;

        if( leftXOverlap && topYOverlap ) overlapsWith = true;
        if( leftXOverlap && bottomYOverlap ) overlapsWith = true;
        if( rightXOverlap && topYOverlap ) overlapsWith = true;
        if( rightXOverlap && bottomYOverlap ) overlapsWith = true;

        // return self, if no overlapping
        if(overlapsWith == false) return new Rectangle(0,0,0,0);
        else return new Rectangle(newLeftX, newBottomY, newRightX - newLeftX, newTopY - newBottomY);
    }

    private boolean withinYCoordinates(int anotherY) {
        return bottomY <= anotherY && anotherY <= topY;
    }

    private boolean withinXCoordinates(int anotherX) {
        return leftX <= anotherX && anotherX <= rightX;
    }
}