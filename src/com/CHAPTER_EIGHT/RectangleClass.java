package com.CHAPTER_EIGHT;

public class RectangleClass {
    private double length = 1 ;
    private double width = 1;
    private double area;
    private double perimeter;
    public RectangleClass(double length, double width) {
    }

    public double setArea(double length, double width) {
        if (length > 0.0 && length < 20 && width > 0.0 && width < 20 ){
            area = length * width;
            return area; }
        else{
            width = 1.0;
            length = 1.0;
            area = length * width;
            System.out.println ("Length And Width Must Not be Less Than 0.0 Or greater Than 19"); }
        return area;
    }

    public double getArea(){
        return area;
    }

    public double setPerimeter(double length, double width) {
        if (length > 0.0 && length < 20 && width > 0.0 && width < 20 ){
            perimeter = (length + width) * 2;
            return perimeter; }
        else{
            length = 1.0;
            width = 1.0;
            System.out.println ("Length And Width Must Not be Less Than 0.0 Or greater Than 19"); }
        return perimeter = (length + width) * 2;

    }

    public double getPerimeter() {
        return perimeter;
    }
}
