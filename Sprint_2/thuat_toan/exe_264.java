import java.util.Arrays;

public class exe_264 {
    public static void main(String[] args) {
        String string = "abddfghjkuwjemdhfjda";
        Character[] characterArray = sortCharacter(string);
        Arrays.sort(characterArray);
        String sortedString = "";
        for (char c : characterArray) {
            sortedString += c;
        }
        System.out.println(sortedString);
    }

    public static Character[] sortCharacter(String a) {
        Character[] characterArray = new Character[a.length()];
        for (int i = 0; i < characterArray.length; i++) {
            characterArray[i] = a.charAt(i);
        }
        return characterArray;
    }

}