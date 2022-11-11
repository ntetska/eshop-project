public class Owner extends User {
    private boolean isAdmin = true;

    private int pin;

    public Owner(){
    }

    public void setPin(int p){
        this.pin = p;
    }

    public int getPin(){
        return pin;
    }

}
