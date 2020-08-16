import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int[] inputArr = {16,17,4,3,5,2};
        int max = inputArr[inputArr.length - 1];
        inputArr[inputArr.length - 1] = -1;
        for (int i = inputArr.length - 2; i >= 0; i--) {
            if (inputArr[i] > max) {
                inputArr[i] = max;
                max = inputArr[i];
            }
            else {
                inputArr[i] = max;
            }
        }
        for (int i = 0; i < inputArr.length; i++) {
            System.out.print(inputArr[i] + " ");
        }
    }
}