package hei.springboottd.entity;


public class Student {
    private String reference;
    private String FirstName;
    private String LastName;
    private int name;

    public Student(String reference, String firstName, String lastName, int name) {
        this.reference = reference;
        FirstName = firstName;
        LastName = lastName;
        this.name = name;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }
}
