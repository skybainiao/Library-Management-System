import File.Adapter;
import Model.Book;
import Model.BookList;

import java.io.IOException;

public class Test
{
  public static void main(String[] args) throws IOException
  {
    Adapter adapter = new Adapter("book.bin");
    BookList bookList = new BookList();
    Book book = new Book("1","a");
    Book book1 = new Book("2","b");
    Book book2 = new Book("3","c");
    bookList.addBook(book);
    bookList.addBook(book1);
    bookList.addBook(book2);

    adapter.addBookList("book.bin",bookList);
    bookList.removeBook(book);
    adapter.addBookList("book.bin",bookList);

    System.out.println(adapter.getBookList().getStringBooks());
  }
}
