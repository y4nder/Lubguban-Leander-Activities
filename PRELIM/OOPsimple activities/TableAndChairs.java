public class TableAndChairs{
    public static void main(String[] args){
        System.out.println("X                       X");
        System.out.println("X                       X");
        System.out.println("X      XXXXXXXXXXX      X");
        System.out.println("XXXXX  X         X  XXXXX");
        System.out.println("X   X  X         X  X   X");
        System.out.println("X   X  X         X  X   X");
        System.out.println();
        loopedChair();
    }


    static void loopedChair(){    
        char c = 'X';
        for(int i = 1; i < 4; i++){
            for(int j = 1; j <= 25; j++){
                if(i < 3){
                    if(j == 1 || j == 25){
                        System.out.print(c);
                    }
                    else{
                        System.out.print(" ");
                    }
                }
                else if( i == 3 ){
                    if( (j > 1 && j < 8) || (j > 18 && j < 25 ) ){
                        System.out.print(" ");
                    }
                    else System.out.print(c);
                }
            }
            System.out.println();
        }

        for(int i = 1; i < 4; i++){
            for(int j = 1; j <= 25; j++){
                if(i == 1){
                    if((j > 5 && j < 8) || (j > 8 && j <18 ) || (j > 18 && j < 21)){
                        System.out.print(" ");
                    }
                    else {
                        System.out.print(c);
                    }
                }
                else{
                    if( (j > 1 && j < 5) ||(j > 5 && j < 8) || (j > 8 && j <18 ) || (j > 18 && j < 21)  || ( j > 21 && j < 25) ){
                        System.out.print(" ");
                    }
                    else {
                        System.out.print(c);
                    }
                }
            }
            System.out.println();
        }
    }
}