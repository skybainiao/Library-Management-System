package File;

import Model.Book;
import Model.BookList;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Adapter
{
  private MyFileIO myFileIO;
  private String fileName;

  public Adapter(String fileName)
  {
    myFileIO = new MyFileIO();
    this.fileName = fileName;
  }

  public Book getBook(){
    Book book = new Book("","");

    try
    {
      book = (Book)myFileIO.read(fileName);
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File not found");
    }
    catch (IOException e)
    {
      System.out.println("IO Error reading file");
    }
    catch (ClassNotFoundException e)
    {
      System.out.println("Class Not Found");
    }
    return book;
  }

  public BookList getBookList(){
    BookList bookList = new BookList();

    try
    {
      bookList = (BookList)myFileIO.read(fileName);
    }
    catch (FileNotFoundException e)
    {
      e.printStackTrace();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    catch (ClassNotFoundException e)
    {
      e.printStackTrace();
    }

    return bookList;
  }

  public void addBook(String title,String writer) throws IOException
  {
    Book book = new Book(title,writer);
    myFileIO.write(fileName,book);
  }

  public void addBookList(String fileName,BookList bookList) throws IOException
  {
    myFileIO.write(fileName,bookList);
  }

}
