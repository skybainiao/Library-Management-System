package View;

import File.Adapter;
import Model.Book;
import Model.BookList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Popup;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.ErrorManager;

public class Controller
{
  private Adapter adapter = new Adapter("book.bin");
  private BookList bookList = adapter.getBookList();

  @FXML
  private TextField title;

  @FXML
  private TextField writer;

  @FXML
  private Button save;

  @FXML
  private Button getAllBooks;

  @FXML
  private Button deleteBooks;

  @FXML
  private ListView<Book> listView = new ListView<>();

  public Controller(){
    getAllBooks();
  }


  public void addBook() throws IOException
  {
    if (!title.getText().equals("") && !writer.getText().equals("")){
      Book book = new Book(title.getText(),writer.getText());
      bookList.addBook(book);
      adapter.addBookList("book.bin",bookList);
      getAllBooks();
      title.setText("");
      writer.setText("");
    }
    else {
      //Dialog here
    }

  }


  public void getAllBooks()
  {
    ObservableList<Book> books = FXCollections.observableArrayList();
    books.addAll(adapter.getBookList().getBooks());
    listView.setItems(books);

  }


  public void deleteBook() throws IOException
  {
    listView.setEditable(true);
    Book book = listView.getSelectionModel().getSelectedItem();
    if (book != null){
      for (int i = 0; i < bookList.getBooks().size(); i++)
      {
        if (bookList.getBooks().get(i).getTitle().equals(book.getTitle()) && bookList.getBooks().get(i).getWriter().equals(book.getWriter())){
          bookList.removeBook(bookList.getBooks().get(i));
        }
      }
    }
    else {
      //Error Dialog
    }
    adapter.addBookList("book.bin",bookList);
    getAllBooks();

  }


}
