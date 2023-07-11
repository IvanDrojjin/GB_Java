
// https://www.geeksforgeeks.org/deque-interface-java-example/

// deque new import java example

/*
0:10 08.07.2023
https://gb.ru/lessons/340488/homework
Java: знакомство и как пользоваться базовым API (семинары)
Урок 4. Хранение и обработка данных ч1: приоритетные коллекции
Формат сдачи: ссылка на подписанный git-проект.

Задание

Даны два Deque, представляющие два целых числа. 
Цифры хранятся в обратном порядке и 
каждый из их узлов содержит одну цифру.
1) Умножьте два числа и верните произведение в виде связанного списка.
2) Сложите два числа и верните сумму в виде связанного списка. // LinkedList (связанный список). 
Одно или два числа должны быть отрицательными.

*/

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class ExDequeNegative {
    public static int deQueToInt(Deque<Integer> l1) { // for reverse
        StringBuilder res1 = new StringBuilder();

        l1.stream().forEach(S -> res1.insert(0, S));  // add to start
        // enter:(2 -> 4 -> 3)    Output: 342

        // l1.stream().forEach(S -> res1.append(S)); // add to end
        // enter:(2 -> 4 -> 3)    Output: 243

        int foo = 0;        
        try {
            foo = Integer.parseInt(res1.toString());
        }
        catch (NumberFormatException e) {
            foo = 0;
        }        
        return foo;
    }

    public static Deque<Integer>  intTodeQue(int l1){
        Deque<Integer> res = new ArrayDeque<>();
        String str1 = Integer.toString(l1);

        if (str1.charAt(0) == '-'){
            res.push(-Integer.parseInt(str1.substring(1, 2)));
            // check sign of first digit
            for (int i = 2; i < str1.length(); i++){
                res.push(Integer.parseInt(str1.substring(i, i+1)));
            }
        }else{            
            for (int i = 0; i < str1.length(); i++){
                res.push(Integer.parseInt(str1.substring(i, i+1)));
            }
        }
        // System.out.println(" intTodeQue : " + (res));         
        return res;    
    }


    public static Deque<Integer> multTwoNumbersStr(Deque<Integer> l1, Deque<Integer> l2) {
        int sum1 = deQueToInt(l1) , sum2 = deQueToInt(l2);
        int mult = sum1 * sum2; 
        return intTodeQue(mult);      
    }


    public static Deque<Integer> addTwoNumbersStr(Deque<Integer> l1, Deque<Integer> l2) {
        int sum1 = 0, sum2 = 0;

        sum1 = deQueToInt(l1);
        sum2 = deQueToInt(l2);  
        // System.out.println("addTwoNumbesStr : sum1 :" + (sum1));  
        // System.out.println("addTwoNumbesStr : sum2 :" + (sum2));         
        
        // System.out.println("addTwoNumbesStr : " + l1);
        // System.out.println("addTwoNumbesStr : " + l2);
        // System.out.println("addTwoNumbesStr : sum :" + (sum1 + sum2));
        return intTodeQue(sum1 + sum2);   
    }

    public static Deque<Integer> addTwoNumbers(Deque<Integer> l1, Deque<Integer> l2) {
        Deque<Integer> res = new ArrayDeque<>();
        // System.out.println("addTwoNumbe : ");
        // System.out.println("addTwoNumbes : " + l1);
        // System.out.println("addTwoNumbes : " + l2);

        int sum = 0;
        Deque<Integer> cur = res;
        Deque<Integer> p1 = l1, p2 = l2;

        Iterator<Integer> it1 = l1.iterator();
        Iterator<Integer> it2 = l2.iterator();

        while (it1.hasNext() || it2.hasNext()){
            if (it1.hasNext()){                
                sum += it1.next();
            }
            if (it2.hasNext()){
                sum += it2.next();
            }
            res.addLast(sum % 10);
            sum /= 10;
        }
        return res;
    }

  public static void main(String[] args) {
    Deque<Integer> dq1 = new ArrayDeque<>();
    Deque<Integer> dq2 = new ArrayDeque<>();
//  enter:(2 -> 4 -> 3) + (5 -> 6 -> 4)
//  Output:7 -> 0 -> 8
//  the reason:342 + 465 = 807
//  -342* 465 = -159030
//  the reason:-3 + 465 = 462

    dq1.addFirst(2);
    dq1.addLast(4);
    dq1.addLast(-3);
    // dq1.addLast(-);
    // dq1.push(3);  // add first 

    dq2.addFirst(5);
    dq2.addLast(6); 
    dq2.addLast(4); 

    // int first = dq1.removeFirst();
    // int last = dq1.removeLast();
    // System.out.println("First: " + first + ", Last: " + last);
    System.out.println(" dq1 : " + dq1);
    System.out.println(" dq2 : " + dq2);
    System.out.println(" dq1 + dq2 : " + addTwoNumbers(dq1, dq2));
    System.out.println("-342 * 465 = -159030");
    System.out.println(" dq1 * dq2 : " + multTwoNumbersStr(dq1, dq2));


    // int i123 = 123;
    // System.out.println(i123 + " intTodeQue  : " + intTodeQue(i123));
    // System.out.println(-i123 + " intTodeQue  : " + intTodeQue(-i123));
    // addTwoNumbersStr


    // https://www.techiedelight.com/ru/iterate-over-deque-java-forward-backward/

/*
    System.out.println(" поток  dq1 : " + dq1);
    // 1. Получить поток и использовать лямбда-выражение
    dq1.stream().forEach(S -> System.out.println(S));

    // или предоставив ссылку на метод
    dq1.stream().forEach(System.out::println);

    // 2. Использование `forEach()`, унаследованного от интерфейса `java.lang.Iterable`
    dq1.forEach(System.out::println);

    // 3. Использование `Stream.of()` для получения `Stream<Integer>`
    Stream.of(dq1.toArray())
        .forEach(System.out::println);
*/
  }
}
    

