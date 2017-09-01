public class Easter {

    private int month;
    private int day;
    private int year;

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

    public void printDate(){
        if (month == 4)
            System.out.println("April " + day + ", " + year);

        else if (month == 3)
            System.out.println("March " + day + ", " + year);
    }

    public int getMonth(){
        return month;
    }

    public int getDay(){
        return day;
    }
}
