import java.util.Scanner;

public class MobileInternet extends Contract{
    protected int mobileData = 500, planChoice, freeData;
    protected double sale = 0.3, price, extraPrice = 0;
    
    
    public MobileInternet(){
        super();
        contract=1;

        Scanner input = new Scanner(System.in);

        System.out.println("Choose Plan:");
        MobileInternet.showPlans();
        System.out.print(">");
        planChoice = input.nextInt();
        System.out.println();
        
        switch(planChoice){
            case 1: mobileData += 10000; price = 10; break;
            case 2: mobileData += 15000; price = 15; break;
            case 3: mobileData += 20000; price = 20; break;
            default: break;
        }

        System.out.println();

        System.out.println("Your passcode is " + passcode);
        System.out.println();
    }

    public void updateData(int use){
        mobileData -= use;

        if(mobileData<0){
            extraPrice += mobileData*(-0.2);
            mobileData = 0;
            }

        System.out.println("update completed");

    }

    public static void showPlans(){
        System.out.println("1) 10gbs for 10euro / month now only " +(10-10*0.3) +"\n2) 15gbs for 15euro / month now only " +(15-15*0.3) +"\n3) 20gbs for 20euro / month now only " +(20-20*0.3) +"\n*all three plans include 500mbs free data!" );
    }


    public void getInvoice(){
        System.out.println("Contract: " + (price-price*sale) + "\n" +
                           "Overuse price: " + (extraPrice-extraPrice*sale) + "\n" +
                           "Total with 30% off: " + (((price+extraPrice)-(price + extraPrice)*sale)+fixedfee));
    }

    public void getFree(){
        switch(planChoice){
            case 1:
                if(mobileData < 10000)
                    freeData = 0;
                else
                    freeData = mobileData - 10000;
                
                break;

            case 2:
                if(mobileData < 15000)
                    freeData = 0;
                else
                    freeData = mobileData - 15000;
                
                break;
            
            case 3:
                if(mobileData < 20000)
                    freeData = 0;
                else
                    freeData = mobileData - 20000;
                
                break;
               
        }

        System.out.println("Free data left: " + freeData + " mbs");
    }

    public String toString(){
        return "Contract Type: Mobile Internet " + planChoice + "\n" +
                super.toString() + "\n" + 
                "Internet Left:  " + mobileData + "mbs";
    }
}