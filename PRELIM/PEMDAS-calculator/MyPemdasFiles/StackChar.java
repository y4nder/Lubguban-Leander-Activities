package MyPemdasFiles;
public class StackChar{
    private char[] stack;
    private int top;

    public StackChar(){
        stack = new char[50];
        top = 0;
    }

    public boolean isEmpty(){
        if(top == 0) return true;
        else return false;
    }

    public void push(char x){
        top++;
        stack[top] = x;
    }

    public char pop(){
        if(top == 0){
            return 'x';
        }
        char x = stack[top--];
        return x;
    }
    
    public char peek(){
        if(stack[top] == 0){
            return 0;
        }
        return stack[top];
    }

}