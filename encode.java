package myPackage;
import java.util.*;
class myException extends Exception{
    myException(String msg){
        super(msg);
    }
}
class encode{
    static void is01(char a) throws myException{
        if(a != '1' || a != '0'){
            throw new myException("Not Binary");
        }
    }
    static byte[] inputArray(int size) throws myException{
        if(size != 3){
            throw new myException("Array Size is Invalid");
        }
        else{
            Scanner sc = new Scanner(System.in);
            byte[] message = new byte[3];
            String msg;
            System.out.print("Enter Message");
            msg = sc.nextLine();
            for(int i = 0; i<3; i++){
                is01(msg.charAt(i));
                if(msg.charAt(i) == '1'){
                    message[i] = 1;
                }
                else{
                    message[i] = 0;
                }
            }
            return message;
        }
    }
    static void MatriceMultiply(byte inputMatrice[]){
        byte[][] Gmatrice = {{1, 0, 1, 1, 0, 0},{1, 1, 0, 0, 1, 0},{1, 0, 1, 0, 0, 1}};
        byte[] EncodedMessage = new byte[6];
        for(int i = 0; i<=6; i++){
            int sum = 0;
            for(int j = 0; j<=3; j++){
                sum = sum + inputMatrice[j]*Gmatrice[j][i];
            }
            if(sum%2 == 0)
                EncodedMessage[i] = 0;
            else
                EncodedMessage[i] = 1;
        }
        for(int i = 0; i<=6; i++){
            System.out.print(EncodedMessage[i]);
        }
        System.out.println();
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        while(true){
            try{
                System.out.println("Enter Size of Message");
                int size = sc.nextInt();
                byte message[] = inputArray(size);
                MatriceMultiply(message);
            }catch(myException e){
                System.out.println(e);
            }
        }
    }
}