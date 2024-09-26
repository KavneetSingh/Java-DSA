public class AllSubsets {
    public static void subsetPrint(String str, String sub, int i) {
        if (i ==str.length()) {
            System.out.println(sub);
            return;
        }

        subsetPrint(str, sub, i+1);   //char not selected
        subsetPrint(str, sub+ str.charAt(i),i+1);   // char selected
    }

    public static void main(String[] args) {
        String str = "abc";
        subsetPrint(str, "", 0);
    }
}