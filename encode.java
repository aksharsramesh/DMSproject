package myPackage;
import java.util.*;

class myException extends Exception{
    myException(String msg){
        super(msg);
    }
}

class GeneratorMatrice{
    int[][] a = {{1,0,0,1,1,1},{0,1,0,0,1,0},{0,0,1,1,0,1}};
    void print(){
        for(int i = 0; i<3; i++){
            for(int j = 0; j<6; j++){
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
    void encode(int[][] message){
        int sum;
        System.out.println("Encoded Message");
        for(int i = 0; i<6; i++){
            sum = 0;
            for(int j = 0; j<3; j++){
                sum = sum + a[j][i]*message[0][j];
            }
            if(sum%2 == 0)
                System.out.print("0 ");
            else
                System.out.print("1 ");
        }
        System.out.println();
    }
}
class encode {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GeneratorMatrice ne = new GeneratorMatrice();
        System.out.println("Generator Matrice\n");
        int[][] message = new int[1][3];
        ne.print();
        while(true){
            try{
                System.out.println("\nENCODING MACHINE\n1. Encode New String\n2. Exit\nEnter Coice");
                int choice = sc.nextInt();
                if(choice != 2 && choice != 1)
                    throw new myException("Invalid Choice"); 
                switch(choice){
                    case 1:{
                        System.out.println("\nEnter Message\nMessage Contains Three Bits (1 or 0)");
                        for(int i = 0; i<3; i++){
                            int input = sc.nextInt();
                            if(input != 0 && input != 1)
                                throw new myException("Invalid Input");    
                            message[0][i] = input;
                        }
                        ne.encode(message); 
                        break;
                    }
                    case 2: System.exit(0);
                    default:{};
                }
            }
            catch(myException e){
                System.out.println(e);
            }
        }
    }
}
                