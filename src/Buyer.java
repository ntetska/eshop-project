import java.util.Map;

public class Buyer extends User {
    private static ShoppingCart cart = new ShoppingCart();
    private Item item = new Item();
    private int bonus;
    private final String[] buyerCategory = {"BRONZE", "SILVER", "GOLD"};
    public boolean isBuyer = false;
    static boolean isGold = false;
    static boolean isSilver = false;
    static boolean isBronze = false;

    public void setBonus(int b){
       bonus = b;
    }

    public int getBonus(){
        return bonus;
    }

    public void BuyerCategory(){
        if(bonus>=0&&bonus<100){
            System.out.println("Category:"+buyerCategory[0]);
            isBronze = true;

        }else if(bonus>=100&&bonus<200){
            System.out.println("Category:"+buyerCategory[1]);
            isSilver = true;
        }else if(bonus >= 200)
        {
            System.out.println("Category:"+buyerCategory[2]);
            isGold = true;
        }
    }

    public Buyer(){
    }

    public void awardBonus(int b){
            setBonus(bonus + b);
    }

    public static void placeOrder(Item item){
        cart.addItemOrdered(item);
    }
}
