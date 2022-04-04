package geometrydash.objects;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Polygon;
import org.newdawn.slick.geom.Shape;

public class Spike extends Spielobjekt {

    public Spike(int x, int y, Image image) {
        super(x, y, image);
        shape = new Polygon();
       // Polygon.addPoint(111,111);
       // Polygon.addPoint();

    }

    @Override
    public Shape getShape() {
        return null;
    }

    @Override
    public void draw(Graphics g) { image.drawCentered(x, y);

    }

    @Override
    public void update(int delta) {

    }
}
