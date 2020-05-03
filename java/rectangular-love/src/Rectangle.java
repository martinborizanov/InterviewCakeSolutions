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

    public boolean intersectsWith( Rectangle anotherRectangle ){

        int aTopY = anotherRectangle.getTopY();
        int aBottomY = anotherRectangle.getBottomY();
        int aLeftX = anotherRectangle.getLeftX();
        int aRightX = anotherRectangle.getRightX();

        boolean leftXOverlap = leftX <= aLeftX && aLeftX <= rightX;
        boolean rightXOverlap = leftX <= aRightX && aRightX <= rightX;
        boolean topYOverlap = bottomY <= aTopY && aTopY <= topY;
        boolean bottomYOverlap = bottomY <= aBottomY && aBottomY <= topY;

        if( leftXOverlap && topYOverlap ) return true;
        if( leftXOverlap && bottomYOverlap ) return true;
        if( rightXOverlap && topYOverlap ) return true;
        if( rightXOverlap && bottomYOverlap ) return true;

        return false;
    }
}