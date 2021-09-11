package data.vaccines;

import data.base.Vaccine;

import java.util.Calendar;
import java.util.Date;

public class Moderna extends Vaccine {
    private static  final String name="Moderna";

    public Moderna(){
        this.setName(name);
        this.setInterval(28);
    }

    @Override
    public String computeAppointment(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        cal.add(Calendar.DATE, getInterval());

        return cal.getTime().toString();
    }
}
