public enum anothergrade {
    A(94,100,"Excellent"),
    B(80,93,"very good"),
    C(70,79,"Good"),
    D(60,69,"Sufficient"),
    F(0,59,"FAIL");
    
    @SuppressWarnings("FieldMayBeFinal")
    private int mini;
    @SuppressWarnings("FieldMayBeFinal")
    private int maxi;
    @SuppressWarnings("FieldMayBeFinal")
    private String desc;

    public int getmini(){
        return this.mini;
    }
    
    public int getmaxi(){
        return this.maxi;
    }
    
    public String desc(){
        return this.desc;
    }

    private anothergrade(int cmini, int cmaxi, String cdesc) {

        this.desc = cdesc;
        this.mini = cmini;
        this.maxi = cmaxi;

    }
}
