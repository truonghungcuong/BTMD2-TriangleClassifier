package com.codegym;

public class TriangleClassifier {
    public static final String ISOSCELES_TRIANGLE = "Tam giác cân";
    public static final String EQUILATERAL_TRIANGLE = "Tam giác đều";
    public static final String RIGHT_TRIANGLE = "Tam giác vuông";
    public static final String RIGHT_ISOSCELES_TRIANGLE = "Tam giác vuông cân";
    public static final String NOT_TRIANGLE = "Không phải là tam giác";
    public static final String NORMAL_TRIANGLE = "Tam giác thường";

    public String getTriangleClass(double side1, double side2, double side3) {
        boolean isTriangle = side1 + side2 > side3 && side2 + side3 > side1 && side3 + side1 > side2;
        if (!isTriangle)
            return NOT_TRIANGLE;

        boolean isEqualateralTriangle = side1 == side2 && side2 == side3;
        if (isEqualateralTriangle)
            return EQUILATERAL_TRIANGLE;

        boolean isRightTriangle = side1 * side1 + side2 * side2 == side3 * side3
                || side1 * side1 + side3 * side3 == side2 * side2
                || side2 * side2 + side3 * side3 == side1 * side1;
        boolean isIsoscelesTriangle = side1 == side2 || side2 == side3 || side3 == side1;

        if (isRightTriangle && isIsoscelesTriangle)
            return RIGHT_ISOSCELES_TRIANGLE;

        if (isRightTriangle)
            return RIGHT_TRIANGLE;

        if (isIsoscelesTriangle) {
            return ISOSCELES_TRIANGLE;
        }

        return NORMAL_TRIANGLE;
    }

}
