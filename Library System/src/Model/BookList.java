package Model;

import java.io.Serializable;
import java.util.ArrayList;

public class BookList implements Serializable{
  private ArrayList<Book> books;

  public BookList(){
    books=new ArrayList<>();
  }

  public ArrayList<Book> getBooks(){
    return books;
  }

  public void addBook(Book book){
    books.add(book);
  }

  public String getStringBooks(){
    String returnStr = "";

    for(int i = 0; i<books.size(); i++) {
      Book temp = books.get(i);

      returnStr += temp +"\n";
    }
    return returnStr;

  }


  public void removeBook(Book book){
    books.remove(book);
  }



}
