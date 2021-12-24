import java.util.Scanner;

public class Password {
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        System.out.println("1. A password must have at least ten characters.");
        System.out.println("2. A password consists of only letters and digits.");
        System.out.println("3. A password must contain at least two digits");
        System.out.println("Input a password (You are agreeing to the above Terms and Conditions.): ");
        String input=s.nextLine();
        System.out.println(password(input));
    }
    public static boolean password(String input){
        int temp=0;
        char char1='A';
        char char2='Z';
        char char3='0';
        char char4='9';
        boolean a;
        boolean b;
        boolean c;
        int count=0;
        for(int i=0;i<input.length();i++){
            if((input.charAt(i)>='0' && input.charAt(i)<='9') || (input.charAt(i)>='a' && input.charAt(i)<='z') || (input.charAt(i)>='A' && input.charAt(i)<='Z')){
                count++;

            }
        }
        if(count!=input.length()){
            c=false;
        }else{
            c=true;
        }

        if(input.length()>=10){
            a=true;
        }else{
            a=false;
        }
        for(int o=0;o<input.length();o++){
            if(input.charAt(o)<='9' && input.charAt(o)>='0'){
                temp++;
            }

        }
        if(temp>=2){
            b=true;
        }else{
            b=false;
        }
        return a && b && c;
    }
}
