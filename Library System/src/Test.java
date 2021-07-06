import File.Adapter;
import Model.Book;
import Model.BookList;

import java.io.IOException;

public class Test {
  public static void main(String[] args) throws IOException {
    Adapter adapter = new Adapter("library.bin");
    BookList bookList = new BookList();
    Book book = new Book("1","a","12","released",null,null,null,null,null);
    Book book1 = new Book("1","a","12","released",null,null,null,null,null);
    Book book2 = new Book("1","a","12","released",null,null,null,null,null);
    bookList.addBook(book);
    bookList.addBook(book1);
    bookList.addBook(book2);

    adapter.addBookList(bookList);
    bookList.removeBook(book);
    adapter.addBookList(bookList);

    System.out.println(adapter.getBookList().getStringBooks());
  }
}
