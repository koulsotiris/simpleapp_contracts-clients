/*
Names: Michalis Kyriakou(p3200228) and Sotirios-Panagiotis Koulouridis(p3200082)
Omada: 31
*/

import java.util.*;
import java.io.*;

class mainApp{
    public static ArrayList<Contract> Contracts = new ArrayList<Contract>();
    public static ArrayList<Services> allServices = new ArrayList<Services>();
    
    public static void writeFile(){
        System.out.println("Writing File...\n");

        BufferedWriter writer = null;

        try {
            writer = new BufferedWriter(new FileWriter("writeContracts.txt"));
            writer.write("CONTRACT_LIST\n{\n");
            for(Contract obj:Contracts){
                if(obj instanceof MobileInternet){
                    MobileInternet client = (MobileInternet) obj;
                    writer.write("\tCONTRACT\n\t{\n");
                    writer.write("\t\tPASSCODE " + client.passcode + "\n");
                    writer.write("\t\tTYPE Mobile Internet " + client.planChoice + "\n");
                    writer.write("\t\tNAME " + client.name + "\n");
                    writer.write("\t\tPHONE NUMBER " + client.phoneNumber + "\n");
                    writer.write("\t\tACTIVATION DATE " + client.activationDate + "\n" );
                    writer.write("\t\tUSAGE_INFO\n\t\t{\n");
                    writer.write("\t\t\tDATA_LEFT " + client.mobileData + "\n\t\t}\n");
                    writer.write("\t}\n");
                }

                else if(obj instanceof CardContractProgram){
                    CardContractProgram client = (CardContractProgram) obj;
                    writer.write("\tCONTRACT\n\t\t{\n");
                    writer.write("\t\tPASSCODE " + client.passcode + "\n");
                    writer.write("\t\tTYPE Card Program " + client.planChoice + "\n");
                    writer.write("\t\tNAME " + client.name + "\n");
                    writer.write("\t\tPHONE NUMBER " + client.phoneNumber + "\n");
                    writer.write("\t\tACTIVATION DATE " + client.activationDate + "\n" );
                    writer.write("\t\tUSAGE_INFO\n\t\t{\n");
                    writer.write("\t\t\tMINUTES_LEFT " + client.talktime + "\n");
                    writer.write("\t\t\tSMS_LEFT " + client.sms + "\n");
                    writer.write("\t\t\tAVAILABLE_BALANCE " + client.AvailableBalance + "\n\t\t}\n");
                    writer.write("\t}\n");
                }

                else if(obj instanceof ContractProgram){
                    ContractProgram client = (ContractProgram) obj;
                    writer.write("\tCONTRACT\n\t{\n");
                    writer.write("\t\tPASSCODE " + client.passcode + "\n");
                    writer.write("\t\tTYPE Contract Program " + client.planChoice + "\n");
                    writer.write("\t\tNAME " + client.name + "\n");
                    writer.write("\t\tPHONE NUMBER " + client.phoneNumber + "\n");
                    writer.write("\t\tACTIVATION DATE " + client.activationDate + "\n" );
                    writer.write("\t\tUSAGE_INFO\n\t\t{\n");
                    writer.write("\t\t\tMINUTES_LEFT " + client.talktime + "\n");
                    writer.write("\t\t\tSMS_LEFT " + client.sms + "\n\t\t}\n");
                    writer.write("\t}\n");
                }
            }
            writer.write("}");
            writer.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }

        System.out.println("File written succesfully!\n");
    }// writefile

