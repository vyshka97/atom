package ru.atom.geometry;

public class Bar implements Collider {

    private Point firstPoint;
    private Point secondPoint;

    public Bar(int firstCornerX, int firstCornerY, int secondCornerX, int secondCornerY) {
        this.firstPoint = new Point(firstCornerX, firstCornerY);
        this.secondPoint = new Point(secondCornerX, secondCornerY);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bar bar = (Bar) o;

        int maxThisX = Math.max(this.getFirstPoint().getX(), this.getSecondPoint().getX());

        int minThisX = Math.min(this.getFirstPoint().getX(), this.getSecondPoint().getX());

        int maxBarX = Math.max(bar.getFirstPoint().getX(), bar.getSecondPoint().getX());

        int minBarX = Math.min(bar.getFirstPoint().getX(), bar.getSecondPoint().getX());

        int maxThisY = Math.max(this.getFirstPoint().getY(), this.getSecondPoint().getY());

        int minThisY = Math.min(this.getFirstPoint().getY(), this.getSecondPoint().getY());

        int maxBarY = Math.max(bar.getFirstPoint().getY(), bar.getSecondPoint().getY());

        int minBarY = Math.min(bar.getFirstPoint().getY(), bar.getSecondPoint().getY());

        return maxThisX == maxBarX
                && maxThisY == maxBarY
                && minThisX == minBarX
                && minThisY == minBarY;

    }

    @Override
    public boolean isColliding(Collider other) {
        if (other instanceof Point) {
            Point point = (Point) other;
            return point.isColliding(this);
        }

        if (other instanceof Bar) {
            Bar bar = (Bar) other;

            if (this.firstPoint.isColliding(bar) || this.secondPoint.isColliding(bar)
                    || bar.getFirstPoint().isColliding(this) || bar.getSecondPoint().isColliding(this)) {
                return true;
            }

            int maxThisX = Math.max(this.getFirstPoint().getX(), this.getSecondPoint().getX());

            int minThisX = Math.min(this.getFirstPoint().getX(), this.getSecondPoint().getX());

            int maxBarX = Math.max(bar.getFirstPoint().getX(), bar.getSecondPoint().getX());

            int minBarX = Math.min(bar.getFirstPoint().getX(), bar.getSecondPoint().getX());

            int maxThisY = Math.max(this.getFirstPoint().getY(), this.getSecondPoint().getY());

            int minThisY = Math.min(this.getFirstPoint().getY(), this.getSecondPoint().getY());

            int maxBarY = Math.max(bar.getFirstPoint().getY(), bar.getSecondPoint().getY());

            int minBarY = Math.min(bar.getFirstPoint().getY(), bar.getSecondPoint().getY());

            return this.getFirstPoint().getX() >= minBarX
                    && this.getFirstPoint().getX() <= maxBarX
                    && bar.getFirstPoint().getY() >= minThisY
                    && bar.getFirstPoint().getY() <= maxThisY
                    || bar.getFirstPoint().getX() >= minThisX
                    && bar.getFirstPoint().getX() <= maxThisX
                    && this.getFirstPoint().getY() >= minBarY
                    && this.getFirstPoint().getY() <= maxBarY;

        } else {
            return false;
        }
    }

    public Point getFirstPoint() {
        return firstPoint;
    }

    public Point getSecondPoint() {
        return secondPoint;
    }
}
