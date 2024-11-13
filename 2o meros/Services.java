public class Services{
    protected int price = 0, data = 0, minutes = 0, sms = 0;
    protected String type;
  
    public Services(String type, int price, int data, int minutes, int sms){
        this.type = type;
        this.price = price;
        this.data = data;
        this.minutes = minutes;
        this.sms = sms;
    }

    public String toString(){
        
        if(type.toUpperCase().startsWith("MOBILEINTERNET"))
            return "SERVICE\n" +
                    "Type:  " + this.type + "\n" +
                    "Data:  " + this.data + "\n" +
                    "Price: " + this.price;

        else
            return "SERVICE\n" +
                "Type:    " + this.type + "\n" +
                "Minutes: " + this.minutes + "\n" +
                "SMS:     " + this.sms + "\n" +
                "Price:   " + this.price; 

    }

}