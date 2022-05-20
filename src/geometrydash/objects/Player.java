package geometrydash.objects;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

public class Player extends Spielobjekt {
    private Input input;
    private int szeit = 700;
    private int aktzeit = 0;
    private boolean isjumping = false;
    private int jumpPositionY = 0;
    private boolean ismoving = false;
    private int movePositionX = 0;


    public Player(int x, int y, Image image, Input input) {
        super(x, y, image);
        this.input = input;
        shape = new Rectangle(x, y, 111, 111);

    }

    @Override
    public Shape getShape() {
        return shape;
    }

    @Override
    public void draw(Graphics g) {
        image.drawCentered(x, y);
        
    }

    public Boolean collide(Shape shape) {
        return this.shape.intersects(shape);
    }

    @Override
    public void update(int delta) {

        shape.setCenterY(y);
        shape.setCenterX(x);


        if (input.isKeyDown(input.KEY_SPACE) && !isjumping) {

            isjumping = true;
            aktzeit = 0;
            jumpPositionY = this.getY();
        }

        if (isjumping) {
            if (aktzeit < (szeit / 2))
                this.setY(this.getY() - 3);
            else
                this.setY(this.getY() + 3);
            aktzeit = aktzeit + delta;
        }

        if ((aktzeit > szeit)) {
            isjumping = false;
            this.setY(jumpPositionY);
        }

    }
}
