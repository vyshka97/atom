package ru.atom.geometry;

/**
 * Template class for
 */
public class Point implements Collider {
    private int x;
    private int y;


    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * @param o - other object to check equality with
     * @return true if two points are equal and not null.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        // cast from Object to Point
        Point point = (Point) o;

        return this.x == point.x && this.y == point.y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean isColliding(Collider other) {
        if (other instanceof Point) {
            Point point = (Point) other;
            return this.x == point.x && this.y == point.y;
        }

        if (other instanceof Bar) {
            Bar bar = (Bar) other;

            if (bar.getFirstPoint().getX() < bar.getSecondPoint().getX()) {

                if (this.x >= bar.getFirstPoint().getX() && this.x <= bar.getSecondPoint().getX()) {

                    if (bar.getFirstPoint().getY() < bar.getSecondPoint().getY()) {
                        return this.y >= bar.getFirstPoint().getY() && this.y <= bar.getSecondPoint().getY();
                    } else {
                        return this.y >= bar.getSecondPoint().getY() && this.y <= bar.getFirstPoint().getY();
                    }
                } else {
                    return false;
                }
            } else {
                if (this.x >= bar.getSecondPoint().getX() && this.x <= bar.getFirstPoint().getX()) {

                    if (bar.getFirstPoint().getY() < bar.getSecondPoint().getY()) {
                        return this.y >= bar.getFirstPoint().getY() && this.y <= bar.getSecondPoint().getY();
                    } else {
                        return this.y >= bar.getSecondPoint().getY() && this.y <= bar.getFirstPoint().getY();
                    }
                } else {
                    return false;
                }
            }
        } else {
            return false;
        }
    }
}