	public static void ReadContracts(){
		System.out.println("Reading the Contracts file...");
        String name="0",phone_number="0",activation_date="0";
        int smsleft=0,minleft=0,passcode=0,data=0,plan=0;
        int a=0,b=0,c=0,d=0,f=0,g=0;
        double balance=0;
		BufferedReader reader = null;
        Contract contract=null;
        String line;
		
        try {
			reader = new BufferedReader(new FileReader("readContracts.txt"));
            line = reader.readLine();
            line = reader.readLine();
            line = reader.readLine();

            while ((line != null) && (line.trim().equals("}"))==false) {
                a=0;b=0;c=0;d=0;f=0;g=0;
                if (line.trim().toUpperCase().equals("CONTRACT")) {
                    line = reader.readLine();
    
                    if (line.trim().equals("{")) {
                        line = reader.readLine();
                        while (((a+b+c+d+g+f)<6) && ((line.trim().toUpperCase().equals("CONTRACT"))==false) && (line.trim().equals("}"))==false){
                                if (line.trim().toUpperCase().startsWith("PASSCODE ")){
                                    passcode=(Integer.parseInt(line.substring(10).trim()));
                                    f=1;
                                    line = reader.readLine();}//passcode
                                if (line.trim().toUpperCase().startsWith("TYPE ")) {
                                    plan=(Integer.parseInt(line.substring(line.length()-1).trim()));
                                    if (line.trim().substring(5).trim().toUpperCase().startsWith("MOBILE INTERNET")) 
                                        contract=new MobileInternet();
                                    if (line.trim().substring(5).trim().toUpperCase().startsWith("CARD PROGRAM")) 
                                        contract=new CardContractProgram();
                                    if (line.trim().substring(5).trim().toUpperCase().startsWith("CONTRACT PROGRAM"))
                                        contract=new ContractProgram();
                                    a=1;
                                    line = reader.readLine();}//type
                                if (line.trim().toUpperCase().startsWith("NAME ")){
                                    name=(line.substring(5).trim());
                                    b=1;
                                    line = reader.readLine();}//name
                                if (line.trim().toUpperCase().startsWith("PHONE NUMBER ")){
                
                                    phone_number=(line.trim().substring(13).trim());
                                    c=1;
                                    line = reader.readLine();}//phonenumber
                                if (line.trim().toUpperCase().startsWith("ACTIVATION DATE ")){
                
                                    activation_date=(line.substring(16).trim());
                                d=1;
                                line = reader.readLine();}
                                if (line.trim().toUpperCase().startsWith("USAGE_INFO")){
                    
                                    line = reader.readLine();
                    
                                    if (line.trim().equals("{")) {
                                        line = reader.readLine();
                                        if (line.trim().toUpperCase().startsWith("DATA_LEFT ")) {
                                            data=(Integer.parseInt(line.substring(12).trim()));
                                            line=reader.readLine();
                                            if (line.trim().equals("}")){
                                                line = reader.readLine();}}
                                        if (line.trim().toUpperCase().startsWith("MINUTES_LEFT ")) {
                                            minleft=(Integer.parseInt(line.substring(15).trim()));
                                            line=reader.readLine();
                                            if (line.trim().equals("}")) 
                                                line = reader.readLine();}
                                        if (line.trim().toUpperCase().startsWith("SMS_LEFT ")) {
                                            smsleft=(Integer.parseInt(line.substring(11).trim()));
                                            line=reader.readLine();
                                            if (line.trim().equals("}")){ 
                                                line = reader.readLine();}}
                                        if (line.trim().toUpperCase().startsWith("AVAILABLE_BALANCE ")) {
                                            balance=(Double.parseDouble(line.substring(19).trim()));
                                            line=reader.readLine();
                                            if (line.trim().equals("}")) 
                                                line = reader.readLine();}}
                                        g=1;}//usage info
                                    if ((line.trim().toUpperCase().startsWith("PASSCODE "))==false && (line.trim().toUpperCase().startsWith("TYPE "))==false && (line.trim().toUpperCase().startsWith("NAME "))==false && (line.trim().toUpperCase().startsWith("CONTRACT "))==false
                                    && (line.trim().toUpperCase().startsWith("PHONE NUMBER "))==false && (line.trim().toUpperCase().startsWith("ACTIVATION DATE "))==false && (line.trim().toUpperCase().startsWith("USAGE_INFO"))==false
                                    && (line.trim().startsWith("}"))==false && (line.trim().startsWith("{"))==false)
                                        line = reader.readLine();
                                    }//while a+b+c+d+g+f
                if (contract instanceof MobileInternet){
                    ((MobileInternet)contract).planChoice=plan;
                    ((MobileInternet)contract).passcode=passcode;
                    ((MobileInternet)contract).name=name;
                    ((MobileInternet)contract).phoneNumber=phone_number;
                    ((MobileInternet)contract).activationDate=activation_date;
                    ((MobileInternet)contract).mobileData=data; }
                else if (contract instanceof ContractProgram){
                    ((ContractProgram)contract).planChoice=plan;
                    ((ContractProgram)contract).passcode=passcode;
                    ((ContractProgram)contract).name=name;
                    ((ContractProgram)contract).phoneNumber=phone_number;
                    ((ContractProgram)contract).sms=smsleft;
                    ((ContractProgram)contract).talktime=minleft;
                    ((ContractProgram)contract).activationDate=activation_date;}
                else if (contract instanceof CardContractProgram){
                    ((CardContractProgram)contract).planChoice=plan;
                    ((CardContractProgram)contract).passcode=passcode;
                    ((CardContractProgram)contract).name=name;
                    ((CardContractProgram)contract).phoneNumber=phone_number;
                    ((CardContractProgram)contract).sms=smsleft;
                    ((CardContractProgram)contract).talktime=minleft;
                    ((CardContractProgram)contract).activationDate=activation_date;
                    ((CardContractProgram)contract).AvailableBalance=balance;}
                }//if "{"
                if ((f==1) && (a==1) && (d==1))
                    Contracts.add(contract);
                else
                    System.out.println("\nIncorrect or incomplete data read. The output will not take this data into account. ");
                line=reader.readLine();
            
            
            } // Contract 
            else {
                line=reader.readLine();}
                
                } //while
				reader.close();
			}//try
            catch (IOException e) {
                System.out.println	("Error reading line ...");
            }//catch
		} //Readfile


    
    public static void ReadServices(){
        int price = 0, minutes = 0, sms = 0, data = 0;
        String line = null, type = "";
        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader("readServices.txt"));

