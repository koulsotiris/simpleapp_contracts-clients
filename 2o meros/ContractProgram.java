import java.util.Scanner;

public class ContractProgram extends Mobile{
    protected int planChoice,freeSMS,freeTalk;
    protected double sale = 0.2, price, extraPrice = 0;
    
    
    public ContractProgram(){
        super();}
    public void Sign(){
        super.Sign();
        contract=2;

        Scanner input = new Scanner(System.in);

        System.out.println("Choose Plan:");
        ContractProgram.showPlans();
        System.out.print(">");
        planChoice = input.nextInt();
        System.out.println();
        
        switch(planChoice){
            case 1: talktime += 150; sms+=150; price = 7; break;
            case 2: talktime += 300; sms+=300; price = 10; break;
            case 3: talktime += 1000; sms+=1000;price = 13; break;
            default: break;
        }

        System.out.println();

        System.out.println("Your passcode is " + passcode);
        System.out.println();
    }


    public static void showPlans(){
        System.out.println("1) 150 min talk & SMS from 7euro / month now only " + (7-7*0.2)+"\n2) 300 min talk & SMS from 10euro / month now only " + (10-10*0.2)+" \n3) 1000 min talk & SMS from 13euro / month now only " + (13-13*0.2)+" \n*all three plans include 100 minutes and sms from free!" );}


    public void updatePrice(int talktime_usage, int sms_usage){

        super.updateProgram(talktime_usage, sms_usage);

        if(talktime<0)
            extraPrice += talktime*(-2);

        if(sms<0)
            extraPrice += sms*(-0.2);
        
        System.out.println("Update completed");

    }


    public void getInvoice(){
        System.out.println("Contract : " + (price-price*sale) + "\n" +
                           "Overuse price:  " + (extraPrice-extraPrice*sale) + "\n" +
                           "Total with 20% off: " + ((price+extraPrice)-(price + extraPrice)*sale+fixedfee));
    }


    public void getFree(){
        switch(planChoice){
            case 1:
                if(talktime <= 1000 && sms<=50)
                    {freeTalk = 0;freeSMS=0;}
                else if (sms<=50)
                    {freeSMS=0;freeTalk=talktime-1000;}
                else if (talktime<=1000)
                    {freeSMS = sms - 50;freeTalk=0;}
                else 
                    {freeTalk=talktime-1000;freeSMS = sms - 50;}
                break;

            case 2:
                if(talktime <= 3000 && sms<=100)
                    {freeTalk = 0;freeSMS=0;}
                else if (sms<=100)
                    {freeSMS=0;freeTalk=talktime-1000;}
                else if (talktime<=3000)
                    {freeSMS = sms - 100;freeTalk=0;}
                else 
                    {freeTalk=talktime-3000;freeSMS = sms - 100;}
        break;
            
            case 3:
                if(talktime <= 1000 && sms<=150)
                    {freeTalk = 0;freeSMS=0;}
                else if (sms<=150)
                    {freeSMS=0;freeTalk=talktime-1000;}
                else if (talktime<=5000)
                    {freeSMS = sms - 150;freeTalk=0;}
                else 
                    {freeTalk=talktime-5000;freeSMS = sms - 150;}
        break;

               
        }
    }

    public String toString(){
        return "Service Type: Contract Program " + planChoice + "\n" +
                super.toString() + "\n" +
                "Talk time and SMS left: " + talktime+ "min talktime and " + sms + "SMS";
    }
}