import java.util.Scanner;

//The sum of code lines is: 1255

public class Main {

    public static void main(String[] args) {
        Menu m = new Menu();
        EShop eshop = new EShop();

        //create buyers
        eshop.createBuyer("James Dingo", "james@gmail.com", 100);
        eshop.createBuyer("John Via", "john@gmail.com", 200);

        //create owner of shop
        eshop.createOwner("Tisa Jameson", "tisa@gmail.com",4562);

        //--------------------------add items--------------------------//

              //Pen Items
        eshop.addPenProduct("Case De Pipe", 1.75,"A really well pen and you can draw on any surface!",10,"Black",0.02,"None");
        eshop.addPenProduct("Fabbo Castle",3.40,"The most expensive but hand-made pen!",4,"Red",0.05,"None");
        eshop.addPenProduct("Pen Mania",0.54,"Pen Mania pen fits on any surface!",10,"Blue",0.03,"None");

             //Pencil Items
        eshop.addPencilProduct("Fave Orange",0.58,"One of the most famous pencils, with unlimited drawing",15,0.02,"H");
        eshop.addPencilProduct("Biggo",0.90,"Biggo pencil is a really well made",6,0.06,"HB");
        eshop.addPencilProduct("Fabberino",1,"Fabberino pencil is here for you to draw your dreams!",20,0.03,"B");
        eshop.addPencilProduct("Shered",3,"Shered pencil has good quality and it fits for everyone!",15,0.01,"H");

            //Notebook Items
        eshop.addNotebookProduct("Read Lovers",3.45,"The best notebook out there, with 4 sections for unlimited writing",20,4);
        eshop.addNotebookProduct("Greco",2,"Greco notebook for unlimited writing",10,5);
        eshop.addNotebookProduct("Inspiration",3.45,"The inspiration is the best notebook out there, for unlimited writing",20,2);

            //Paper Items
        eshop.addPaperProduct("Link A4",6,"The Link A4 paper is here for you to do every homework you got!",60,80,500);
        eshop.addPaperProduct("Lines",5,"The Line B4 paper is actually the best for drawing",60,100,600);
        eshop.addPaperProduct("Di Kika",10,"The Di Kika A4 paper is here for you not only to do your exercises but to do good to environment",60,150,800);
        eshop.addPaperProduct("Duplica",15,"The Duplica B3 paper is made of bamboo",65,250,1000);
        eshop.addPaperProduct("Shroud",4,"The Shroud A4 paper is made of love for the consumers!",40,300,1200);

        //The Entry
        System.out.println("------Hello sir/ma'am, insert your email------");
        m.identification(eshop);
    }
}
