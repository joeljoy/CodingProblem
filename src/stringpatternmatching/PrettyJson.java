package stringpatternmatching;

import java.util.ArrayList;
import java.util.Arrays;

public class PrettyJson {

    public static void main(String[] args) {
        PrettyJson json = new PrettyJson();
//        String[] res = json.prettyJSON("{A:\"B\",C:{D:\"E\",F:{G:\"H\",I:\"J\"}}}");
//        String[] res = json.prettyJSON("[\"foo\", {\"bar\":[\"baz\",null,1.0,2]}]");
        String[] res = json.prettyJSON("{\"attributes\":[{\"nm\":\"ACCOUNT\",\"lv\":[{\"v\":{\"Id\":null,\"State\":null},\"vt\":\"java.util.Map\",\"cn\":1}],\"vt\":\"java.util.Map\",\"status\":\"SUCCESS\",\"lmd\":13585},{\"nm\":\"PROFILE\",\"lv\":[{\"v\":{\"Party\":null,\"Ads\":null},\"vt\":\"java.util.Map\",\"cn\":2}],\"vt\":\"java.util.Map\",\"status\":\"SUCCESS\",\"lmd\":41962}]}");
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }

    public String[] prettyJSON(String A) {
        ArrayList<String> result = new ArrayList<>();
        StringBuilder spaceBuilder = new StringBuilder();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < A.length(); i++) {
            char c = A.charAt(i);
            if (c == '{' || c == '[') {
                if (stringBuilder.length() != 0) {
                    result.add(stringBuilder.toString());
                    stringBuilder = new StringBuilder();
                }
                stringBuilder.append(spaceBuilder.toString());
                stringBuilder.append(c);
                result.add(stringBuilder.toString());
                stringBuilder = new StringBuilder();
                spaceBuilder.append('\t');
            } else if (c == '}' || c == ']') {
                if (stringBuilder.length() != 0) {
                    result.add(stringBuilder.toString());
                    stringBuilder = new StringBuilder();
                }
                spaceBuilder.deleteCharAt(spaceBuilder.length() - 1);
                stringBuilder.append(spaceBuilder.toString());
                stringBuilder.append(c);
                if (i != A.length() - 1) {
                    if (A.charAt(i + 1) == ',') {
                        continue;
                    }
                }
                result.add(stringBuilder.toString());
                stringBuilder = new StringBuilder();
            } else if (c == ',') {
                stringBuilder.append(c);
                result.add(stringBuilder.toString());
                stringBuilder = new StringBuilder();
            } else {
                char p = A.charAt(i - 1);
                if (p == '[' || p == '{' || p == ',') {
                    stringBuilder.append(spaceBuilder.toString());
                }
                stringBuilder.append(c);
            }
        }

        String[] answer = new String[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
}
