public class exe_262 {
    public static void countCharacters(String input) {
        int[] charCount = new int[input.length()];
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            charCount[i]++;
        }
        for (int i = 0; i < charCount.length; i++) {
            if (charCount[i] > 0) {
                System.out.println(input.charAt(i) + ": "+ charCount[i]);
            }
        }
    }

    public static void main(String[] args) {
        String string = "aabacsdc";
        countCharacters(string);
    }
}
