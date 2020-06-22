package udemy_exercises;

import java.util.*;

class Sorting {

    int numArray[] = new int[10];

    void sortIntegers(int[] nums) {

        Arrays.sort(nums);
        System.out.println(Arrays.toString(reverse(nums)));
    }

    void printNums() {
        System.out.println(Arrays.toString(getNums()));
    }

    int[] getNums() {

        return numArray;
    }

    int[] reverse(int[] numbers) {

        int tempArr[] = new int[10];
        int count = 0;

        for (int i = 9; i >= 0; i--) {
            tempArr[count] = numbers[i];
            count++;
        }

        return tempArr;
    }

    public static void main(String[] args) {

        Sorting mySorting = new Sorting();

        Scanner s = new Scanner(System.in);

        System.out.println("This is the Sorting Class");
        System.out.println("Please enter 10 numbers");
        for (int i = 0; i < 10; i++) {
            mySorting.numArray[i] = s.nextInt();
        }

        mySorting.printNums();
        mySorting.sortIntegers(mySorting.numArray);
        System.out.println(mySorting.getNums());

        s.close();
    }

}
