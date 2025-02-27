public enum Bills {
    Penny(0.01),
    Quarter(0.05),
    Dollar(1),
    Fiver(5),
    Tenner(10),
    Twenty(20);

    private double amount;
    
    public double getamount(){return this.amount;}

    private Bills(double amount){
    }
}


