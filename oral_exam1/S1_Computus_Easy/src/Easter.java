public class Easter {


    public Easter(int year) {
        int a = year % 19;
        int b = year / 100; //this one is floor
        int c = year % 100;
        int d = b / 4;  //this one is floor
        int e = b % 4;
        int f = (b + 8) / 25;
        int g = (b - f + 1) / 3;
        int h = (19 * a + b - d - g + 15) % 30;
        int i = c / 4;
        int k = c % 4;
        int l = (32 + 2 * e + 2 * i - h - k) % 7;
        int m = (a + 11 * h + 22 * l) / 451;
        int month = (h + l + 7 * m + 114) / 31;
        int day = ((h + l - 7 * m + 114) % 31) + 1;

        if (month == 4) {
            System.out.println("April " + day + ", " + year);
        }
        System.out.println("March " + day + ", " + year);
    }
}
