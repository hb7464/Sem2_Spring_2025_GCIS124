
public class student {

    @SuppressWarnings("FieldMayBeFinal")
    private String name;
    @SuppressWarnings("FieldMayBeFinal")
    private String LastName;
    @SuppressWarnings("FieldMayBeFinal")
    private int ID;

    public String getname(){
        return this.name;
    }
    
    public String getlastname(){
        return this.LastName;
    }

    public int getid(){
        return this.ID;
    }

    @SuppressWarnings("override")
    public String toString(){
        return this.getname() + " " + this.getlastname() + " " + this.getid();
    }


    public student(String inpname, String inplastname, int inpID){

        this.name = inpname;
        this.LastName = inplastname;
        this.ID = inpID;

    }
    
}
