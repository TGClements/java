package exercise2;

public class Colors {

    String[] colorful(String[] strings) {
        // For the given strings, keep all the strings that begin with a color ("red", "yellow", "green", "blue", etc.) return an array of strings that start with a color.  discard all the other strings.  If no strings start with a color in the input array, return an empty array.
        String colorArray[] = { "red", "yellow", "green", "blue", "black", "pink" };
        String resultArray[] = new String[strings.length];
        int count = 0;

        for (String token : strings) {
            for (String color : colorArray) {
                if (token.contains(color)) {
                    resultArray[count] = token;
                    count++;
                }
            }
        }

        if (count == 0) {
            return new String[] {};
        }

        return resultArray;
    }

    public static void main(String[] args) {
        Colors code = new Colors();
        code.colorful(new String[] { "bluebird", "red herring", "yellow bumblebee", "black spider", "green monkey",
                "pink", "great gatsby", "feeding frenzy", "black bird", "widowmaker", "quran", "bible", "torah" });
        System.out.println("This is the Colors class");
    }

}

// convert to arraylist then convert to array
