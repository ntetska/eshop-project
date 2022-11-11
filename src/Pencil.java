public class Pencil extends Item {
    private double tipSize;
    private String type ;
    private static int noOfObjects = 0;

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

    public Pencil(){

        noOfObjects++;

    }

    public String getDetails(){
        return "Tip size:"+getTipSize()+"mm"+"\nType:"+getType();
    }

    public static int getNoOfObjects(){
        return noOfObjects;
    }

}
