package data;

public class MedicalHistory {

    private boolean withCommorbidies;
    private boolean withFoodAllergy;
    private boolean withMedicationAllergy;

    @Override
    public String toString() {
        return "MedicalHistory: " +
                "withCommorbidies=" + withCommorbidies +
                ", withFoodAllergy=" + withFoodAllergy +
                ", withMedicationAllergy=" + withMedicationAllergy;
    }

    public boolean isWithCommorbidies() {
        return withCommorbidies;
    }

    public void setWithCommorbidies(boolean withCommorbidies) {
        this.withCommorbidies = withCommorbidies;
    }

    public boolean isWithFoodAllergy() {
        return withFoodAllergy;
    }

    public void setWithFoodAllergy(boolean withFoodAllergy) {
        this.withFoodAllergy = withFoodAllergy;
    }

    public boolean isWithMedicationAllergy() {
        return withMedicationAllergy;
    }

    public void setWithMedicationAllergy(boolean withMedicationAllergy) {
        this.withMedicationAllergy = withMedicationAllergy;
    }



}
