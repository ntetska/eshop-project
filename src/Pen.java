import java.util.Arrays;

public class Pen extends Item {
    private String color;
    private double tipSize;
    private String type;

    public void setTipSize(double t){
        this.tipSize = t;
    }

    public double getTipSize(){
        return tipSize;
    }

    public void setType (String t){
        this.type = t;
    }

    public String getType(){
        return type;
    }

    public void setColor(String c){
        this.color = c;
    }

    public String getColor(){
        return color;
    }

    private static int noOfObjects = 0;

    public Pen(){

        noOfObjects++;

    }

    public static int getNoOfObjects() {
        return noOfObjects;
    }

    public String getDetails(){
        return "Color:"+getColor()+"\nTip size:"+getTipSize()+"mm"+"\nType:"+getType();
    }
}
