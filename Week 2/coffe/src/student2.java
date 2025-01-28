public class student2 {

    @SuppressWarnings("FieldMayBeFinal")
    private String name;
    @SuppressWarnings("FieldMayBeFinal")
    private String LastName;
    @SuppressWarnings("FieldMayBeFinal")
    private int ID;
    @SuppressWarnings("FieldMayBeFinal")
    private Grading grade;

    public String getname(){
        return this.name;
    }
    
    public String getlastname(){
        return this.LastName;
    }

    public int getid(){
        return this.ID;
    }

    public Grading getgrade(){
        return this.grade;
    }

    @Override
    public String toString(){
        return this.getname() + " " + this.getlastname() + " " + this.getid() + " " + this.getgrade();
    }


    public student2(String inpname, String inplastname, int inpID, Grading inpGrading){

        this.name = inpname;
        this.LastName = inplastname;
        this.ID = inpID;
        this.grade = inpGrading;

    }
    
}

//create enumeration that represents month, with one attribute number of days
