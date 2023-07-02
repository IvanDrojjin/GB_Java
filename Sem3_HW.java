/**
 * https://gb.ru/lessons/340487/homework
 * Java: знакомство и как пользоваться базовым API (семинары)
 * Урок 3. Коллекции JAVA: Введение 
 * Преподаватель ждет ваше задание до 7 июля, 20:00 +03:00 UTC
 * Загрузите работу, чтобы преподаватель смог проверить ее и выставить оценку
 * 
 * Формат сдачи: ссылка на подписанный git-проект.
 *  Задание
 * Пусть дан произвольный список целых чисел.
 * 1) Нужно удалить из него чётные числа
 * 2) Найти минимальное значение
 * 3) Найти максимальное значение
 * 4) Найти среднее значение
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

// import java.io.BufferedReader;
import java.io.IOException;
// import java.io.InputStreamReader;
// import java.util.*;

public class Sem3_HW {
    public static void main(String[] args) throws Exception {
        // 
        System.out.println("Hello, World!  (Sem3_HW.java) \n");
        tsk1();
        // List<Integer> list = new ArrayList<>();  // (1, 2, 3, 4, 59, 8, 7, 6);

        Scanner sc = new Scanner(System.in);

        int maximum = 0;
        int minimum = 0;
        double average = 0.0;
        int i10 = 10;
        // int[] big = new int[i10];

        List<Integer> big1 = new ArrayList<Integer> (Arrays.asList(new Integer[i10]));

        // ArrayList<Integer> big1 = new ArrayList<Integer> (Arrays.asList(big));
        System.out.print("Input " + i10 + " integers : \n");
        for(int i = 0; i < i10; i++ ) {
            int b = sc.nextInt();
            big1.set(i, b);
        }         
        
         maximum = Collections.max(big1);
         minimum = Collections.min(big1);
         average = big1.stream().mapToInt(Integer::intValue).average().orElse(0);

         /**
          * int[] example1 = list.stream().mapToInt(i->i).toArray();
          * // OR
          * int[] example2 = list.stream().mapToInt(Integer::intValue).toArray();
          * How can I convert a List<Integer> to int[] in Java?
         */
        System.out.print("max : " + maximum + "\t min : " + minimum +"\n");
        System.out.printf("average : %,.3f \n", average);

        int[] arr1 = big1.stream().mapToInt(i->i).toArray();

        maximum = bestGrade(arr1);
        minimum = worstGrade(arr1);
        average = midGrade(arr1);

        System.out.print("I can convert a List<Integer> to int[] in Java \n");
        printAllGrades(arr1);
        System.out.print("max : " + maximum + "\t min : " + minimum+ "\n");
        System.out.printf("average : %,.3f \n", average);
        System.out.print("I can print odd items ... \n");
        printAllGrades(oddGrades(arr1));

    }

    public static void tsk1() throws Exception {      

        int[] grades = new int[] {5, 10, 7, 8, 9, 9, 10, 12};
        grades = AddItemInArray(grades, -69);
        // int[] grades1 ={}; 

        int highest_marks = bestGrade(grades);
        int worst_marks = worstGrade(grades);
        System.out.print("All the grades: ");
        printAllGrades(grades);
        System.out.println("The highest grade is " + highest_marks);
        System.out.println("The lowest grade is " + worst_marks);
        System.out.println("The average grade is " + midGrade(grades));

        System.out.print("odd grades: ");
        printAllGrades(oddGrades(grades));

    }

        static int[] AddItemInArray(int[] array, int item) throws Exception {
        int length = array.length;
        
        int[] temp = new int[length + 1];
        System.arraycopy(array, 0, temp, 0, length);
        temp[length] = item;
        return temp;
    }

    // метод, только нечетные оценки
    public static int[] oddGrades(int[] grades) throws Exception {
        int [] oddReturn = new int[] {};

        for (int num : grades) {
            if(num % 2 != 0){
                oddReturn = AddItemInArray(oddReturn, num);
            }
        }
        return oddReturn;
    }

    //метод, который распечатывает все оценки
    public static void printAllGrades(int[] grades) {
        System.out.print("|");
        for (int num : grades) {

            System.out.print(num + "|");
        }
        System.out.println();
    }

    //метод, в котором выводится средняя оценка
    public static double midGrade(int[] numbers) {
        int grade = 0;

        for (int num : numbers) {
            grade = num + grade;
        }
        return ((double) grade / numbers.length);
    }
    //метод в котором вычисляется лучшая (максимальная) оценка
    public static int bestGrade(int[] numbers) {
        int maxGrade = numbers[0];

        for (int num : numbers) {
            if (num > maxGrade) {
                maxGrade = num;
            }
        }
        return maxGrade;
    }

        //метод в котором вычисляется минимальная оценка
        public static int worstGrade(int[] numbers) {
        int minGrade = numbers[0];

        for (int num : numbers) {
            if (num < minGrade) {
                minGrade = num;
            }
        }
        return minGrade;
    }

}



