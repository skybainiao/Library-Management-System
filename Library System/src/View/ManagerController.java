package View;

import File.Adapter;
import Model.Article;
import Model.ArticleList;
import Model.Book;
import Model.BookList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

public class ManagerController {
  private Adapter adapter;

  private Adapter adapter1;

  private BookList bookList;

  private ArticleList articleList;

  @FXML
  private TextField title;

  @FXML
  private TextField writer;

  @FXML
  private TextField searchText;

  @FXML
  private Button search;

  @FXML
  private TextField releaseTime;

  @FXML
  private TextField ISBN;

  @FXML
  private ChoiceBox bookStatus;

  @FXML
  private Button save;

  @FXML
  private Button getAllBooks;

  @FXML
  private Button deleteBooks;

  @FXML
  private Button change;

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

  @FXML
  private TableColumn<Book,String> isbn;

  @FXML
  private ListView<Article> articleListView;

  @FXML
  private Button articleFresh;

  @FXML
  private TextField articleST;

  @FXML
  private Button articleS;

  @FXML
  private TextField artTT;

  @FXML
  private TextField artWT;

  @FXML
  private TextField artRelTimeT;

  @FXML
  private Button artSave;

  @FXML
  private Button artEdit;

  @FXML
  private Button artDel;

  @FXML
  private ChoiceBox artBox;


  public void init(){
    save.setText("Save");
    getAllBooks.setText("GetAll");
    deleteBooks.setText("Del");
    change.setText("Edit");
    search.setText("Search");
    articleFresh.setText("Refresh");
    artSave.setText("Save");
    artEdit.setText("Edit");
    artDel.setText("Del");
    articleS.setText("Search");
    bookStatus.getItems().addAll("Booked","Borrowed");
    artBox.getItems().addAll("Booked","Borrowed");
    adapter = new Adapter("library.bin");
    adapter1 = new Adapter("Article.bin");
    bookList = adapter.getBookList();
    articleList = adapter1.getArticleList();
    bookTableView.setEditable(true);
    articleListView.setEditable(true);
    bookTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
    bookWriter.setCellValueFactory(new PropertyValueFactory<>("writer"));
    bookReleaseTime.setCellValueFactory(new PropertyValueFactory<>("releaseTime"));
    statusOfBook.setCellValueFactory(new PropertyValueFactory<>("status"));
    isbn.setCellValueFactory(new PropertyValueFactory<>("ISBN"));
    getAllBooks();
    getAllArticles();

  }


  public void addBook() throws IOException {
    if (!title.getText().equals("") && !writer.getText().equals("")){
      if (bookStatus.getSelectionModel().getSelectedItem().toString()!= null){
        Book book = new Book(title.getText(),writer.getText(),releaseTime.getText(),
                bookStatus.getSelectionModel().getSelectedItem().toString(),
                null,null,null,null,null,ISBN.getText());

        bookList.addBook(book);
        adapter.addBookList(bookList);
        getAllBooks();
        clear();
      }
      else {
        JOptionPane.showMessageDialog(null,"Please select a type");
      }
    }
    else {
      JOptionPane.showMessageDialog(null,"TextField can not be null");
    }

  }


  public void getAllBooks() {
    ObservableList<Book> books = FXCollections.observableArrayList();
    books.addAll(adapter.getBookList().getBooks());
    bookTableView.setItems(books);

  }


