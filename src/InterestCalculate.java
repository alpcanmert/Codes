import java.util.Scanner;

public class InterestCalculate {
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        int select;
        int h=2;
        int n;
        while(true){
            System.out.println("Enter compound frequency in day!");
            System.out.println("Please type 0 to exit");
            int compound=s.nextInt();
            if(compound==0){
                System.out.println("Goodbye :)");
                break;
            }
            while(true){
                System.out.println("1. USD");
                System.out.println("2. TRY");
                System.out.println("3. EUR");
                System.out.println("4. GBP");
                System.out.println("5. BTC");
                System.out.println("6. ETH");
                System.out.println("7. BNB");
                System.out.println("8. SOL");
                System.out.println("9. Return the select compound frequency");
                System.out.println("10. Exit");
                System.out.println("Select currency!");
                n=s.nextInt();
                String input;
                if(n==1) input="USD";
                else if(n==2) input="TRY";
                else if(n==3) input="EUR";
                else if(n==4) input="GBP";
                else if(n==5) input="BTC";
                else if(n==6) input="ETH";
                else if(n==7) input="BNB";
                else if(n==8) input="SOL";
                else if(n==9) break;
                else if(n==10){
                    System.out.println("Goodbye :)");
                    break;
                }
                else{
                    System.out.println("Wrong input, please try again!");
                    continue;
                }
                while(true){
                    System.out.println("1. Write budget,day and interest rate to calculate money after n-day");
                    System.out.println("2. Write first budget,last budget and interest rate to calculate how many days do you need");
                    System.out.println("3. Return the currency select step");
                    System.out.println("4. Exit the system");
                    System.out.println("Select an action");
                    select=s.nextInt();
                    if(select==1){
                        double budget;
                        while(true){
                            System.out.println("Enter "+input+" count!");
                            System.out.println("Write 0 to see actions");
                            budget=s.nextDouble();
                            if(budget==0){
                                System.out.println("");
                                break;
                            }
                            System.out.println("Write interest rate!");
                            System.out.println("Write 0 to return to the beginning of action "+select);
                            double rate=s.nextDouble();
                            if(rate==0){
                                System.out.println("");
                                continue;
                            }
                            System.out.println("Type compound count!"+"(Your compound frequency is "+compound+")");
                            System.out.println("Write 0 to return to the beginning of action "+select);
                            int count=s.nextInt();
                            if(count==0) {
                                System.out.println("");
                                continue;
                            }double budgettemp=budget;
                            String space=" days          ";
                            System.out.println("Count          NewValue");
                            String sum;
                            double dollar=0;
                            for(int i=1;i<count+1;i++){
                                sum="";
                                for(int j=0;j<space.length()-String.valueOf(i*compound).length();j++){
                                    sum+=space.charAt(j);
                                }

                                budgettemp=increase(budgettemp,rate,1);
                                if(budgettemp>Integer.MAX_VALUE){
                                    long budgetlong=(long)budgettemp;
                                    System.out.println((i*compound)+sum+budgetlong+" "+input);
                                    if(i==count){
                                        dollar=budgettemp;
                                    }
                                }
                                else{
                                    System.out.println((i*compound)+sum+(int)budgettemp+" "+input);
                                    if(i==count){
                                        dollar=budgettemp;
                                    }
                                }
                            }
                            System.out.println("");
                            if(dollar>Integer.MAX_VALUE){
                                System.out.println("First Price:"+(int)budget+" "+input+" || "+" You will have "+(long)dollar+" "+input+" after "+count*compound+" days"+" with % "+ rate +" interest rate and "+compound+" days compound frequency!");
                            }else{
                                System.out.println("First Price:"+(int)budget+" "+input+" || "+" You will have "+(int)dollar+" "+input+" after "+count*compound+" days"+" with % "+ rate +" interest rate and "+compound+" days compound frequency!");
                            }
                            break;
                        }
                        if(budget==0) continue;
                        System.out.println("");
                        System.out.println("If you want to see action menu, write 1");
                        System.out.println("If you want to exit the program, write 0");
                        h=s.nextInt();
                        if(h==1){
                            System.out.println("");
                            continue;
                        }
                        if(h==0){
                            System.out.println("");
                            break;
                        }
                    }
                    else if(select==2){
                        double firstbudget;
                        while(true){
                            System.out.println("Enter "+input+" count for first budget!");
                            System.out.println("Write 0 to see actions");
                            firstbudget=s.nextDouble();
                            if(firstbudget==0){
                                System.out.println("");
                                break;
                            }
                            System.out.println("Enter "+input+" count for last budget!");
                            System.out.println("Write 0 to return to the beginning of action "+select);
                            double lastbudget=s.nextDouble();
                            if(lastbudget==0){
                                System.out.println("");
                                continue;
                            }
                            if(lastbudget<firstbudget){
                                System.out.println("Last budget must be lower than first budget");
                                System.out.println("");
                                continue;
                            }
                            System.out.println("Write interest rate!");
                            System.out.println("Write 0 to return to the beginning of action "+select);
                            double rate=s.nextDouble();
                            if(rate==0){
                                System.out.println("");
                                continue;
                            }
                            double time;
                            String tme="days";
                            int methodvalue=(int)findTime(firstbudget,lastbudget,rate,compound,4);
                            String space=" days          ";
                            String sum;
                            System.out.println("Count          NewValue");
                            double budgettemp=firstbudget;
                            for(int i=1;i<methodvalue+1;i++){
                                sum="";
                                for(int j=0;j<space.length()-String.valueOf(compound*i).length();j++){
                                    sum+=space.charAt(j);
                                }
                                budgettemp=findTime(budgettemp,lastbudget,rate,compound,3);
                                System.out.println(i*compound+sum+(int)budgettemp+" "+input);

                            }
                            sum="";
                            int c1=(int)findTime(firstbudget,lastbudget,rate,compound,2);
                            int dayplus=(int)(((lastbudget-c1)/findTime(firstbudget,lastbudget,rate,compound,1))*compound);
                            int anotherday=dayplus+(methodvalue)*compound;
                            for(int i=0;i<space.length()-String.valueOf(anotherday).length();i++){
                                sum+=space.charAt(i);
                            }
                            if(anotherday>=365){
                                time=anotherday;
                                time=time/365;
                                time=(int)(time*100);
                                time=time/100;
                                tme=" years";
                            }
                            else{
                                time=anotherday;
                                time=time/30;
                                time=(int)(time*100);
                                time=time/100;
                                tme=" months";
                            }if(c1!=lastbudget) System.out.println(anotherday+sum+(int)lastbudget+" "+input);

                            System.out.println("You will need "+anotherday+" days"+"("+time+tme+")"+" to reach "+(int)lastbudget+" "+input+" from "+(int)firstbudget+" "+input+" with % "+ rate+" interest rate and "+compound+" days compound frequency!");
                            break;

                        }
                        if(firstbudget==0) continue;
                        System.out.println("If you want to see action menu, write 1");
                        System.out.println("If you want to exit the program, write 0");
                        h=s.nextInt();
                        if(h==1){
                            System.out.println("");
                            continue;
                        }
                        if(h==0){
                            System.out.println("");
                            break;
                        }
                    }
                    else if(select==3){
                        break;
                    }
                    else if(select==4){
                        System.out.println("Goodbye :)");
                        break;
                    }
                    else{
                        System.out.println("Wrong input, please try again!");
                    }
                }
                if(h==0){
                    System.out.println("Goodbye :)");
                    break;

                }
                if(select==4){
                    break;
                }

            }
            if(n==9) continue;
            break;
        }
    }
    public static double increase(double budget,double rate,int compoundtime){
        for(int i=0;i<compoundtime;i++){
            budget=(budget*(rate+100))/100;
        }
        return budget;
    }
    public static double findTime(double firstbudget,double lastbudget,double rate,int compound,int decide){
        int time=0;
        double c1=0;
        double c2;
        double firstbudgettemp=firstbudget;
        while(true){
            firstbudgettemp=increase(firstbudgettemp,rate,1);
            if(lastbudget<(int)firstbudgettemp){
                c2=firstbudgettemp;
                break;
            }
            if(decide==3) {
                return firstbudgettemp;
            }
            c1=firstbudgettemp;

            time++;
        }
        if(decide==1){
            return (c2-c1);
        }
        else if(decide==2){
            return c1;
        }
        else if(decide==0){
            return (time*compound);
        }
        else if(decide==4){
            return time;
        }
        return 0;
    }
}
