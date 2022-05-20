package geometrydash.objects;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

public class Block extends Spielobjekt {
    private final int startX;
    private final int startY;
    private boolean ismoving = false;
    private int movePositionX = 0;
    private Input input;

    public Block(int x, int y, Image image, Input input) {
        super(x, y, image);
        startX = x;
        startY = y;
        this.input = input;
        shape = new Rectangle(x, y, 111, 111);


    }

    public void resetBlock() {
        this.setX(startX);
        this.setY(startY);
    }

    @Override
    public Shape getShape() {
        return shape;
    }

    @Override
    public void draw(Graphics g) {
        image.drawCentered(x, y);
        g.draw(shape);

    }

    public Boolean collide(Shape shape) {
        return this.shape.intersects(shape);
    }

    @Override
    public void update(int delta) {
        shape.setCenterX(x);
        shape.setCenterY(y);


        if (input.isKeyDown(input.KEY_G) && !ismoving) {

            movePositionX = this.getX();
            ismoving = true;

        }
        if (ismoving) {
            this.setX(this.getX() - 3);
        }

    }
}
