package data.base;

import interfaces.onScheduleNextVisit;

public abstract class Vaccine implements onScheduleNextVisit {

    private String name;
    private String batchNo;
    private int interval;

    public String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public int getInterval() {
        return interval;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }

    @Override
    public String toString() {
        return "Vaccine:" +
                "name='" + name + '\'' +
                ", batchNo='" + batchNo + '\'' +
                ", interval='" + interval + '\'';
    }
}
