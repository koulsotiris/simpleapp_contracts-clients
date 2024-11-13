/*
Names: Michalis Kyriakou(p3200228) and Sotirios-Panagiotis Koulouridis(p3200082)
Omada: 31
*/

import java.util.Scanner;
import java.util.ArrayList;

class mainApp{                                             
    public static void main(String args[]){ 
        boolean mainWhile = true;
        Scanner input = new Scanner(System.in);
        int option, option2, option3, option4, option5, inputPasscode_1, inputPasscode_2, inputPasscode_3 , talktimeUsage_1, talktimeUsage_2, smsUsage_1, smsUsage_2, dataUsage;
        ArrayList<Contract> Contracts = new ArrayList<Contract>();
        ArrayList<Services> allServices = new ArrayList<Services>();
        
        allServices.add(new Services(1));
        allServices.add(new Services(2));
        allServices.add(new Services(3));


        while(mainWhile){

            System.out.print("\n1. Show all services \n2. New Contract \n3. Show Contracts \n4. Update contracts usage information \n5. Show Invoice \n0.Exit \n>");
            option = input.nextInt();
            System.out.println();


            switch(option){
                case 0:
                    mainWhile = false; 
                    System.out.println("Closing program..."); break;
                
                case 1:
                    for(Services service : allServices)
                        System.out.println(service);
                    
                    break;

                case 2: 
                    System.out.print("Choose Plan: \n1. Mobile Internet \n2. Mobile Services with Plan \n3. Mobile Services with Card \n0. Back \n>");
                    option2 = input.nextInt();
                    System.out.println();

                    switch(option2){
                        case 0: 
                            break;
                        case 1:
                            Contract client1 = new MobileInternet();

                            System.out.println("Contract created succesfully");
                            System.out.println(client1);
                            System.out.println();

                            Contracts.add(client1);

                            break;
                        
                        case 2:
                            Contract client2 = new ContractProgram();

                            System.out.println("Contract created succesfully");
                            System.out.println(client2);
                            System.out.println();

                            Contracts.add(client2);

                            break;
                        
                        case 3:
                            Contract client3 = new CardContractProgram();

                            System.out.println("Contract created succesfully");
                            System.out.println(client3);
                            System.out.println();

                            Contracts.add(client3);

                            break;



                        default: System.out.println(option2); System.out.println("Wrong input."); 
                        
                    }//switch(option2)

                    break;
                
                case 3:
                    System.out.print("Choose contract type: \n1. Mobile Internet \n2. Mobile Services with Plan \n3. Mobile Services with Card \n0. Back \n>");
                    option3 = input.nextInt();
                    System.out.println();

                    switch(option3){
                        case 0:
                            break;

                        case 1:
                            for(Contract contract : Contracts)
                                if (contract instanceof MobileInternet){
                                    System.out.println(contract);
                                    System.out.println();
                                }

                            break;
                        
                        case 2:
                        for(Contract contract : Contracts)
                            if (contract instanceof ContractProgram){
                                System.out.println(contract);
                                System.out.println();
                            }

                            break;
                        
                        case 3:
                        for(Contract contract : Contracts)
                            if (contract instanceof CardContractProgram){
                                System.out.println(contract);
                                System.out.println();
                            }

                            break;
                        
                        default:
                            System.out.println("Wrong input");

                    }//switch(option3)
                    
                    break;
                
                
                case 4:  
                    System.out.print("Contract type: \n1. Mobile Internet \n2. Mobile Services with Plan \n3. Mobile Services with Card \n0. Back \n>");
                    option4 = input.nextInt();
                    System.out.println();

                    switch (option4) {
                        case 1:
                            for(Contract contract : Contracts)
                                if (contract instanceof MobileInternet){
                                    System.out.println(contract);
                                    System.out.println();
                                }
                        
                            System.out.print("\nChoose contracts (type passcode): ");
                            inputPasscode_1 = input.nextInt();

                            System.out.print("\nEnter data used: ");
                            dataUsage = input.nextInt();

                            for(Contract contract : Contracts)
                                if (contract instanceof MobileInternet && contract.getPasscode() == inputPasscode_1){
                                    MobileInternet downcast_contract = (MobileInternet)contract;
                                    downcast_contract.updateData(dataUsage);
                                    break;
                                }

                            break;
                        
                        case 2:
                            for(Contract contract : Contracts)
                                if (contract instanceof ContractProgram){
                                    System.out.println(contract);
                                    System.out.println();
                                }    

                            System.out.print("\nChoose contracts (type passcode): ");
                            inputPasscode_2 = input.nextInt();

                            System.out.print("\nEnter talk time used: ");
                            talktimeUsage_1 = input.nextInt();

                            System.out.print("\nEnter sms used: ");
                            smsUsage_1 = input.nextInt();

                            for(Contract contract : Contracts)
                                if (contract instanceof ContractProgram && contract.getPasscode() == inputPasscode_2){
                                    ContractProgram downcast_contract = (ContractProgram)contract;
                                    downcast_contract.updatePrice(talktimeUsage_1, smsUsage_1);
                                    break;
                                }
                                
                            break;

                            case 3:
                                for(Contract contract : Contracts)
                                    if (contract instanceof CardContractProgram){
                                        System.out.println(contract);
                                        System.out.println();
                                    }

                                System.out.print("\nChoose contracts (type passcode): ");
                                inputPasscode_3 = input.nextInt();

                                System.out.print("\nEnter talk time used: ");
                                talktimeUsage_2 = input.nextInt();

                                System.out.print("\nEnter sms used: ");
                                smsUsage_2 = input.nextInt();

                                for(Contract contract : Contracts)
                                    if (contract instanceof CardContractProgram && contract.getPasscode() == inputPasscode_3){
                                        CardContractProgram downcast_contract = (CardContractProgram)contract;
                                        downcast_contract.updatePrice(talktimeUsage_2, smsUsage_2);
                                        break;
                                    }
                                    
                            break;                    

                    } //switch(option4)

                    break;
                
                case 5:
                    System.out.print("Contract type: \n1. Mobile Internet \n2. Mobile Services with Plan \n3. Mobile Services with Card \n0. Back \n>");
                    option5 = input.nextInt();
                    System.out.println();

                    switch(option5){
                        case 1:
                            for(Contract contract : Contracts)
                                if (contract instanceof MobileInternet){
                                    System.out.println(contract);
                                    System.out.println();
                                }

                            System.out.print("\nChoose contracts (type passcode): ");
                            inputPasscode_1 = input.nextInt();

                            for(Contract contract : Contracts)
                                if (contract instanceof MobileInternet && contract.getPasscode() == inputPasscode_1){
                                    MobileInternet downcast_contract = (MobileInternet)contract;
                                    downcast_contract.getInvoice();
                                    break;
                                }

                            break;
                        
                        case 2:
                            for(Contract contract : Contracts)
                                if (contract instanceof ContractProgram){
                                    System.out.println(contract);
                                    System.out.println();
                                }   

                            System.out.print("\nChoose contracts (type passcode): ");
                            inputPasscode_2 = input.nextInt();

                            for(Contract contract : Contracts)
                                if (contract instanceof ContractProgram && contract.getPasscode() == inputPasscode_2){
                                    ContractProgram downcast_contract = (ContractProgram)contract;
                                    downcast_contract.getInvoice();
                                    break;
                                }
            
                            break;
                        
                        case 3:
                            for(Contract contract : Contracts)
                                if (contract instanceof CardContractProgram){
                                    System.out.println(contract);
                                    System.out.println();
                                }

                            System.out.print("\nChoose contracts (type passcode): ");
                            inputPasscode_3 = input.nextInt();

                            for(Contract contract : Contracts)
                                    if (contract instanceof CardContractProgram && contract.getPasscode() == inputPasscode_3){
                                        CardContractProgram downcast_contract = (CardContractProgram)contract;
                                        downcast_contract.getInvoice();
                                        break;
                                    }

                    } //switch(option5)
            }//switch(option1)
        }//while
    }//main
} //class