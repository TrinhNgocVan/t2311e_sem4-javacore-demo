package org.aptech.t2311e.core.factory;

public class ShapeFactory {
    public Shape getShape(String shapeType, double... params){
        if(shapeType == null){
            return null;
        }
        switch (shapeType.toUpperCase()){
            case "CIRCLE" : return new Circle(params[0]);
            case "RECTANGLE" : return new Rectangle(params[0],params[1]);
            case "SQUARE" : return new Square(params[0]);
            default: throw new IllegalArgumentException("Cannot have valid shapeType");
        }
    }

    public  int sum(int... nums ){
        int  total = 0;
        for (int num  :  nums){
          total += num;
        }
        return total;
    }


}
