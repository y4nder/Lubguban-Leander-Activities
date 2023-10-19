
import java.util.HashMap;
import java.util.Map;
import MyPemdasFiles.*;
import MyPemdasFiles.MyOperations.*;

public class Pemdas {
    private PostFix post;
    private StackInt stack;
    private Map<Character, DoOperation> operations;

    public Pemdas(){
        post = new PostFix();
        stack = new StackInt();
        operations = new HashMap<>();
        operations.put('+', new DoAddition());
        operations.put('-', new DoSubtraction());
        operations.put('/', new DoDivision());
        operations.put('*', new DoMultiplication());
        operations.put('^', new DoPower());
        operations.put('%', new DoModulo());
        operations.put('u', new DoUnaryMinus());
    }

    public int solve(String s){
        //conversion to postFix
        return Calculate(post.toPostFix(s));
    }

    public int Calculate(QueueChar queue){
        while(!queue.isEmpty()){
            char character = queue.dequeue();
            if(character == '_') stack.setHasNum(false);
            else if(operations.containsKey(character)){
                operations.get(character).evaluate(stack);
                stack.setHasNum(false);
            } 
            else{
                if(stack.HasNum() == true){
                    stack.push(stack.pop() * 10 + Integer.parseInt(String.valueOf(character)) );
                }
                else{
                    stack.push( Integer.parseInt(String.valueOf(character)) );
                    stack.setHasNum(true);
                }
            }
        }
        return stack.peek();
    }
}