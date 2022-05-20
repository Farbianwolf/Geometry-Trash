package geometrydash.objects;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Polygon;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

public class sSpike extends Spielobjekt {
    public sSpike(int x, int y, Image image) {
        super(x, y, image);
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

    }
}
