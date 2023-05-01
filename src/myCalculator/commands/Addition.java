package myCalculator.commands;

import myCalculator.Context;
public class Addition extends BinOperation {
    public Addition(Context context, String [] arguments) {
        super(context, arguments);
    }

//    @Override
//    public void apply() {
////        if(context.getMyStack().size() < 2) {
////            System.out.println("Too few arguments on stack");
////        }
////
////        var number1 = context.getMyStack().pop();
////        System.out.println("numer1: " + number1);
////
////        var number2 = context.getMyStack().pop();
////        System.out.println("number2: " + number2);
////
////        context.getMyStack().push(number1 + number2);
//    }

    @Override
    public void makeBinOperation(Double num1, Double num2) {
//        super.makeBinOperation(num1, num2);

        context.getMyStack().push(num1 + num2);
    }
}
