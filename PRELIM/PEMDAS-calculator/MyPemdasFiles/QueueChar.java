package MyPemdasFiles;

public class QueueChar {
    private char[] queue;
    private int tail;

    public QueueChar(){
        queue = new char[50];
        tail = -1;
    }

    public char peek(){
        if(isEmpty()) return 'x';
        return queue[0];
    }

    public void queue(char element){
        queue[++tail] = element;
    }

    public char dequeue(){
        char element = peek();
        for(int i = 0; i <= tail; i++){
            queue[i] = queue[i + 1];
        }
        tail--;
        return element;
    }


    public void show(){
        if(isEmpty()){
            System.out.println("empty");
            return;
        }
        for(int i = 0; i <= tail; i++){
            System.out.print(queue[i]);
        }
    }

    public boolean isEmpty(){
        return tail == -1;
    }
}
