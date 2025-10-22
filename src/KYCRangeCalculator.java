import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class KYCRangeCalculator {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public static String getKYCRange(String signup, String current) {
        try {
            LocalDate signupDate = LocalDate.parse(signup, FORMATTER);
            LocalDate currentDate = LocalDate.parse(current, FORMATTER);

            if (currentDate.isBefore(signupDate)) {
                return "No range";
            }

            // Find anniversary in current year
            LocalDate anniversary = signupDate.withYear(currentDate.getYear());

            // If anniversary is after current date (like signup in Dec and today in Mar), take previous year's anniversary
            if (anniversary.isAfter(currentDate)) {
                anniversary = anniversary.minusYears(1);
            }

            // Calculate start and end of valid KYC window
            LocalDate startRange = anniversary.minusDays(30);
            LocalDate endRange = anniversary.plusDays(30);

            // If signup date is after current date’s anniversary window — no valid anniversary yet
            if (currentDate.isBefore(startRange)) {
                return "No range";
            }

            // Limit end range to current date if current is before endRange
            LocalDate effectiveEnd = currentDate.isBefore(endRange) ? currentDate : endRange;

            return startRange.format(FORMATTER) + " " + effectiveEnd.format(FORMATTER);

        } catch (Exception e) {
            return "Invalid input";
        }
    }

    public static void main(String[] args) {
        String[][] testInputs = {
                {"16-07-1998", "27-06-2017"},
                {"04-02-2016", "04-04-2017"},
                {"04-05-2017", "04-04-2017"},
                {"04-04-2015", "04-04-2016"},
                {"04-04-2015", "15-03-2016"}
        };

        for (String[] pair : testInputs) {
            System.out.println(getKYCRange(pair[0], pair[1]));
        }
    }
}

