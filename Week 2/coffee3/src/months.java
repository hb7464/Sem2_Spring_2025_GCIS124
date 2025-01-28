public enum months {
    January(31),
    February(28),
    March(31),
    April(30),
    May(31),
    June(30),
    July(31),
    August(31),
    September(30),
    October(31),
    November(30),
    December(31);
    
    @SuppressWarnings("FieldMayBeFinal")
    private int days;

    public int getdays(){
        return this.days;
    }

    private months(int givendays){
        this.days = givendays;
    }


}
