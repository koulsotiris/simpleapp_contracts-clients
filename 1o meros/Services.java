public class Services{
    private int choice;

    public Services(int choose){
        choice = choose;
    }

    public String toString(){
        String output;
        switch(choice){
            case 1:
                output = "Mobile Internet:      1) 10gb -from 10euro now only "+(10-10*0.3)   +"     2) 15gb -from 15euro now only "+ (15-15*0.3)   +"     3) 20gb -from 20euro now only "+ (20-20*0.3);
                break;
            
            case 2:
                output = "Mobile Plan Services: 1) 150min and sms -from 7euro  now only "+(7-7*0.2)   +"     2) 300 min and sms -from 10euro now only "+(10-10*0.2)   +"     3) 1000 min and sms -from 13euro now only "+(13-13*0.2);
                break;
            
            case 3:
                output = "Mobile Card Services: 1) 1500 min talk & 50 SMS -from 10euro now only "+ (10-10*0.25)+"     2) 3200 min talk & 100 SMS -from 15euro now only "+(15-15*0.25) +"     3) 7000 min talk & 150 SMS -from 20euro now only "+(20-20*0.25);
                break;

            default:
                output = "Error";
        }

        return output;
    }

}