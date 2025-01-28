public class student {

    @SuppressWarnings("FieldMayBeFinal")
    private String name;
    @SuppressWarnings("FieldMayBeFinal")
    private String LastName;
    @SuppressWarnings("FieldMayBeFinal")
    private int ID;
    @SuppressWarnings("FieldMayBeFinal")
    private anothergrade grade;

    public String getname(){
        return this.name;
    }
    
    public String getlastname(){
        return this.LastName;
    }

    public int getid(){
        return this.ID;
    }

    public anothergrade getgrade(){
        return this.grade;
    }

    @Override
    public String toString(){
        return this.getname() + " " + this.getlastname() + " " + this.getid() + " " + this.getgrade();
    }


    public student(String inpname, String inplastname, int inpID, anothergrade inpGrading){

        this.name = inpname;
        this.LastName = inplastname;
        this.ID = inpID;
        this.grade = inpGrading;

    }
    
}
