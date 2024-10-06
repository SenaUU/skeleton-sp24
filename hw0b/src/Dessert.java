public class Dessert {
    public int flavor;
    public int price;
    public static int numDesserts;

    public Dessert(int flavor, int price) {
        this.flavor = flavor;
        this.price = price;
        numDesserts++;
    }

    public void printDessert(){
        System.out.print(this.flavor);
        System.out.print(this.price);
        System.out.print(numDesserts);
    }

    public static void main(String[] args){
        System.out.println("I love dessert!");
    }

}