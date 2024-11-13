import java.util.Scanner;

public class CardContractProgram extends Mobile{
    protected double AvailableBalance = 0, price=0, sale = 0.25,extraPrice=0;
    protected int freeTalk,freeSMS,planChoice;
    
    public CardContractProgram(){
        super();
        contract=3;
        Scanner input = new Scanner(System.in);
        System.out.println( "Insert Monthly Available Balance :" );
        System.out.print(">");
        AvailableBalance = input.nextInt();
        System.out.println();
        System.out.println("Choose Plan:");
        CardContractProgram.showPlans();
        System.out.print(">");
        planChoice = input.nextInt();
        System.out.println();
        
        switch(planChoice){
            case 1: talktime += 1500; sms+=50; price = 10; AvailableBalance-=price-price*sale+fixedfee; break;
            case 2: talktime += 3200; sms+=100; price = 15;AvailableBalance-=price-price*sale+fixedfee; break;
            case 3: talktime += 7000; sms+=150; price = 20;AvailableBalance-=price-price*sale+fixedfee; break;
            default: break;
        }

        System.out.println("Your passcode is " + passcode);
        System.out.println();
    }
    
    public static void showPlans(){
        System.out.println("1) 1500 min talk & 50 SMS - from 10euro / month now only "+ (10-10*0.25)+"\n2) 3200 min talk & 100 SMS from 15euro / month now only "+ (15-15 *0.25)+"\n3) 7000 min talk & 150 SMS from 20euro / month now only " + (20-20*0.25)+ "\n*all three plans include 100 minutes and sms for free!" );
    }


    public void updatePrice(int talktime_usage, int sms_usage){

        super.updateProgram(talktime_usage, sms_usage);

        if(talktime<0){
            extraPrice-= talktime * 0.2;
            AvailableBalance += (talktime * 0.2)-(talktime*0.2*sale);
            talktime = 0;
        }
        
        if(sms<0){
            extraPrice-= sms * 0.2;
            AvailableBalance += (sms * 0.2) - (sms*0.2*sale);
            sms = 0;
        }

        System.out.println("Update completed");
    }



    public void creditAccount(int amountOfCredit){
        AvailableBalance += amountOfCredit;
    }

    public void getInvoice(){
        System.out.println("Plan price: " + (price-price*sale) + "\n" +
                           "Total price with sale(25%): " + ((price+extraPrice) - ((price+extraPrice)*sale)+fixedfee));
    }
    
    public void getFree(){
        switch(planChoice){
            case 1:
                if(talktime <= 1500 && sms<=50)
                    {freeTalk = 0;freeSMS=0;}
                else if (sms<=50)
                    {freeSMS=0;freeTalk=talktime-1500;}
                else if (talktime<=1500)
                    {freeSMS = sms - 50;freeTalk=0;}
                else 
                    {freeTalk=talktime-1500;freeSMS = sms - 50;}
                break;

            case 2:
                if(talktime <= 3200 && sms<=100)
                    {freeTalk = 0;freeSMS=0;}
                else if (sms<=100)
                    {freeSMS=0;freeTalk=talktime-3200;}
                else if (talktime<=3200)
                    {freeSMS = sms - 100;freeTalk=0;}
                else 
                    {freeTalk=talktime-3200;freeSMS = sms - 100;}
                break;
            
            case 3:
                if(talktime <= 7000 && sms<=150)
                    {freeTalk = 0;freeSMS=0;}
                else if (sms<=150)
                    {freeSMS=0;freeTalk=talktime-7000;}
                else if (talktime<=7000)
                    {freeSMS = sms - 150;freeTalk=0;}
                else 
                    {freeTalk=talktime-7000;freeSMS = sms - 150;}
                break;
        }
    }



    public String toString(){
        return "Service Type: Card Contract Program " + planChoice + "\n" +
        super.toString() + 
        "/n"+"Talk time and SMS left: " + talktime+ "min talktime and " + sms + "SMS\n"+
        "Available Balance : " + AvailableBalance;
    }
}