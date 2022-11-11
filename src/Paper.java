public class Paper extends Item {
    private int weight;
    private int pages;

    public void setWeight(int w){
        this.weight = w;
    }

    public int getWeight(){
        return weight;
    }

    public void setPages(int s){
        this.pages = s;
    }

    public int getPages(){
        return pages;
    }

    private static int noOfObjects = 0;

    public Paper(){
        noOfObjects++;
    }

    public String getDetails(){
        return "Weight:"+getWeight()+"gr"+"\nPages:"+getPages();
    }

    public static int getNoOfObjects(){
        return noOfObjects;
    }
}
