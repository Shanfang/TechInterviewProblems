import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

class DecodeDate {
    static List<String> decode(List<String> dates) {
        List<String> result = new ArrayList<>();
        if (dates == null || dates.size() == 0) {
            return result;
        }
        Map<String, String> map = new HashMap<>();
        map.put("Jan", "01");
        map.put("Feb", "02");
        map.put("Mar", "03");
        map.put("Apr", "04");
        map.put("May", "05");
        map.put("Jun", "06");
        map.put("Jul", "07");
        map.put("Aug", "08");
        map.put("Sep", "09");
        map.put("Oct", "10");
        map.put("Nov", "11");
        map.put("Dec", "12");
        for (String date : dates) {
            result.add(buildDate(date, map));
        }
        return result;
    }

    static String buildDate(String date, Map<String, String> map) {
        String[] strs = date.split("\\s+");
        StringBuilder sb = new StringBuilder();
        // 1st Nov 2018
        sb.append(strs[2]).append("-");
        String month = map.get(strs[1]);
        sb.append(month).append("-");
        Pattern p = Pattern.compile("^(\\d+)\\D+$");
        Matcher m = p.matcher(strs[0]);
        if (m.matches()) {
            String day = m.group(1);
            if (day.length() == 1) {
                day = "0" + day;
            }
            sb.append(day);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] strings = {"1st Nov 2018", "27th Jan 2018", "2nd Jun 2018"};
        List<String> list = Arrays.asList(strings);
        for(String date : decode(list)) {
            System.out.println(date);
        }
    }
}
