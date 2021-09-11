package data.users;

import data.MedicalHistory;
import data.base.Person;
import data.base.Vaccine;
import data.vaccines.*;
import interfaces.onScheduleNextVisit;

import java.util.Date;

public class Client extends Person implements onScheduleNextVisit {

    private MedicalHistory medicalHistory;
    private Vaccine vaccine;
    private HealthCareProfessional assistedBy;

    public MedicalHistory getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(MedicalHistory medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public Vaccine getVaccine() {
        return vaccine;
    }

    public void setVaccine(Vaccine vaccine) {
        this.vaccine = vaccine;
    }

    public HealthCareProfessional getAssistedBy() {
        return assistedBy;
    }

    public void setAssistedBy(HealthCareProfessional assistedBy) {
        this.assistedBy = assistedBy;
    }

    @Override

    public String toString() {
      return  super.toString() + "\n\n" + medicalHistory.toString() + "\n"+ vaccine.toString()+ "\n"+ assistedBy.toString()+ "\n\n";
    }

    @Override
    public String computeAppointment(Date date) {
        if (this.vaccine == null) {
            throw new NullPointerException("Vaccine is not set.");
        }
        if (vaccine instanceof Pfizer) {
            return vaccine.computeAppointment(date);
        } else if(vaccine instanceof Moderna){
            return vaccine.computeAppointment(date);
        } else if(vaccine instanceof Sinovac){
            return vaccine.computeAppointment(date);
        }else if(vaccine instanceof AstraZeneca){
            return vaccine.computeAppointment(date);
        }else if(vaccine instanceof Jansen){
            // do not return value because vaccine requires one shot only.
            return null;
        }

        return null;
    }
}
