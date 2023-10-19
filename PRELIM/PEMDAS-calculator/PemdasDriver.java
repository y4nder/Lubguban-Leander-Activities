import java.util.Scanner;
import MyPemdasFiles.*;
public class PemdasDriver{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        PostFix post = new PostFix();
        Pemdas p = new Pemdas();

        System.out.println("Ex. ((2+1)-2/2*(3+1))^2 or (2)2 or -2(2)");
        System.out.print("Enter expression: ");

        String s = scan.nextLine();
        
        System.out.println();
        QueueChar q = post.toPostFix(s);
        System.out.println("PostFixed: ");
        q.show();
        System.out.println();

        int result = p.solve(s);
        System.out.println("\nresult: " + result);
    }
}