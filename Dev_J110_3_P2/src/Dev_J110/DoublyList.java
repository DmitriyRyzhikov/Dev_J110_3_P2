
package Dev_J110;

import java.util.Collection;

public class DoublyList {

    private Node first;
    private Node last;
    
    //Ниже вспомогательные методы, используемые в методах, написание которых - цель работы:
    
    //Метод для реверса массива
    public String[] reverse(String[] list) {
        String[] result = new String[list.length];
        for (int i = 0, j = result.length - 1; i < list.length; i++, j--) {
             result[j] = list[i]; }
        return result;
    }
    //Метод для очистки списка
    public void erasingList() {
        if (!isEmpty()) {
            first = null;
            last = null;  }         
    }
    //Метод, возвращающий количество элементов списка.
    public int counter() {
        Node current = first;
        if (isEmpty()) {
            return 0;
        } else if (current.next == null) {
            return 1;
        } else {
            int count = 0;
            while (current.next != null) {
                current = current.next;
                count++;
                if (current.next == null) {
                    count++; }
            }
            return count;
        }
    }
    //Далее методы, написать которые требуется в задании работы:
    
    //Метод, определяющий, является ли список пустым, или нет;    
    public boolean isEmpty() {
        return first == null;
    } 
   
    //Метод добавляет значения в начало списка.
    public void addFirst(String data) {

        Node newNode = new Node();
        newNode.data = data;
        if(isEmpty()) {
            first = newNode;
            last = newNode; }
        else {
            newNode.next = first;
            first.prev = newNode;
            first = newNode; }
    }    
    //Метод добавляет данные в начало списка из массива с сохранением порядка.
    public void addFromArrayFirst(String[] data) {
        for(String s : reverse(data)) {
            addFirst(s); 
        }
    }
    //извлечение значения из начала списка без его удаления из списка
    public String extractFirst() {
        if (!isEmpty())
            return first.data;
        else
            throw new NullPointerException("Список пустой.");       
    }

    //Извлечение значения из начала списка с удалением его из списка
    public String extractFirstAndRemove() {
        if (!isEmpty() && last.prev != null) {
            String data = first.data;
            first = first.next;
            first.prev = null;
            return data;  }
        else if(!isEmpty() && first.next == null) {
            String data = first.data;
            first = first.next;
            return data; }
        else
            throw new NullPointerException("Список пустой.");
    }

    //добавление значения в конец списка
    public void addToEnd(String data) {
        Node newNode = new Node();
        newNode.data = data;
        if (isEmpty()) 
            addFirst(data);
        else {
            newNode.prev = last;
            last.next = newNode;
            last = newNode;  }        
    }

    //извлечение значения из конца списка без его удаления
    public String extractFromEnd() {
        if (!isEmpty()) {
            return last.data; }        
        else
            throw new NullPointerException("Список пустой.");   
    }

    //извлечение значения из конца списка с удалением
    public String extractFromEndAndRemove() {
        
        if (!isEmpty() && last.prev != null) {
            String data = last.data;
            last = last.prev;
            last.next = null;
            return data;  }
        else if(!isEmpty() && first.next == null) {
            String data = first.data;
            first = first.next;
            return data; }
        else
            throw new NullPointerException("Список пустой.");
    }
    
    //добавление всех значений заданного массива в конец списка с сохранением порядка;
    public void addFromArrayEnd(String[] data) {
        for(String s : data) {
            addToEnd(s); 
        }
    }
      
    //Метод, определяющий, содержит ли список заданное значение, или нет
    public boolean isInList(String toEquals) {
        
        Node current = first;
        Boolean result = false;
        
        if (isEmpty()) 
            return false;
        else if (current.next == null) {
            return toEquals.equals(current.data);
        } 
        else {        
            while (current.next != null) {
                if (toEquals.equals(current.data)) {
                    result = true;
                    current = current.next; }
                else 
                    current = current.next;                
            }
            if (toEquals.equals(current.data)) 
                result = true;            
        return result;
        }
    }

