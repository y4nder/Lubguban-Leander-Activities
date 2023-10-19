package MyPemdasFiles.MyOperations;
import MyPemdasFiles.DoOperation;
import MyPemdasFiles.StackInt;

public class DoPower implements DoOperation{

    @Override
    public void evaluate(StackInt stack) {
        int a, b, result;
        a = stack.pop();
        b = stack.pop();
        result = b;
        for(int i = 1; i < a; i++){
            result *= b;
        }
        System.out.println("    " + b + " ^ " + a + " = " + result);
        stack.push(result);    
    }
}
