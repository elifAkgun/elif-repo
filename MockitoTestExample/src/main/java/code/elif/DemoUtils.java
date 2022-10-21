package code.elif;

public class DemoUtils {

    String str1 = "Elif";
    String str2 = str1;
    String[] firstThreeLettersOfAlphabet = {"A", "B", "C"};


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
}

