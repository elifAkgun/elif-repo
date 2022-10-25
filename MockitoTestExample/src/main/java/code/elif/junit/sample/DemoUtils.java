package code.elif.junit.sample;

import java.util.List;

public class DemoUtils {

    private String str1 = "Elif";
    private String str2 = str1;
    private String[] firstThreeLettersOfAlphabet = {"A", "B", "C"};
    private List<String> fruitsInList = List.of("apple", "peach", "orange");


    public Object checkNull(String str1) {
        return str1;
    }

    public int add(int i, int i1) {
        return i + i1;
    }

    public String getName() {
        return str1;
    }

    public String getNameDuplicate() {
        return str2;
    }

    public Boolean isGreater(int n1, int n2) {
        if (n1 > n2) {
            return true;
        }
        return false;
    }

    public String[] getFirstThreeLettersOfAlphabet() {
        return firstThreeLettersOfAlphabet;
    }

    public List<String> getFruitsInList() {
        return fruitsInList;
    }

    public String throwException(int a) throws Exception {
        if (a < 0) {
            throw new Exception("Value s'ould be greater than or equal to 0");
        }
        return "value is greater than or equal to 0";
    }
}

