package data.users;

import data.base.Person;

public class HealthCareProfessional extends Person {

    private String licenseNo;

    public String getLicenseNo() {
        return licenseNo;
    }

    public void setLicenseNo(String licenseNo) {
        this.licenseNo = licenseNo;
    }

    @Override
    public String toString() {

        return "Assisted By:" + super.toString() +
                " licenseNo='" + licenseNo + '\'';
    }
}
