package pro006generics;

public class SimpleCalc {
    public static void main(String[] args) {
        System.out.println(SimpleCalc.<Integer>add(5,2));
        System.out.println(SimpleCalc.<Double>add(5.0,2.0));
        System.out.println(SimpleCalc.<Long>add(5L,2L));

        System.out.println(SimpleCalc.<Integer,Integer>div(5,0));

    }

//String
//    public static <T extends String> T add(T arg1, T arg2){
//        return (T) arg1.concat(arg2);
//    }
//    public static <T extends Integer> T add(T arg1, T arg2){
//        //return Integer.valueOf(arg1) + Integer.valueOf(arg2);
//        return (T) Integer.valueOf(arg1.intValue() + arg2.intValue());
//    }

    public static <T extends Number> T add(T arg1, T arg2){
        //return Integer.valueOf(arg1) + Integer.valueOf(arg2);
        //return (T) Integer.valueOf(arg1.intValue() + arg2.intValue());
        return (T)Double.valueOf(arg1.doubleValue()+arg2.doubleValue());
    }


    public static <T extends Number,U extends Number> U div(T arg1, T arg2){
        return (U)Double.valueOf(arg1.doubleValue()/arg2.doubleValue());

    }
}



/// T add(T arg1, T arg2)
/// T sub(T arg1, T arg2)
/// T mult(T arg1, T arg2)
/// U div(T arg1, T arg2)
/// T sqr(T arg)
// Тело метода одинаково для всех данных, или аналогичный

//Если разные , исп -> @Override

//@Override (отлич реализация)
//overload (отлич сигнатура)

//кастить !!! (преобр.типа)
//<T extends Integer> - ограничение типа (выше нельзя)
//если не ограничем , то получаем Object
