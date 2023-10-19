package MyPemdasFiles.MyOperations;
import MyPemdasFiles.DoOperation;
import MyPemdasFiles.StackInt;

public class DoDivision implements DoOperation{

    @Override
    public void evaluate(StackInt stack) {
        int a, b, result;
        a = stack.pop();
        b = stack.pop();
        result = b / a;
        System.out.println("    " + b + " / " + a + " = " + result);
        stack.push(result);    
    }
}
