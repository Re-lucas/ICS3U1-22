public class CountDown {
    public static void main(String[] args) {
        int num_start = 100;
        int num_end = 1;
        int num_record = num_start;

        do {
            if (num_record >= num_end) {
                num_record -= 2;
                System.out.println(num_record);
            }
        } while (num_record >= num_end);
    }
}
