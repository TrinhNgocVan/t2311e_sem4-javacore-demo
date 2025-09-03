package org.aptech.t2311e.designPattern.factory;

public class A {
    /*
    1. Creatinal : nhóm khởi tạo (che giấu logic khởi tạo)
    Factory , Abstract, Builder, Singleton , Prototype
    2. Structure
    3. Behavioral : hành vi
     */
    public static void main(String[] args) {
        factoryExample();
    }

    void oldStyle(){
      Rectangle r1 = new Rectangle(1.1 ,2);
      Square s1 = new Square(1);
      Circle c1 = new Circle(2);
    }

    public static void factoryExample(){
        ShapeFactory shapeFactory = new ShapeFactory();
        Shape r1 = shapeFactory.getShape("RECTANGLE", 1.1,1.2);
        Shape s1 = shapeFactory.getShape("SQUARE", 1.1);
        Shape c1 = shapeFactory.getShape("CIRCLE", 1.1);
        System.err.println(r1.area());
        System.err.println(s1.area());
        System.err.println(c1.area());
    }
}
