/**
 * Class Easter calculates the month and day on which Easter will fall in a given year
 */
public class Easter {

    /**
     *  Represents the month
     */
    private int month;

    /**
     * Represents the day
     */
    private int day;

    /**
     * Represents the year
     */
    private int year;

    /**
     * Constructor houses all the logic to compute the month and day for Easter for a given yera
     * @param Year
     */
    public Easter(int Year) {
        year = Year;
        int a = year % 19;
        int b = Math.floorDiv(year, 100);
        int c = year % 100;
        int d = Math.floorDiv(b, 4);
        int e = b % 4;
        int f = Math.floorDiv((b + 8), 25);
        int g = Math.floorDiv((b - f + 1), 3);
        int h = (19 * a + b - d - g + 15) % 30;
        int i = Math.floorDiv(c, 4);
        int k = c % 4;
        int l = (32 + 2 * e + 2 * i - h - k) % 7;
        int m = Math.floorDiv((a + 11 * h + 22 * l), 451);
        month = Math.floorDiv((h + l + 7 * m + 114), 31);
        day = ((h + l - 7 * m + 114) % 31) + 1;
    }

    /**
     *
     * @return the string representation of the date
     */
    public String getDate() {
        if (month == 4)
            return "April " + day /*+ ", " + year*/;

        else if (month == 3)
            return "March " + day /*+ ", " + year*/;
        else
            return "No date";
    }

    /**
     *
     * @return the month instance variable
     */
    public int getMonth() {
        return month;
    }

    /**
     *
     * @return the day instance variable
     */
    public int getDay() {
        return day;
    }
}
