public class CalProbe {
    public static void main(String[] args) {
        try {
            System.out.println("valid=" + szu.csse.softwaretesting.ch8.Cal.cal(1, 15, 3, 10, 2024));
        } catch (Throwable t) {
            System.out.println("valid ex=" + t.getClass().getName());
        }
        try {
            System.out.println("month1_0=" + szu.csse.softwaretesting.ch8.Cal.cal(0, 15, 3, 10, 2024));
        } catch (Throwable t) {
            System.out.println("month1_0 ex=" + t.getClass().getName());
        }
        try {
            System.out.println("month2_13=" + szu.csse.softwaretesting.ch8.Cal.cal(1, 15, 13, 10, 2024));
        } catch (Throwable t) {
            System.out.println("month2_13 ex=" + t.getClass().getName());
        }
        try {
            System.out.println("same_month_bad_days=" + szu.csse.softwaretesting.ch8.Cal.cal(3, 20, 3, 10, 2024));
        } catch (Throwable t) {
            System.out.println("same_month_bad_days ex=" + t.getClass().getName());
        }
    }
}
