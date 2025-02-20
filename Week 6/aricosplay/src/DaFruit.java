public class DaFruit implements Comparable<DaFruit> {

    private double fruitprice;
    private String fruitname;

    public DaFruit(double fruitprice, String fruitname){
        this.fruitprice = fruitprice;
        this.fruitname = fruitname;
    }

    public double getPrice(){return fruitprice;}
    public void setPrice(int newPrice){this.fruitprice = newPrice;}

    public String getName(){return fruitname;}
    public void setName(String newName){this.fruitname = newName;}

    @Override
    public int compareTo(DaFruit other){
        return (int) (this.fruitprice - other.getPrice());
    }

}
