package Homework6;

import java.time.Year;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        
        Nout nout = new Nout("Asus","black", "16", "512","Windous_11");
        

        Nout nout1 = new Nout("Hitec","red","8 ","256 ","Windous_10");
        

        Nout nout2 = new Nout("MI","black","32","512","Linux");
       

        Nout nout3 = new Nout("Mac","white","32","256","iOS");
       
        Set<Nout> noteBooks = new HashSet<>(List.of(nout,nout1,nout2,nout3));

        Map<String,String> sel = selectCriterial();
        sort(sel,noteBooks);
    }
    public static String scanner(){
        Scanner scanner = new Scanner(System.in);
        String scan = scanner.nextLine();
        return scan;
    }
    public static Map<String,String> selectCriterial(){
        Map<String,String> resultCriterial = new HashMap<>();
        while (true){
            System.out.println("Вы хотите выбрать критерий? Если да введите 'y', если нет введите 'n'");
            String question = scanner();
            if (question.equals("n")) {
                break;
            }
            else{
                System.out.println("Введите цифру, соответствующую необходимому критерию: \n 1 - Название \n 2 - Цвет \n 3 - Объем Озу \n 4 - ОбЪём Ssd \n 5 - Операционную систему");
                String key = scanner();
                System.out.println("Введите значения для выбранного критерия: ");
                String value = scanner();
                resultCriterial.put(key,value);
            }
        }
        System.out.println(resultCriterial);
        return resultCriterial;   
    }

    public static void sort(Map<String,String> criterias, Set<Nout> noteBooks){
        Set<Nout> temp = new HashSet<>(noteBooks);
        for (Nout noteBook : noteBooks) {
            for (Object pair : criterias.keySet()) {

                if (pair.equals("1") && !noteBook.getName().equals(criterias.get(pair))) {
                   temp.remove(noteBook);
                }
                for (Object pair1 : criterias.keySet()) {
    
                   if (pair1.equals("2") && !noteBook.getColor().equals(criterias.get(pair1))) {
                      temp.remove(noteBook);
    
                   }
                   for (Object pair2 : criterias.keySet()) {
    
                      if (pair2.equals("3") && !noteBook.getOzu().equals(criterias.get(pair2))) {
                         temp.remove(noteBook);
    
                      }
                      for (Object pair3 : criterias.keySet()) {
    
                         if (pair3.equals("4") && !noteBook.getSsd().equals(criterias.get(pair3))) {
                            temp.remove(noteBook);
    
                         }
                         for (Object pair4 : criterias.keySet()) {
    
                            if (pair4.equals("5") && !noteBook.getOperateSystem().equals(criterias.get(pair4))) {
                               temp.remove(noteBook);
    
                            }
                         }
                      }
                   }
                }
             }
    
          }
          if (temp.isEmpty()) {
            System.out.println("По введенным критериям ничего не найдено!");
         } else {
            System.out.println("Вот что мы можем предложить: \n" + temp.toString());
         }
        

    }
}
