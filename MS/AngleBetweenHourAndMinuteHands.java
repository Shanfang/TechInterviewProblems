import java.util.*;

class AngleBetweenHourAndMinuteHands {
    static double calculateAngle (String time) {
        if (time == null || time.length() == 0) {
            return 0;
        }

        String[] strs = time.split(":");
        double hour = Double.valueOf(strs[0]);
        double minute = Double.valueOf(strs[1]);

        double angle1 = (hour + (minute / 60)) * 30;
        double angle2 = minute * 6;
        double diff  = Math.abs(angle1 - angle2);
        double result = diff > 180 ? 360 - diff : diff;
        return result;
    }

    public static void main(String[] args) {
        String time = "01:19";
        System.out.println(calculateAngle(time));
    }
}
