package AlarmTask;

interface Alarm {
    void turnAlarmOn();
    void turnAlarmOff();
}

interface Vehicle {
    void getBrand();
    void speedUp();
    void slowDown();
}

class Car implements Alarm,Vehicle {
    public static void main(String args[]){

    }
    public void turnAlarmOn(){
        System.out.println("Alarm is turned ON");
    }
    public void turnAlarmOff(){
        System.out.println("Alarm is turned OFF");
    }
    public void getBrand(){
    }
    public void speedUp(){
    }
    public void slowDown(){
    }
}
