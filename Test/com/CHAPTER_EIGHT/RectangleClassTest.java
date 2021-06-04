package com.CHAPTER_EIGHT;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RectangleClassTest {
    RectangleClass rectangle;
    double areaOfRectangle;
    @BeforeEach
        void beforeEachTest(){
        rectangle = new RectangleClass ( 1.0,1.0 );
    }
    @Test
        void checkThatAreaOfARectangleCanBeCalculated(){
        rectangle.setArea (10.0,10.0);
        areaOfRectangle = rectangle.getArea ();
        assertEquals(100,areaOfRectangle); }

    @Test
    void checkThatLengthCanNotHaveAValueLessThan_1(){
        rectangle.setArea (-5.0,10.0);
        areaOfRectangle = rectangle.getArea ();
        assertEquals(1,areaOfRectangle); }

    @Test
    void checkThatWidthCanNotHaveAValueLessThan_1(){
        rectangle.setArea (5.0,-10.0);
        areaOfRectangle = rectangle.getArea ();
        assertEquals(1,areaOfRectangle); }

    @Test
    void checkThatLengthCanNotHaveAValueGreaterThan_19(){
        rectangle.setArea (25.0,10.0);
        areaOfRectangle = rectangle.getArea ();
        assertEquals(1,areaOfRectangle); }

    @Test
    void checkThatWidthCanNotHaveAValueGreaterThan_19(){
        rectangle.setArea (5.0,20.0);
        areaOfRectangle = rectangle.getArea ();
        assertEquals(1,areaOfRectangle); }

    @Test
    void checkThatPerimeterOfARectangleCanBeCalculated(){
        rectangle.setPerimeter(10.0,10.0);
        double perimeterOfRectangle = rectangle.getPerimeter();
        assertEquals(40,perimeterOfRectangle);
    }
}