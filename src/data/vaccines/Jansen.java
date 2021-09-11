package data.vaccines;

import data.base.Vaccine;

import java.util.Date;

public class Jansen extends Vaccine {

    private static final String name = "Johnson & Johnson";

    public Jansen() {
        this.setName(name);
        this.setInterval(0);
    }

    @Override
    public String computeAppointment(Date date) {

        return "N/A";
    }
}
