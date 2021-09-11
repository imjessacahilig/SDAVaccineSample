package data.base;

import data.Address;
import data.MedicalHistory;
import data.base.Vaccine;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

public class Person {
    private int personId;
    private String lastName;
    private String firstName;
    private String middleName;
   /* private Date birthday;*/
    private String address;

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

  /*  public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        try {

            this.birthday = DateFormat.getInstance().parse(birthday);
        } catch (Exception e) {
            System.out.println("Invalid value");
        }

    }*/

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return lastName + ',' + firstName + ' ' + middleName;
    }
}
