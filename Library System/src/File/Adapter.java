package File;

import Model.ArticleList;
import Model.BookList;
import Model.CDList;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;


public class Adapter{
  private MyFileIO myFileIO;
  private String fileName;

  public Adapter(String fileName){
    myFileIO = new MyFileIO();
    this.fileName = fileName;

  }


  public BookList getBookList(){
    BookList bookList = new BookList();

    try {
      bookList = (BookList)myFileIO.read(fileName);
    }
    catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    catch (IOException e) {
      e.printStackTrace();
    }
    catch (ClassNotFoundException e) {
      e.printStackTrace();
    }

    return bookList;
  }


  public void addBookList(BookList bookList) throws IOException {
    myFileIO.write(fileName,bookList);
  }


  public ArticleList getArticleList(){
    ArticleList articleList = new ArticleList();

    try {
      articleList = (ArticleList) myFileIO.read(fileName);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    return articleList;

  }


  public void addStrings(ArrayList<String> text) throws IOException {
    myFileIO.write(fileName,text);
  }

  public ArrayList<String> getString(){

    ArrayList<String> strings = new ArrayList<>();
    try {
      strings = (ArrayList<String>) myFileIO.read(fileName);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }

    return strings;
  }


  public void addArticleList(ArticleList articleList) throws IOException {
    myFileIO.write(fileName,articleList);
  }


  public CDList getCDList(){
    CDList cdList = new CDList();

    try {
      cdList = (CDList) myFileIO.read(fileName);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    return cdList;

  }


  public void addCDList(CDList cdList) throws IOException {
    myFileIO.write(fileName,cdList);
  }

}
