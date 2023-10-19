package MyPemdasFiles;
public class PostFix {
    private StackChar stack;
    private QueueChar newExp;

    public PostFix(){
        stack = new StackChar();    //create a stack for operators
        newExp = new QueueChar();
    }

    private void updateExpression(char character){
        newExp.queue(character);
    }

    //declaration of priorities basesd on operator
    private static final int LOWEST_PRIORITY = 0;
    private static final int ADD_MINUS_PRIORITY = 1;
    private static final int MULT_DIV_MOD_PRIORITY = 2;
    private static final int UNARY_PRIORITY = 3;
    private static final int EXP_PRIORITY= 4;

    private int checkPriority(char x){ //a method to check hierarchy in PEMDAS
        switch(x){
            case '(':
                return LOWEST_PRIORITY;
            case '+':
            case '-':
                return ADD_MINUS_PRIORITY;
            case '*':
            case '/':
            case '%':
                return MULT_DIV_MOD_PRIORITY;
            case 'u':
                return UNARY_PRIORITY;
            case '^':
                return EXP_PRIORITY;
        }
        return -1;
    }


    public QueueChar toPostFix(String expression){
        char previous = '_';
        for(int i = 0; i < expression.length(); i++){
            char character = expression.charAt(i);
            switch(character){
                case ' ': 
                    break;
                case '(':
                    if( isParenthesesMult(previous) ){ // added multiplication using parentheses
                        updateExpression('_'); //separator from operator
                        stack.push('*');
                    }
                    stack.push(character);
                    break;
                case ')':
                    char n;
                    while( (n = stack.pop()) != '('){
                        updateExpression(n);
                    }
                    break;
                default:
                    if(isNumber(character)){
                        updateExpression(character);
                    }
                    else{
                        if(isUnaryOperation(character, previous) ){ //check for unary minus
                            stack.push('u');          
                        }
                        else{                 
                            updateExpression('_'); //separator
                            while(checkPriority(stack.peek()) >= checkPriority(character)){
                                updateExpression(stack.pop());
                            }
                            stack.push(character);
                        }
                    }
                    break;
            }
            if(character == ' ') previous = expression.charAt(i - 1);
            else previous = character;
        }

        //after loop has ended pop the remaining operators
        while( !stack.isEmpty()){
            updateExpression(stack.pop());
        }
        return newExp;
    }

    //private methods
    private boolean isParenthesesMult(char character){ // method to check if multiplication by parentheses is true
        if(isNumber(character) || character == ')') return true;
        else return false;
    }

    private boolean isUnaryOperation(char character, char previous){ //method to check if unary minus opration is true
        if( character == '-' && (previous == '_' || previous == '(' || checkPriority(previous) > 0) ) return true;
        else return false;
    }

    private boolean isNumber(char x){ //checks if character is a digit
        return Character.isDigit(x);
    }
}
