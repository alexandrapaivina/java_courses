package ru.syqa.pft.sandbox;

public class Point {

  public double x;
  public double y;

  public Point(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public double distance(Point p2) {
    double distance = Math.abs(Math.sqrt(Math.pow((p2.x - this.x), 2) + Math.pow((p2.y - this.y), 2)));
    return Math.round(distance * 100.0) / 100.0;
  }
}
