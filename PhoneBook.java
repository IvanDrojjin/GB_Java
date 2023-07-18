/******************************************************************************
https://gb.ru/lessons/340489/homework

Java: знакомство и как пользоваться базовым API (семинары)
Урок 5. Хранение и обработка данных ч2: множество коллекций Map
Формат сдачи: ссылка на подписанный git-проект.

	Задание

Реализуйте структуру телефонной книги с помощью HashMap.
Программа также должна учитывать, что во входной структуре будут повторяющиеся 
имена с разными телефонами, их необходимо считать, как одного человека с разными 
телефонами. Вывод должен быть отсортирован по убыванию числа телефонов.

Преподаватель ждет ваше задание до 19 июля, 20:01 +03:00 UTC
Загрузите работу, чтобы преподаватель смог проверить ее и выставить оценку


https://javarush.com/groups/posts/regulyarnye-vyrazheniya-v-java

https://stackoverflow.com/questions/37828214/regex-to-extract-value-from-a-simple-json-object

https://developer.alexanderklimov.ru/android/java/map.php
Map соотносит уникальные ключи со значениями. 

https://www.examclouds.com/java/java-core-russian/interface-queue
https://docs.oracle.com/javase/tutorial/java/data/manipstrings.html

https://чатгпт-в-россии.рф/решено-реализуйте-структуру-телефон/
https://developeprogram.blogspot.com/2013/11/java-hashmap-example-phone-book.html
https://translated.turbopages.org/proxy_u/en-ru.ru.4d520028-64b13843-45172a45-74722d776562/https/stackoverflow.com/questions/37795105/phone-book-with-hashmap-implementation-in-java

int count = Collections.frequency(party.values(), 1);
System.out.println(count);
*******************************************************************************/
import java.util.HashMap;
import java.util.Map;
import java.util.Collections;
// import java.util.stream;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;

import java.util.ArrayList;

public class PhoneBook{
    static String [] list;
    static String nameFile;

    private static HashMap<String, ArrayList> contacts = new HashMap();
    
	public static void main(String[] args) throws Exception  {
	    
	    String []  str2 = new String[2];
	    
		System.out.println("Hello World. \n https://gb.ru/lessons/340489/homework \n\n");
		
		nameFile = "Phones0.txt";
		readData();
		printData();

		
		deCodeContacts();
		printContactsSorted();
		
	}
	
	public static void readData() throws Exception {
	   list = lib.ReadLineFromFile(nameFile); 
	}
	
	public static void printData() throws Exception {
	    System.out.println(nameFile + " : \n"); 
        for (int i = 0; i < list.length; i++){
                System.out.println(list[i]); 
        }
	}
	
	
	public static void printContactsSorted() {
	    System.out.println("\n printDataSorted (" + nameFile +" ) : \n" ); 
        ArrayList<Map.Entry<String, ArrayList>> list =
                new ArrayList(contacts.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, ArrayList>>() {
            @Override  
            public int compare(Map.Entry<String, ArrayList> o1, Map.Entry<String, ArrayList> o2) {
                return o2.getValue().size() - o1.getValue().size();
            }
        });
        for (Map.Entry<String, ArrayList> entry : list) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
    
    
    public static void addContact(String name, String phoneNumber) {
        if (contacts.containsKey(name)) {
            ArrayList phoneNumbers = contacts.get(name);
            phoneNumbers.add(phoneNumber);
            contacts.put(name, phoneNumbers);
        } else {
            ArrayList phoneNumbers = new ArrayList();
            phoneNumbers.add(phoneNumber);
            contacts.put(name, phoneNumbers);
        }
    }
	
	
	public static void deCodeContacts() throws Exception {
	    String []  res0 = new String[2];  // res0[0] - name  ;   res0[1] - phone

        for (int i = 0; i < list.length; i++){
            res0 = getNmPh(list[i]);
            addContact(res0[0], res0[1]);
        }
        System.out.println("\ndeCodeContacts contacts: \n" + contacts);  // unique name
	}
	

	public static String[] getNmPh (String line)  throws Exception {
	    String []  res0 = new String[2];  // res0[0] - name  ;   res0[1] - phone
	    String del = ":";

	    //  {"name":"Ivanov", "phone":"1234567"}       --  line
	    // !!!  Ivanov:1234567       --  line
	   // System.out.println(" getNmPh line   "  + line); 
	    if (!line.contains(del)){
	        System.out.println(" getNmPh not founded  "  + del); 
	    } else {
	        res0 = line.split(del);
	    }
	    return res0;
	}

}
