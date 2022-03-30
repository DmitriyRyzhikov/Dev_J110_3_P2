
package Dev_J110;

import java.util.ArrayList;
import java.util.HashSet;


public class Main {

    public static void main(String[] args) {
        
/* Для опытов создано четыре стринговых списка и две коллекции <List> и <Set>:
     - fullList - нормальный список, заполнен из массива animals имеет несколько одинаковых элементов;
     - singleList - список с единственным элементом "попугай";
     - emptyList - пустой список;
     - addList - этот список, заполненный из массива birds можно добавлять к любым трем спискам выше или наоборот;
     - collection1 список класса ArrayList
     - collection2 множество класса HashSet  
*/
        String[] animals = new String[]{"кот", "корова", "обезьяна", "кот", "тигр", "кот"}; 
        String[] birds = new String[]{"соловей", "сова", "воробей", "ворона"};
        
        ArrayList <String> collection1 = new ArrayList<>();
        collection1.add("панда");
        collection1.add("лемур");
        collection1.add("выдра");  // ArrayList <String> collection1 заполнена
        
        HashSet<String> collection2 = new HashSet<>();
        collection2.add("носорог");
        collection2.add("бегемот");
        collection2.add("жираф");  //HashSet<String> collection2 заполнена
        
        DoublyList emptyList = new DoublyList(); //пустой список
        
        DoublyList singleList = new DoublyList();
        singleList.addFirst("попугай");           //список с одним элементом
        
        DoublyList fullList = new DoublyList();
        DoublyList addList = new DoublyList();
        fullList.addFromArrayFirst(animals); 
        addList.addFromArrayFirst(birds);        // два полноценных списка заполнены из массивов. Можно тестировать.
        


  
/* Список доступных методов:
        - Метод addFirst(String data) добавляет значения в начало списка;
        - Метод addFromArrayFirst(String[] data) добавляет все значения заданного массива в начало списка с сохранением порядка;
        - Метод extractFirst() извлекает и возвращает значение из начала списка без его удаления из списка;
        - Метод extractFirstAndRemove() извлекает и возвращает значение из начала списка с удалением его из списка;
        - Метод addToEnd(String data) добавляет значение в конец списка;
        - Метод extractFromEnd() извлекает и возвращает значение из конца списка без его удаления;
        - Метод extractFromEndAndRemove() извлекает и возвращает значение из конца списка с удалением его из списка;
        - Метод addFromArrayEnd(String[] data) добавляет все значения заданного массива в конец списка с сохранением порядка;
        - Метод isInList(String toEquals) определяет, содержит ли список переданное в метод значение toEquals, или нет. 
          Возвращает true, если содержит и false, если такого значение в списке нет;
        - Метод isEmptyList(), определяет, является ли список пустым, или нет. 
          Возвращает true, если список пустой и false, если не пустой;
        - Метод printAll() - осуществляет печать всех значений списка от первого элемента к последнему; 
          Если список пустой, выводит сообщение "Элементы списка отсутствуют, список пустой.";
        - Метод printAllBack() - осуществляет печать всех значений списка в обратном порядке - от последнего элемента к первому; 
          Если список пустой, выводит сообщение "Элементы списка отсутствуют, список пустой.";
        - *Метод removeIfHas(String toRemove) удаляет из списка, переданное в метод значение toRemove. 
          Если значения в списке нет, то ничего не происходит; 
        - Метод mergeLists(DoublyList listToMerge). Список поглощает список listToMerge с добавлением значений в начало первого списка; после поглощения список listToMerge очищается;
        - Метод mergeListsBack(DoublyList listToMerge). Список поглощает список listToMerge с добавлением значений в конец первого списка; после поглощения список listToMerge очищается;
        - Метод mergeCollection(Collection<String> collection) добавляет все значения заданной коллекции collection в начало списка с сохранением порядка.
          Коллекция — любой объект, реализующий интерфейс java.lang.Iterable;
        - Метод mergeCollectionToEnd(Collection<String> collection) добавляет все значения заданной коллекции collection в конец списка с сохранением порядка.
          Коллекция — любой объект, реализующий интерфейс java.lang.Iterable;
*/        
    }
}
