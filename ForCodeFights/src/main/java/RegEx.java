import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegEx {
    public static void main(String[] args) {
//        String str = "id=${'1'}, SIGNAL_NAME=${'QQQ'}, NAME=${'TARAT'}, ";
//        String test = "abc${'hello'}, name=${''}, ";
//        Pattern pattern = Pattern.compile("\\bNAME=\\$\\{'(.*?)'},");
////        pattern = Pattern.compile("abc[^('}, )]*");
//        Matcher m = pattern.matcher(str);
//        if (m.find()) {
//            System.out.println(m.group(1));
//        }
//        System.out.println(str.matches(".*SIGNAL_NAME=\\$\\{'.*'}.*"));
//        System.out.println(test.matches("\\$\\{'.*'}"));
        String str1 = "PowerPlantStation.%1qrp.pccurrent%2";
        ArrayList<String> allMatches = new ArrayList<>();
        ArrayList<String> parameters = new ArrayList<>();
        parameters.add("req");
        parameters.add("_Hoho");
        Pattern pattern1 = Pattern.compile(".*?%(\\d+).*?");
        Matcher m = pattern1.matcher(str1);
        while (m.find()) {
            allMatches.add(m.group(1));
        }
        for (String str : allMatches) {
            int i = Integer.parseInt(str) - 1;
            if (i < parameters.size()) {
                str1 = str1.replaceAll("%" + str, parameters.get(i));
            }
        }
        System.out.println(str1);
    }
}
