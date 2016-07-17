package Problem10_DateModifier;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.time.Period;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateModifierProblem {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        String firstDate = sc.readLine();
        String secondDate = sc.readLine();
        DateModifier date = new DateModifier();
        date.Calculate(firstDate, secondDate);
        System.out.println(date.getDifference());
    }
}

class DateModifier {
    private long difference;

    public long getDifference() {
        return difference;
    }

    public void Calculate(String firstDate, String secondDate) {
        int[] dateOneParams = Arrays.stream(firstDate.split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] dateTwoParams = Arrays.stream(secondDate.split("\\s+")).mapToInt(Integer::parseInt).toArray();

        Calendar start = Calendar.getInstance();
        Calendar end = Calendar.getInstance();
        start.set(dateOneParams[0], dateOneParams[1], dateOneParams[2]);
        end.set(dateTwoParams[0], dateTwoParams[1], dateTwoParams[2]);
        Date startDate = start.getTime();
        Date endDate = end.getTime();
        long startTime = startDate.getTime();
        long endTime = endDate.getTime();
        long diffTime = Math.abs(endTime - startTime);
        this.difference = diffTime / (1000 * 60 * 60 * 24);
    }
}