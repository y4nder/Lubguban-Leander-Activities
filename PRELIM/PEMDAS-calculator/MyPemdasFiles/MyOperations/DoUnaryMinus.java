package MyPemdasFiles.MyOperations;
import MyPemdasFiles.DoOperation;
import MyPemdasFiles.StackInt;

public class DoUnaryMinus implements DoOperation{

    public void evaluate(StackInt stack) {
        int a, result;
        a = stack.pop();
        result = a * (-1);
        System.out.println("(-) " + a + " = " + result);
        stack.push(result);
    }
}
