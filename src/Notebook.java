public class Notebook extends Item{
    private int sections;

    private static int noOfObjects = 0;

    public void setSections(int s){
        this.sections = s;
    }

    public int getSections(){
        return sections;
    }

    public Notebook(){

        noOfObjects++;
    }

    public static int getNoOfObjects(){
        return noOfObjects;
    }

    public String getDetails(){
        return "Sections:"+getSections();
    }
}