    //печать всех значений списка по порядку
    public void printAll() {
        Node current = first;
        if (isEmpty()) {
            System.out.println("Элементы списка отсутствуют, список пустой.");
        } else if (current.next == null) {
            current.printData();
            System.out.println();
        } else {
            while (current.next != null) {
                current.printData();
                current = current.next;
                if (current.next == null) {
                    current.printData();
                }
            }
            System.out.println();
        }
    }
    
    //печать всех значений списка в обратном порядке
    public void printAllBack() {
        Node current = last;
        if (isEmpty()) {
            System.out.println("Элементы списка отсутствуют, список пустой.");
        } else if (current.prev == null) {
            current.printData();
            System.out.println();
        } else {
            while (current.prev != null) {
                current.printData();
                current = current.prev;
                if (current.prev == null) {
                    current.printData();
                }
            }
            System.out.println();
        }
    }

    //*Метод удаляющий заданное значение из списка; если значения в списке нет, то ничего происходить не должно.
    public void removeIfHas(String toRemove) {

        if (!isEmpty()) {
            if (first.next != null) {
                if (toRemove.equals(first.data)) {
                    first = first.next;
                    first.prev = null;
                    //return; 
                }
                if(toRemove.equals(last.data)) {
                    last = last.prev;
                    last.next = null;
                    //return;
                }
                Node current = first;
                while (current.next != null) {
                    if (toRemove.equals(current.next.data)) {
                        current.next = current.next.next;
                        current.next.prev = current.next.prev.prev;
                        //return; 
                        //Сейчас удаляет все одинаковые искомые элементы, если одинаковых искомых элементов несколько. 
                        //Если нужно удалить единожды первый встретившийся - убрать коммент со всех return.
                    } 
                    else {
                        current = current.next;
                    }
                }
            } 
            else {
                if (toRemove.equals(first.data)) {
                    first = null;
                }
            }
        }
    }    
    
    //поглощение списка другим списком с добавлением значений второго в начало первого списка; после поглощения второй список должен очищаться;
    public void mergeLists(DoublyList listToMerge) {
        if(!listToMerge.isEmpty()) { 
           String[] temp = new String[listToMerge.counter()];
           Node current = listToMerge.first;
           temp[0] = current.data;
                  int i = 1;
                  while(current.next != listToMerge.last) {   
                   temp[i] = current.next.data;
                   current = current.next;
                   i++;
                   if(current.next == listToMerge.last)
                       temp[temp.length - 1] = listToMerge.last.data;
                  }           
            addFromArrayFirst(temp);
            listToMerge.erasingList();
        }          
    }    
    
    //поглощение списка другим списком с добавлением значений второго в конец первого списка; после поглощения второй список должен очищаться;
    
    public void mergeListsBack(DoublyList listToMerge) {
        if(!listToMerge.isEmpty()) { 
           String[] temp = new String[listToMerge.counter()];
           Node current = listToMerge.first;
           temp[0] = current.data;
                  int i = 1;
                  while(current.next != listToMerge.last) {   
                   temp[i] = current.next.data;
                   current = current.next;
                   i++;
                   if(current.next == listToMerge.last)
                       temp[temp.length - 1] = listToMerge.last.data;
                  }           
            addFromArrayEnd(temp);
            listToMerge.erasingList();
        }          
    } 
    
    //добавление всех значений заданной коллекции в начало списка с сохранением порядка; 
    //коллекция — любой объект, реализующий интерфейс java.lang.Iterable;
    
    public void mergeCollection(Collection<String> collection) {
        String[] temp = collection.toArray(new String[0]);
        addFromArrayFirst(temp);
    }
    
    //добавление всех значений заданной коллекции в конец списка с сохранением порядка; 
    //коллекция — любой объект, реализующий интерфейс java.lang.Iterable;
    
    public void mergeCollectionToEnd(Collection<String> collection) {
        String[] temp = collection.toArray(new String[0]);
        addFromArrayEnd(temp);  
    }
     
    // вложенный класс Node  в сущностях которого хранятся данные и ссылка на следующий узел.
    class Node {

        public String data;
        public Node next;
        public Node prev;

        public void printData() {
            System.out.print(data + "; ");
        }
    }
}
    

