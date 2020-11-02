package ru.syqa.pft.sandbox;

class MyFirstClass {

  public static void main(String[] arg) {

    Point p1 = new Point(0, 4);
    Point p2 = new Point(0, 3);

    System.out.println(p1.distance(p2));
  }
}
