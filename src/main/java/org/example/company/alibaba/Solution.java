package org.example.company.alibaba;

public class Solution {

    public static void quickSort(Student[] stuArray, int low, int high) {
        if (low < high) {
            int pivot = partition(stuArray, low, high); // 枢轴
            quickSort(stuArray, low, pivot - 1); // 递归处理左边
            quickSort(stuArray, pivot + 1, high); //
        }
    }

    public static int partition(Student[] stuArray, int low, int high) {
        int index = low + 1;
        for (int i = index; i <= high; i++) {
            if (stuArray[i].getScore() > stuArray[low].getScore()) { // >:降序 <:升序
                swap(stuArray, i, index);
                index++;
            }
        }
        swap(stuArray, low, index - 1);
        return index - 1;
    }

    public static void swap(Student[] stuArray, int i, int j) {
        Student temp = stuArray[i];
        stuArray[i] = stuArray[j];
        stuArray[j] = temp;
    }

    public static String toLowerCamelCase(String input) {
        char[] chars = input.toCharArray();
        char[] ret = new char[chars.length];
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '_') {
                if (i + 1 < chars.length)
                    ret[i + 1] = (char) (chars[i + 1] - 32);
                i++;
            }
            else {
                ret[i] = chars[i];
            }
        }
        return new String(ret);
    }

    public static void main(String[] args) {
        Student[] stuArr = {
                new Student("s1", "man", 18, 270),
                new Student("s2", "man", 18, 249),
                new Student("s3", "man", 18, 256),
                new Student("s3", "man", 18, 278),
                new Student("s5", "woman", 18, 298),
                new Student("s6", "woman", 18, 298),
                new Student("s7", "woman", 18, 223),
                new Student("s8", "man", 18, 234),
                new Student("s9", "man", 18, 259),
                new Student("s10", "man", 18, 218)
        };

        quickSort(stuArr, 0, stuArr.length - 1);

        // Arrays.stream(stuArr).forEach(x -> System.out.print(x.getScore() + " "));

        for (Student s : stuArr)
            System.out.println(s.toString());

        String input = "my_book_name";
        System.out.println(toLowerCamelCase(input));
    }
}


