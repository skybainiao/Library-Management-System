package View;

import File.Adapter;
import Model.Book;
import Model.BookList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import javax.swing.*;
import java.io.IOException;

public class ManagerController {
  private Adapter adapter = new Adapter("library.bin");
  private BookList bookList;

  @FXML
  private TextField title;

  @FXML
  private TextField writer;

  @FXML
  private TextField releaseTime;

  @FXML
  private TextField status;

  @FXML
  private ChoiceBox bookStatus;

  @FXML
  private Button save;

  @FXML
  private Button getAllBooks;

  @FXML
  private Button deleteBooks;

  @FXML
  private ListView<Book> listView;

  @FXML
  private TableView<Book> bookTableView;

  @FXML
  private TableColumn<Book,String> bookTitle;

  @FXML
  private TableColumn<Book,String> bookWriter;

  @FXML
  private TableColumn<Book,String> bookReleaseTime;

  @FXML
  private TableColumn<Book,String> statusOfBook;


  public void init(){
    bookStatus.getItems().addAll("Booked","Borrowed");
    bookStatus.getSelectionModel().selectFirst();
    bookList = adapter.getBookList();
    getAllBooks();
  }


  public void addBook() throws IOException {
    if (!title.getText().equals("") && !writer.getText().equals("")){
      Book book = new Book(title.getText(),writer.getText(),releaseTime.getText(),
              bookStatus.getSelectionModel().getSelectedItem().toString(),
              null,null,null,null,null);

      bookList.addBook(book);
      adapter.addBookList(bookList);
      getAllBooks();
      title.setText("");
      writer.setText("");
      releaseTime.setText("");
    }
    else {
      JOptionPane.showMessageDialog(null,"Invalid title or writer");
    }

  }


  public void getAllBooks() {
    ObservableList<Book> books = FXCollections.observableArrayList();
    books.addAll(adapter.getBookList().getBooks());
    listView.setItems(books);

  }


  public void deleteBook() throws IOException {
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
      JOptionPane.showMessageDialog(null,"Please select an item");
    }
    adapter.addBookList(bookList);
    getAllBooks();

  }


  public void changeBook(){

  }


}
