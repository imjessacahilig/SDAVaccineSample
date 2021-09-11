package data.vaccines;

import data.base.Vaccine;

import java.util.Date;
import java.util.Calendar;

import static java.util.Calendar.getInstance;

public class AstraZeneca extends Vaccine {

    private static  final String name="Astrazeneca";

    public AstraZeneca(){
        this.setName(name);
        this.setInterval(60);
    }

    @Override
    public String computeAppointment(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        cal.add(Calendar.DATE, getInterval());

        return cal.getTime().toString();
    }

}
