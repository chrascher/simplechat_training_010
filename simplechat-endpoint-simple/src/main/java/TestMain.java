import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

public class TestMain {

    public static void main(String[] args) throws ParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

        String toParse = "2019-10-21T15:01:12.8447252";
        TemporalAccessor parse = formatter.parse(toParse);

        LocalDateTime localDateTime = LocalDateTime.from(parse);

        System.out.println(localDateTime.toString());

        customPattern();
    }

    public static void customPattern() throws ParseException {

        String str = "2016-03-04 11:30:40";
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(str, formatter1);
        System.out.println("dateTime:" + dateTime.toString());

        String pattern = "yyyy-mm-dd HH:mm:ss";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);

        // example timestamp pattern
        String timestampAsString = "2001-10-01 11:11:11";

        LocalDateTime localDateTime = LocalDateTime.from(formatter.parse(timestampAsString));
        System.out.println("new timesamp:" + localDateTime.toString());

    }


}