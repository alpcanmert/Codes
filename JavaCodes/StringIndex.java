import java.util.Scanner;

public class StringIndex {
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        String first=s.next();
        String second=s.next();
        String temp=characters(first,second);
        System.out.println(temp);
   }
    public static String characters(String first, String second){
        if(first.length()<second.length()){
            return "First string is must be longer than second string, output: -1";
        }
        int count=0;
        int temp=0;
        int c=0;
        int index=0;
        for(int i=0;i<second.length();i++){
            for(int j=temp;j<first.length();j++){
                if(first.charAt(j)==second.charAt(i)){
                    if(i==0) index=j;
                    count++;
                    temp=j+1;
                    c=1;
                    break;
                }
                else if(c==1 && j==temp && first.charAt(j)!=second.charAt(i)){
                    temp=j+1;
                    i=-1;
                    count=0;
                    c=0;
                    break;
                }
            }
        }if(count!=second.length()) return "Second string is not in first string, output: -1";
        return "Second string is in first string,in index of: "+index;
    }
}
