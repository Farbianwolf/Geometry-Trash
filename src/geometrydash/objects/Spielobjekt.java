package geometrydash.objects;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Shape;

public abstract class Spielobjekt {
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected Image image;
    protected Shape shape;

    public Spielobjekt(int x, int y, Image image) {
        this.x = x;
        this.y = y;
        this.image = image;
        this.height = image.getHeight();
        this.width = image.getWidth();
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public abstract Shape getShape();
    public abstract void draw (Graphics g);
    public abstract void update (int delta);
}
