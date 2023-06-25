/** https://gb.ru/lessons/340485/homework

Урок 1. Знакомство с языком программирования Java
Формат сдачи: ссылка на подписанный git-проект.
Преподаватель ждет ваше задание до 30 июня, 20:00 +03:00 UTC

Задание

1) Вычислить n-ое треугольного число (сумма чисел от 1 до n), 
n! (произведение чисел от 1 до n)
2) Вывести все простые числа от 1 до 1000
3) Реализовать простой калькулятор
4) (дополнительное задание) Задано уравнение вида q + w = e, q, w, e >= 0. 
Некоторые цифры могут быть заменены знаком вопроса, например, 2? + ?5 = 69. 
Требуется восстановить выражение до верного равенства. Предложить хотя бы одно 
решение или сообщить, что его нет.

*/
import java.util.Scanner;

public class Sem1_HW {
    
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        tsk1();

        tsk2();

        tsk3_calk();

        tsk4_SolverEx();
    }

    public static void tsk1(){
        // 1) Вычислить n-ое треугольного число (сумма чисел от 1 до n), 
        // n! (произведение чисел от 1 до n)
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int sum = 0;
        for (int j = 1; j <= n; j ++){
            sum += j;
        }

        System.out.print("sum :");
        System.out.println(sum);

        int mult = 1;
        for (int j = 1; j <= n; j ++){
            mult *= j;
        }        

        System.out.print("n! :");
        System.out.println(mult);

    } // end public static void tsk1(){


    public static void tsk2(){
        System.out.println("простые числа < 1000");
        int n1000 = 1000;
        boolean flag0 = false;
        for (int i3 = 1; i3 <= n1000; i3++){
            flag0 = true;
            for (int i4 = 2; i4*i4 <= i3; i4++ ){
                if (i3 % i4 == 0 ){
                    flag0 = false;
                    break;
                }
            }
            if (flag0){
                System.out.println(i3);
            }
        }
        System.out.println("end .. простые числа < 1000");
    } // end public static void tsk2(){

    public static void tsk3_calk(){ // калькулятор
        // + - * / 

        double n1;
        double n2;
        double ans;
        char op;

        Scanner in = new Scanner(System.in);
        
        System.out.print("Введите два числа: ");
        n1 = in.nextDouble();
        n2 = in.nextDouble();
        System.out.print("\nВедите оператор +  -  *  / : ");
        op = in.next().charAt(0);
        switch(op) {
            case '+': ans = n1 + n2;
                break;
            case '-': ans = n1 - n2;
                break;
            case '*': ans = n1 * n2;
                break;
            case '/': ans = n1 / n2;
                break;
            default:  System.out.printf("Ошибка оператор не найден ");
                return;
        }
        System.out.print("\nРезультат :\n");
        System.out.printf(n1 + " " + op + " " + n2 + " = " + ans);
    } // end  public static void tsk3_calk(){ // калькулятор


    public static void SolverEx(int[] x0, int[] xm0){ // калькулятор
        int[] dx = {0, 0, 0};   //  = (xm0 - x0) / 9;
        int[] y0 = {0, 0, 0};  

        for (int i = 0; i < 3; i++){
            dx[i] = (xm0[i] - x0[i]) / 9;
            y0[i] = x0[i];
        }

        for (int i = 0; i < 10; i += 1){
            
            for (int j = 0; j <10; j += 1){
                
                for (int k = 0; k <10; k += 1){
                    // System.out.printf("%d + %d = %d \n", x0[0], x0[1], x0[2]);
                    if (x0[0] + x0[1] == x0[2]){
                        System.out.printf("%d + %d = %d \n", x0[0], x0[1], x0[2]);
                        return;
                    }
                    if (x0[0] + x0[1] > x0[2]){
                        break;
                    }
                    if (dx[2] == 0){
                        break;
                    } 
                    x0[2] += dx[2];
                }
                x0[2] = y0[2];
                x0[1] += dx[1];                 
                if (x0[0] + x0[1] > x0[2]){
                    break;
                }                
                if (dx[1] == 0){
                    break;
                } 

            }
            x0[1] = y0[1];
            x0[0] += dx[0];
            if (x0[0] + x0[1] > x0[2]){
                break;
            }            
            if (dx[0] == 0){
                break;
            } 
        }
    }  // end SolverEx()

    public static void tsk4_SolverEx(){ // калькулятор
        Scanner in = new Scanner(System.in);
        System.out.println("\n\nЗадано выражение: 2? + ?5 = 69 .\n Восстановить выражение до верного равенства.");
        System.out.print("Введите уравнение: ");
        String equation = in.nextLine();
        String[] parts = equation.split("\s*[+=]\s*");  // разбиваем строку на части

        int[] x =  {0, 0, 0};
        // int[] xmin =  {0, 0, 0};
        int[] xmax =  {0, 0, 0};

        // Для замены символов в строке в Java можно использовать метод 
        // replace класса String : 
        // String str = "Hello, world!"; 
        // String newStr = str. replace('l', 'z')

        String newStr = "  ";

        for (int i = 0; i < 3; i++){
            if (parts[i].contains("?")){
                newStr = parts[i].replace('?', '0');
                x[i] = Integer.parseInt(newStr);
                newStr = parts[i].replace('?', '9');
                xmax[i] = Integer.parseInt(newStr);
            } else{
                x[i] = Integer.parseInt(parts[i]);
                xmax[i] = x[i];
            }
        }  // end for

        if ((x[0] + x[1] <= x[2]) && (xmax[0] + xmax[1] >= xmax[2])) {
            // I scan solve it
            System.out.print("Решение возможно : \t");
            System.out.printf("%d + %d <= %d \t", x[0], x[1], x[2]);
            System.out.printf("%d + %d >= %d \n", xmax[0], xmax[1], xmax[2]);
            SolverEx(x, xmax); // print result
        }else{
            // NO solve it
            System.out.println("Решений нет...");
            System.out.printf("%s  \n", equation);
        }

    }  // end public static void tsk4_SolverEx(){ // калькулятор
}



    

