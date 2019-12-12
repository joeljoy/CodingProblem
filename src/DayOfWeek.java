public class DayOfWeek {

    public static void main(String[] args) {
        DayOfWeek dayOfWeek = new DayOfWeek();
//        System.out.println(dayOfWeek.solve(23, 5, 1998));
//        System.out.println(dayOfWeek.solve(19, 4, 2019));
//        System.out.println(dayOfWeek.solve(7, 10, 1996));
        System.out.println(dayOfWeek.solve(24, 11, 1992));
//        System.out.println(dayOfWeek.solve(1, 1, 1));
//        System.out.println(dayOfWeek.solve(1, 2, 1));
    }

    public String solve(int A, int B, int C) {
        String[] days = {"sunday", "monday", "tuesday", "wednesday", "thursday", "friday", "saturday"};
        int totalDaysAfter = getDays(A, B, C);
        return days[totalDaysAfter % 7];
    }

    private int getDays(int a, int b, int c) {
        int days = 0;
        days += 365 * (c - 1);
        int leapYearCount = getLeapYearUntil(c - 1);
        days += leapYearCount;

        days += (31 * (b - 1));
        if (b > 2) {
            days -= (b - 1) / 2;
            if (isLeapYear(c)) {
                days -= 1;
            } else {
                days -= 2;
            }
        }
        days += a;
        return days;
    }

    private int getLeapYearUntil(int y) {
        int count = 0;
        for (int i = 1; i <= y; i++) {
            if (isLeapYear(i))
                count++;
        }
        return count;
    }

    private boolean isLeapYear(int c) {
        return ((c % 400 == 0) || ((c % 4 == 0) && (c % 100 != 0)));
    }


}
