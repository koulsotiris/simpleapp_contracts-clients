import java.util.Scanner;

public class Mobile extends Contract{
    protected int talktime = 100,sms=100;
    protected double extraPrice=0;
    
    
    public Mobile(){
        super();

    }

    
    public void updateProgram(int talktime_usage, int sms_usage){
        talktime -= talktime_usage;
        sms -= sms_usage;
    }


    public String toString(){
        return super.toString();

    }
}