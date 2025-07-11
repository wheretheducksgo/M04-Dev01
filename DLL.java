
/**
 * Write a description of class DLL here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DLL<T extends Comparable<T>>{
  private Node<T> head;
  private Node<T> tail;
  private int size;
  public DLL(){
    head = null;
    tail = null;
    size = 0;
  }
  public Node<T> append(T data){
    Node<T> newNode = new Node<T>(data);
    if(head == null){
      head = newNode;
      tail = newNode;
    }else{
      tail.setNext(newNode);
      newNode.setPrev(tail);
      tail = newNode;
    }
    size++;
    return newNode;
  }
  
  public Node<T> insert(int location, T data){
    if(location < 0 || location > size){
      throw new IllegalArgumentException("Location not in list");
    }
    Node<T> newNode = new Node<T>(data);
    if(location == 0){
      newNode.setNext(head);
      head.setPrev(newNode);
      head = newNode;
    }else if(location == size){
      tail.setNext(newNode);
      newNode.setPrev(tail);
      tail = newNode;
    }else{
      Node<T> current = head;
      for(int i = 0; i < location; i++){
        current = current.getNext();
      }
      newNode.setNext(current);
      newNode.setPrev(current.getPrev());
      current.getPrev().setNext(newNode);
      current.setPrev(newNode);
    }
    size++;
    return newNode;
  }
  public Node<T> delete(int location){
    if(location < 0 || location >= size){
      throw new IllegalArgumentException("Location out of bounds");
    }
    Node<T> current = head;
    for(int i = 0; i < location; i++){
      current = current.getNext();
    }
    if(location == 0){
      head = head.getNext();
      head.setPrev(null);
    }else if(location == size - 1){
      tail = tail.getPrev();
      tail.setNext(null);
    }else{
      current.getPrev().setNext(current.getNext());
      current.getNext().setPrev(current.getPrev());
    }
    size--;
    return current;
  }
  public int getIndex(T data){
    Node<T> current = head;
    for(int i = 0; i < size; i++){
      if(current.getData().equals(data)){
        return i;
      }
      current = current.getNext();
    }
    return -1;
  }
  public String toString(){
    String result = "";
    Node<T> current = head;
    while(current != null){
      if (current != tail) {
        result += current.toString() + " <-> ";
        current = current.getNext();
      }
      else {
        result += current.toString() + " <-> null";
        current = current.getNext();
      }
    }
    return result;
  }
  public Node<T> shuffle() {
    Node<T> current = head;
    Node<T> temp = null;
    int index = 0;
    while (current != null) {
      index = (int) (Math.random() * size);
      temp = current;
      current = current.getNext();
      delete(index);
      insert(index, temp.getData());
    }
    return head;
  }
  public DLL<T> partition(T data){
    DLL<T> newList = new DLL<T>();
    Node<T> current = head;
    while(current != null){
      if(current.getData().compareTo(data) >= 0){
        newList.append(current.getData());
      }
      current = current.getNext();
    }
    return newList;
  }
}
