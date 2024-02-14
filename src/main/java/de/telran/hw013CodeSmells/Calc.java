package de.telran.hw013CodeSmells;

// Нарушение CODE SMELLS: Магические числа
public class Calc {
    public double calculateArea(int shapeType, double... params) {
        if (shapeType == 1) { // 1- круг
            double radius = params[0];
            return Math.PI * radius * radius;
        } else if (shapeType == 2) { // 2 - квадрат
            double side = params[0];
            return side * side;
        } else if (shapeType == 3) { // 3 - треугольник
            double a = params[0];
            double b = params[1];
            double c = params[2];
            double s = (a + b + c) / 2;
            return Math.sqrt(s * (s - a) * (s - b) * (s - c));
        }
        return 0.0;
    }
}

class CalcI {
    public double calculateArea(int shapeType, double param) {
        if (param<=0) throw new IllegalArgumentException("Argument must be greater than zero.");

        if (shapeType == 1) { // 1- круг
            return Math.PI * param * param;
        } else if (shapeType == 2) { // 2 - квадрат
            return param * param;
        } else throw new IllegalArgumentException("shapeType must be from 1 or 2");
    }

    public double calculateArea(int shapeType, double a, double b, double c) {
        if (a<=0 || b<=0 || c<=0) throw new IllegalArgumentException("Arguments must be greater than zero.");

        if (shapeType == 3) { // 3 - треугольник
            double s = (a + b + c) / 2;
            return Math.sqrt(s * (s - a) * (s - b) * (s - c));
        } else throw new IllegalArgumentException("shapeType must be 3");
    }

}



//Var.2 (как вариант, но мне больше первый нравится)
class CalcI2 {
    public double calculateArea(int shapeType, double[] params) {
        // shapeType:
        // 1 - круг, 2 - квадрат, 3 - треугольник
        if ((shapeType==1 || shapeType==2) && params[0]<=0) throw new IllegalArgumentException("First argument must be greater than zero.");
        if (shapeType==3 && (params[0]<=0 || params[1]<=0 || params[2]<=0)) throw new IllegalArgumentException("Arguments must be greater than zero.");
        if (shapeType<1 || shapeType>3) throw new IllegalArgumentException("shapeType must be from 1 to 3");

        return switch (shapeType) {
            case 1 -> Math.PI * params[0] * params[0];
            case 2 -> params[0] * params[0];
            case 3 -> {
                double s = (params[0] + params[1] + params[2]) / 2;
                yield Math.sqrt(s * (s - params[0]) * (s - params[1]) * (s - params[2]));
            }
            default -> 0.0;
        };
    }

}
