/**
 * https://gb.ru/lessons/340486/homework
 * Java: знакомство и как пользоваться базовым API (семинары)
 * Урок 2. Почему вы не можете не использовать API
 * Формат сдачи: ссылка на подписанный git-проект.
 * 
 * 1) Дана строка sql-запроса "select * from students where ". 
 * Сформируйте часть WHERE этого запроса, используя StringBuilder. 
 * Данные для фильтрации приведены ниже в виде json-строки.
 * Если значение null, то параметр не должен попадать в запрос.
 * Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", 
 * "city":"Moscow", "age":"null"}
 * 
 * 2) Реализуйте алгоритм сортировки пузырьком числового массива, 
 * результат после каждой итерации запишите в лог-файл.
 * 
*/

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import java.io.IOException;
import java.util.logging.*;


public class Sem2_HW {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!  (Sem2_HW.java) \n");

        tsk1();

        tsk2();

        // tsk3_calk();
        // tsk4_SolverEx();
    }

    public static void tsk1() throws Exception {
        String [] list = lib.ReadLineFromFile("dataForSelect.txt"); 
        StringBuilder resultSelect0;
        System.out.println("\n ... Сформируйте часть WHERE этого запроса ... \n");
        
        for (int i = 0; i < list.length; i++){
            System.out.println(list[i]); 
            resultSelect0 = LineInListWhere("select * from students ", list[i]);
            System.out.println(resultSelect0);
            System.out.println();
        }
    }
    
    public static StringBuilder LineInListWhere(String selectFrom, String line) {
        String line1 = line.replace("{", "");
        String line2 = line1.replace("}", "");
        String line3 = line2.replaceAll("\"", "");
        // System.out.println(line3);
        
        StringBuilder result0 = new StringBuilder(selectFrom);
        StringBuilder result = new StringBuilder(" ");

        String [] arrayData = line3.split(", ");
        boolean flag = false;
        for (int i = 0; i < arrayData.length; i++) {
            String[] arrData = arrayData[i].split(":");
            if(arrData[1].equals("null") == false) {
                if (flag) {
                    result.append(" and ");
                } 
                result.append(arrData[0]);
                result.append(" = \"");
                result.append(arrData[1]);
                result.append("\"");
                flag = true;
            }
            
        }
        if (result.length() > 3) {
            result0.append("where ");
            return result0.append(result);
        }
        return result0;
    }
	
	
    public static void tsk2() throws Exception {
        // 2) Реализуйте алгоритм сортировки пузырьком числового массива, 
        // результат после каждой итерации запишите в лог-файл.    

        int [] mas = {11, 3, 14, 16, 7};
        
        sortBubleLog(mas);
 
    } // end public static void tsk2(){
    

    public static void sortBuble(int [] mas){
        boolean isSorted = false;
        int buf;
        
        System.out.println(Arrays.toString(mas));  
        while(!isSorted) {
            System.out.println(Arrays.toString(mas));
            isSorted = true;
            for (int i = 0; i < mas.length-1; i++) {
                if(mas[i] > mas[i+1]){
                    isSorted = false; 
                    buf = mas[i];
                    mas[i] = mas[i+1];
                    mas[i+1] = buf;
                }                
            }
        }
        System.out.println(Arrays.toString(mas));        
    }    // end 	public static void sortBuble(int [] mas){
		
    public static void sortBubleLog(int [] mas) throws IOException {
        boolean isSorted = false;
        int buf;
        
        Logger logger = Logger.getLogger(Sem2_HW.class.getName());
        //ConsoleHandler ch = new ConsoleHandler();
        FileHandler fh = new FileHandler("sortBubleLog.txt");
        //logger.addHandler(ch);
        logger.addHandler(fh);
        
        SimpleFormatter sFormat = new SimpleFormatter();
        //XMLFormatter xml = new XMLFormatter();
        fh.setFormatter(sFormat);
        //fh.setFormatter(xml);
        
        //logger.setLevel(Level.INFO);
        // logger.log(Level.WARNING, "Тестовое логирование 1");
        logger.info(Arrays.toString(mas));		
		
        // System.out.println(Arrays.toString(mas));  
        while(!isSorted) {
            System.out.println(Arrays.toString(mas));
            isSorted = true;
            for (int i = 0; i < mas.length-1; i++) {
                if(mas[i] > mas[i+1]){
                    isSorted = false; 
                    buf = mas[i];
                    mas[i] = mas[i+1];
                    mas[i+1] = buf;
                }                
            }
        }
		logger.info(Arrays.toString(mas));
        // System.out.println(Arrays.toString(mas));        
    }    // end 	public static void sortBubleLog(int [] mas){		

    
}
