import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static configuration.Configuration.CHECK_IN;
import static configuration.Configuration.DATE_FORMAT;

public class Main {

    public static void main(String[] args) {

        DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
        //Date date = new Date();
        String currentDate = dateFormat.format(new Date());
        System.out.println(currentDate);

        String[] arrayDate = currentDate.split("/");
        currentDate = arrayDate[0] + "/" + String.valueOf((Integer.parseInt(arrayDate[1]) + CHECK_IN)) + "/" + arrayDate[2];
        System.out.println(currentDate);


    }

}
