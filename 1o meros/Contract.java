import java.util.Scanner;

public class Contract{                                                            
    protected String name, phoneNumber, paymentMethod, activationDate;
    protected static int counter = 1,fixedfee=1;
    protected int passcode, paymentMethodChoice,contract;
    
    public Contract(){
        Scanner input = new Scanner(System.in);

        System.out.print("Name: ");
        name = input.nextLine();
        System.out.println();

        System.out.print("Phone number: ");
        phoneNumber = input.next();
        System.out.println();

        System.out.print("How are you going to pay? \n1. Cash \n2. Card \n>");
        paymentMethodChoice = input.nextInt();
        System.out.println();
        if(paymentMethodChoice == 1) paymentMethod = "Cash";
        else paymentMethod = "Card";

        System.out.print("Date? ");
        activationDate = input.next();
        System.out.println();

        passcode = counter;
        counter++;
        System.out.println("Your passcode is: " + passcode + "\n");
    }


    public int getPasscode(){
        return passcode;
    }

    public String toString(){
        return  "Full Name:      " + name + "\n" +
                "Phone Number:   " + phoneNumber + "\n" +
                "Date Activated: " + activationDate + "\n" +
                "Payment Method: " + paymentMethod;
    }
    
}