  public void deleteBook() throws IOException {
    Book book = bookTableView.getSelectionModel().getSelectedItem();
    if (book != null){
      for (int i = 0; i < bookList.getBooks().size(); i++) {
        if (bookList.getBooks().get(i).getTitle().equals(book.getTitle()) &&
                bookList.getBooks().get(i).getWriter().equals(book.getWriter())){
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
    Book book = bookTableView.getSelectionModel().getSelectedItem();
    if (book != null){
      for (int i = 0; i < bookList.getBooks().size(); i++) {
        if (bookList.getBooks().get(i).getTitle().equals(book.getTitle()) &&
                bookList.getBooks().get(i).getWriter().equals(book.getWriter())){
          title.setText(bookList.getBooks().get(i).getTitle());
          writer.setText(bookList.getBooks().get(i).getWriter());
          releaseTime.setText(bookList.getBooks().get(i).getReleaseTime());
          ISBN.setText(bookList.getBooks().get(i).getISBN());
          bookList.removeBook(bookList.getBooks().get(i));
        }
      }
    }
  }


  public void searchBook(){
    if (searchText.getText() != null){
      for (int i = 0; i < bookList.getBooks().size(); i++) {
        if (bookList.getBooks().get(i).getTitle().equals(searchText.getText()) ||
                bookList.getBooks().get(i).getWriter().equals(searchText.getText())){
          ArrayList<Book> bookArrayList = new ArrayList<>();
          bookArrayList.add(bookList.getBooks().get(i));
          ObservableList books = FXCollections.observableArrayList();
          books.addAll(bookArrayList);
          bookTableView.setItems(books);
          searchText.setText("");
        }
      }
    }
    else {
      JOptionPane.showMessageDialog(null,"Please enter search context");
    }
  }


  public void addArticle() throws IOException {
    if (!artTT.getText().equals("") && !artWT.getText().equals("") && !artRelTimeT.getText().equals("")){
      Article article = new Article(artTT.getText(),artWT.getText(),artRelTimeT.getText(),
              artBox.getSelectionModel().getSelectedItem().toString(),
              null,null,null,null,null);

      articleList.add(article);
      adapter1.addArticleList(articleList);
      getAllArticles();
      artClear();
    }
    else {
      JOptionPane.showMessageDialog(null,"TextField can not be null");
    }
  }


  public void getAllArticles(){
    ObservableList<Article> articles = FXCollections.observableArrayList();
    articles.addAll(adapter1.getArticleList().getArticles());
    articleListView.setItems(articles);
  }


  public void deleteArticle() throws IOException {
    Article article = articleListView.getSelectionModel().getSelectedItem();
    if (article != null){
      for (int i = 0; i < articleList.getArticles().size(); i++) {
        if (articleList.getArticles().get(i).getTitle().equals(article.getTitle()) &&
                articleList.getArticles().get(i).getWriter().equals(article.getWriter())){
          articleList.remove(articleList.getArticles().get(i));
        }
      }
    }
    else {
      JOptionPane.showMessageDialog(null,"Please select an item");
    }
    adapter1.addArticleList(articleList);
    getAllArticles();

  }


  public void changeArticle(){
    Article article = articleListView.getSelectionModel().getSelectedItem();
    if (article != null){
      for (int i = 0; i < articleList.getArticles().size(); i++) {
        if (articleList.getArticles().get(i).getTitle().equals(article.getTitle()) &&
                articleList.getArticles().get(i).getWriter().equals(article.getWriter())){

          artTT.setText(articleList.getArticles().get(i).getTitle());
          artWT.setText(articleList.getArticles().get(i).getWriter());
          artRelTimeT.setText(articleList.getArticles().get(i).getReleaseTime());
          articleList.remove(articleList.getArticles().get(i));

        }
      }
    }
  }


  public void searchArticle(){
    if (articleST.getText() != null){
      for (int i = 0; i < articleList.getArticles().size(); i++) {
        if (articleList.getArticles().get(i).getTitle().equals(articleST.getText()) ||
                articleList.getArticles().get(i).getWriter().equals(articleST.getText())){
          ArrayList<Article> articlesArrayList = new ArrayList<>();
          articlesArrayList.add(articleList.getArticles().get(i));
          ObservableList articles = FXCollections.observableArrayList();
          articles.addAll(articlesArrayList);
          articleListView.setItems(articles);
          articleST.setText("");
        }
      }
    }
    else {
      JOptionPane.showMessageDialog(null,"Please enter search context");
    }
  }


  public void clear(){
    title.setText("");
    writer.setText("");
    releaseTime.setText("");
    ISBN.setText("");
  }


  public void artClear(){
    artTT.setText("");
    artWT.setText("");
    artRelTimeT.setText("");
  }

}
