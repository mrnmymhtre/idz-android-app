package com.example.idz;

public class EntryModal {


    private String Name;
    private String Email;
    private String Dob;
    private int id;


    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getDob() {
        return Dob;
    }

    public void setDob(String Dob) {
        this.Dob = Dob;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public EntryModal(String string, String Name, String Email, String Dob) {
        this.Name = Name;
        this.Email = Email;
        this.Dob = Dob;
    }
}
