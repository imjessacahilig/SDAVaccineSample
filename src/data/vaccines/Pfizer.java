package data.vaccines;

import data.base.Vaccine;

import java.util.Calendar;
import java.util.Date;

public class Pfizer extends Vaccine {
    private static  final String name="Pfizer";

    public Pfizer(){
        this.setName(name);
        this.setInterval(21);
    }

    @Override
    public String computeAppointment(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        cal.add(Calendar.DATE, getInterval());

        return cal.getTime().toString();
    }
}
