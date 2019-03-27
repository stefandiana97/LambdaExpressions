import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class MonitoredData {
    private Date start_time;
    private Date end_time;
    private String activity_label;

    public MonitoredData(String start_time, String end_time, String activity_label) {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            this.start_time = formatter.parse(start_time);
            this.end_time = formatter.parse(end_time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String[] strings = activity_label.split("\t");
        this.activity_label = strings[0];
    }

    public Date getStart_time() {
        return start_time;
    }

    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }

    public String getActivity_label() {
        return activity_label;
    }

    public void setActivity_label(String activity_label) {
        this.activity_label = activity_label;
    }

    public int getDay() {
        LocalDate localDate = start_time.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int year = localDate.getYear();
        int month = localDate.getMonthValue();
        int day = localDate.getDayOfYear();
        // int day= localDate.getDayOfMonth();
        return day;
    }

    public long getTime() {
        long diferentaSecunde = end_time.getTime() - start_time.getTime();
        return diferentaSecunde / 1000; // milisecunde to secunde ?? transformare
    }

    @Override
    public String toString() {
        return "MonitoredData: " +
                "start_time=" + start_time +
                ", end_time=" + end_time +
                ", activity_label=" + activity_label;
    }
}
