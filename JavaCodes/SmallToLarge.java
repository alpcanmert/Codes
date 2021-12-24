import java.util.Scanner;

public class SmallToLarge {
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        System.out.println("1: Small and Large Numbers");
        System.out.println("Select");
        int select=s.nextInt();
        if(select==1){
            int count=1;
            int loop=0;
            System.out.println("Write number count!");
            int number=s.nextInt();
            int[] array=new int[number];
            array=smallLarge(loop,array);
            System.out.println("1: Sorting numbers from smallest to largest ");
            System.out.println("2: See smallest number and largest number ");
            System.out.println("Select what do you want?");
            while(true){
                int selectaction=s.nextInt();
                if(selectaction==1){
                    for(loop=0;loop<array.length;loop++,count++){
                        System.out.print(array[loop]+"    ");
                        if(count%10==0){
                            System.out.println("");
                        }
                }
                    break;
                }if(selectaction==2) {
                    System.out.println("Lowest: "+array[0]+ " Largest: "+array[array.length-1]);
                    break;
                }else{
                    System.out.println("Wrong Type! Please try again");
                }
            }
        }

    }
    public static int[] smallLarge(int loop,int[] array){
        int v;
        String str="";
        int different=0;
        for(int i=0;i< array.length;i++){
            int random=(int)(Math.random()*(1000-different)+different);
            for(v=0;v< array.length;v++){
                if(random==array[v] && random!=0){
                    break;
                }if(random==0){
                    different=1;
                    v= array.length;
                    break;
                }
            }if(v!=array.length){
                i--;
                continue;
            }
            array[i]=random;



        }for(int i=0;i< array.length-1;i++){
            if(array[i]>array[i+1]){
                int temp=array[i];
                array[i]=array[i+1];
                array[i+1]=temp;
                i=-1;
            }
        }

        return array;

    }

}
