import java.util.*;

interface SmartDevice{
    void turnOn();
    void turnOff();
}
class SmartFan implements SmartDevice{
    public void turnOn(){
        System.out.println("Smart Fan is turned ON");
    }
    public void turnOff(){
        System.out.println("Smart Fan is turned OFF");
    }
}
class SmartLight implements SmartDevice{
    public void turnOn(){
        System.out.println("Smart Light is turned ON");
    }
    public void turnOff(){
        System.out.println("Smart Light is turned OFF");
    }
}
class SmartAC implements SmartDevice{
    public void turnOn(){
        System.out.println("Smart AC is turned ON");
    }
    public void turnOff(){
        System.out.println("Smart AC is turned OFF");
    }
}
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        SmartDevice device;
        int choice1=10;
        while(choice1!=0){
            System.out.println("1. Light 2. Fan 3. AC");
            choice1=sc.nextInt();
            int choice2;
            switch(choice1){
                case 1:
                    device=new SmartLight();
                    System.out.println("Light: 0:OFF | 1:ON");
                    choice2=sc.nextInt();
                    if(choice2==0){
                        device.turnOff();
                    }
                    else if(choice2==1){
                        device.turnOn();
                    }
                    else{
                        System.out.println("Invalid Input");
                    }
                    break;
                case 2:
                    
                    device=new SmartFan();
                    System.out.println("FAN: 0:OFF | 1:ON");
                    choice2=sc.nextInt();
                    if(choice2==0){
                        device.turnOff();
                    }
                    else if(choice2==1){
                        device.turnOn();
                    }
                    else{
                        System.out.println("Invalid Input");
                    }
                    break;
                case 3:
                    device=new SmartAC();
                    System.out.println("AC: 0:OFF | 1:ON");
                    choice2=sc.nextInt();
                    if(choice2==0){
                        device.turnOff();
                    }
                    else if(choice2==1){
                        device.turnOn();
                    }
                    else{
                        System.out.println("Invalid Input");
                    }
                    break;
                default:
                    System.out.println("Invalid Choice!");
            }
            
        }
    }
    
}