            line = reader.readLine();

            if(line != null){
                while(line != null){
                    if(line.trim().toUpperCase().startsWith("SERVICE"))
                    while(line.trim().startsWith("}") == false){

                        if(line.trim().toUpperCase().startsWith("TYPE"))
                            type = line.trim().substring(5);
                        

                        else if(line.trim().toUpperCase().startsWith("PRICE"))
                            price =Integer.parseInt(line.trim().substring(6));
                        

                        else if(line.trim().toUpperCase().startsWith("MINUTES"))
                            minutes = Integer.parseInt(line.trim().substring(8));
                        

                        else if(line.trim().toUpperCase().startsWith("SMS"))
                            sms = Integer.parseInt(line.trim().substring(4));
                        

                        else if(line.trim().toUpperCase().startsWith("DATA"))
                            data = Integer.parseInt(line.trim().substring(5));

                        line = reader.readLine(); 
                        if(line == null) break;
                    }

                    Services service = new Services(type, price, data, minutes, sms);

                    if(allServices.size() < 9) allServices.add(service);

                    line = reader.readLine();
                }
            }
            reader.close();
        } 
        catch (Exception e) {
            System.err.println(e);
            System.out.println("error while reading services");
        }
    }
    
    

    
    public static void main(String args[]){ 
        
        boolean mainWhile = true;
        Scanner input = new Scanner(System.in);
        int option, option2, option3, option4, option5, inputPasscode_1, inputPasscode_2, inputPasscode_3 , talktimeUsage_1, talktimeUsage_2, smsUsage_1, smsUsage_2, dataUsage;
        
        ReadContracts();
        //Main.PrintList();

        ReadServices();

        while(mainWhile){

            System.out.print("\n1. Show all services \n2. New Contract \n3. Show Contracts \n4. Update contracts usage information \n5. Show Invoice \n0.Exit \n>");
            option = input.nextInt();
            System.out.println();
            

            switch(option){
                case 0:
                    mainWhile = false; 

                    writeFile();
                    
                        
                    System.out.println("Closing program..."); break;
                
                case 1:
                    for(Services service : allServices){
                        System.out.println(service);
                        System.out.println();
                    }
                    
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
                            client1.Sign();
                            System.out.println("Contract created succesfully");
                            System.out.println(client1);
                            System.out.println();

                            Contracts.add(client1);

                            break;
                        
                        case 2:
                            Contract client2 = new ContractProgram();
                            client2.Sign();
                            System.out.println("Contract created succesfully");
                            System.out.println(client2);
                            System.out.println();

                            Contracts.add(client2);

                            break;
                        
                        case 3:
                            Contract client3 = new CardContractProgram();
                            client3.Sign();
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
                                    MobileInternet downcast_contract = ((MobileInternet)contract);
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
                                    ContractProgram downcast_contract = ((ContractProgram)contract);
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
                                    MobileInternet downcast_contract = ((MobileInternet)contract);
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
                                    ContractProgram downcast_contract = ((ContractProgram)contract);
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
            }//switch(option)
        }//while
    }//main
} //class