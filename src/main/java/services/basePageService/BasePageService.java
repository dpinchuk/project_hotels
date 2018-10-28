package services.basePageService;

import services.MainService;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static configuration.Configuration.DATE_FORMAT;

public class BasePageService extends MainService {

    public String getDate(int checkIn, int day) {
        Calendar calendar = new GregorianCalendar();
        DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
        calendar.add(Calendar.DAY_OF_YEAR, day + 1);
        return dateFormat.format(calendar.getTime());
    }

    public boolean isValidNumber(String str, int min, int max) {
        int num = 0;
        try {
            num = Integer.parseInt(str);
        } catch(Exception e) {
            str = str.substring(1, str.length());
        }
        num = Integer.parseInt(str);
        return num >= min && num <= max;
    }

}