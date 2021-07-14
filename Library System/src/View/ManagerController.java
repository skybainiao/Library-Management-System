package View;

import File.Adapter;
import Model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ManagerController {

  private ViewHandler viewHandler;

  private Adapter adapter;

  private Adapter adapter1;

  private Adapter adapter2;

  private Adapter adapter3;

  private Adapter adapter4;

  private BookList bookList;

  private ArticleList articleList;

  private CDList cdList;

  private ArrayList<String> strings;

  private ArrayList<String> stringsX;

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

  @FXML
  private Label labelA;

  @FXML
  private Label labelA1;

  @FXML
  private ChoiceBox img1;

  @FXML
  private Button img1But;

  @FXML
  private Label labelB;

  @FXML
  private Label labelB1;

  @FXML
  private ChoiceBox img2;

  @FXML
  private Button img2But;

  @FXML
  private Label labelC;

  @FXML
  private Label labelC1;

  @FXML
  private ChoiceBox img3;

  @FXML
  private Button img3But;

  @FXML
  private Label labelD;

  @FXML
  private Label labelD1;

  @FXML
  private ChoiceBox img4;

  @FXML
  private Button img4But;

  @FXML
  private Label labelE;

  @FXML
  private Label labelE1;

  @FXML
  private ChoiceBox img5;

  @FXML
  private Button img5But;

  @FXML
  private Label labelF;

  @FXML
  private Label labelF1;

  @FXML
  private ChoiceBox img6;

  @FXML
  private Button img6But;

  @FXML
  private TextField img1TF;

  @FXML
  private TextField img2TF;

  @FXML
  private TextField img3TF;

  @FXML
  private TextField img4TF;

  @FXML
  private TextField img5TF;

  @FXML
  private TextField img6TF;

  @FXML
  private ImageView imgA;

  @FXML
  private ImageView imgB;

  @FXML
  private ImageView imgC;

  @FXML
  private ImageView imgD;

  @FXML
  private ImageView imgE;

  @FXML
  private ImageView imgF;

  @FXML
  private TextArea logs;

  @FXML
  private TextArea logsX;


  //initialization
  public void init(ViewHandler viewHandler){
    this.viewHandler=viewHandler;

    save.setText("Save");
    getAllBooks.setText("Refresh");
    deleteBooks.setText("Del");
    change.setText("Edit");
    search.setText("Search");
    articleFresh.setText("Refresh");
    artSave.setText("Save");
    artEdit.setText("Edit");
    artDel.setText("Del");
    articleS.setText("Search");
    img1But.setText("Save");
    img2But.setText("Save");
    img3But.setText("Save");
    img4But.setText("Save");
    img5But.setText("Save");
    img6But.setText("Save");

    bookStatus.getItems().addAll("Booked","Borrowed","Available");
    artBox.getItems().addAll("Booked","Borrowed","Available");
    img1.getItems().addAll("Booked","Borrowed","Available");
    img2.getItems().addAll("Booked","Borrowed","Available");
    img3.getItems().addAll("Booked","Borrowed","Available");
    img4.getItems().addAll("Booked","Borrowed","Available");
    img5.getItems().addAll("Booked","Borrowed","Available");
    img6.getItems().addAll("Booked","Borrowed","Available");

    adapter = new Adapter("library.bin");
    adapter1 = new Adapter("Article.bin");
    adapter2 = new Adapter("CD.bin");
    adapter3 = new Adapter("String.bin");
    adapter4 = new Adapter("StringX.bin");

    bookList = adapter.getBookList();
    articleList = adapter1.getArticleList();
    cdList = adapter2.getCDList();
    strings = adapter3.getString();
    stringsX = adapter4.getString();

    bookTableView.setEditable(true);
    articleListView.setEditable(true);

    bookTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
    bookWriter.setCellValueFactory(new PropertyValueFactory<>("writer"));
    bookReleaseTime.setCellValueFactory(new PropertyValueFactory<>("releaseTime"));
    statusOfBook.setCellValueFactory(new PropertyValueFactory<>("status"));
    isbn.setCellValueFactory(new PropertyValueFactory<>("ISBN"));

    getAllBooks();
    getAllArticles();
    setAllCDs();
    changeCDInfo();
    getAllLogs();
    getManagerLogs();

    bookTableView.setRowFactory(bookTableView1 -> {
      TableRow<Book> row = new TableRow<>();
      row.setOnMouseClicked(mouseEvent -> {
        if (mouseEvent.getClickCount() == 2 && !row.isEmpty()){
          Book book = row.getItem();
          viewHandler.openDetailView(book);
        }
      });
      return row;
    });

  }


  //add book to book.bin
  public void addBook() throws IOException {
    if (!title.getText().equals("") && !writer.getText().equals("")){
      if (bookStatus.getSelectionModel().getSelectedItem().toString()!= null){
        Book book = new Book(title.getText(),writer.getText(),releaseTime.getText(),
                bookStatus.getSelectionModel().getSelectedItem().toString(),
                null,null,null,null,null,ISBN.getText());

        bookList.addBook(book);
        adapter.addBookList(bookList);
        stringsX.add(" "+getTime()+":     "+"Manager added a book: "+"<"+book.getTitle()+">");
        adapter4.addStrings(stringsX);
        getManagerLogs();
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


  //set books to TableView
  public void getAllBooks() {
    ObservableList<Book> books = FXCollections.observableArrayList();
    books.addAll(adapter.getBookList().getBooks());
    bookTableView.setItems(books);

  }


  //choose a book and delete
  public void deleteBook() throws IOException {
    Book book = bookTableView.getSelectionModel().getSelectedItem();
    if (book != null){
      for (int i = 0; i < bookList.getBooks().size(); i++) {
        if (bookList.getBooks().get(i).getTitle().equals(book.getTitle()) &&
                bookList.getBooks().get(i).getWriter().equals(book.getWriter())){
          bookList.removeBook(bookList.getBooks().get(i));
          stringsX.add(" "+getTime()+":     "+"Manager deleted a book: "+"<"+book.getTitle()+">");
          adapter4.addStrings(stringsX);
          getManagerLogs();
        }
      }
    }
    else {
      JOptionPane.showMessageDialog(null,"Please select an item");
    }
    adapter.addBookList(bookList);
    getAllBooks();

  }


  //edit the information of the selected book
  public void changeBook() throws IOException {
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
          stringsX.add(" "+getTime()+":     "+"Manager edited a book: "+"<"+book.getTitle()+">");
          adapter4.addStrings(stringsX);
          getManagerLogs();
        }
      }
    }
  }


  //search book by bookTitle and bookWriter
  public void searchBook() throws IOException {
    ArrayList<Book> bookArrayList = new ArrayList<>();

    if (searchText.getText() != null){
      for (int i = 0; i < bookList.getBooks().size(); i++) {
        if (bookList.getBooks().get(i).getReleaseTime().equals(searchText.getText())
                || bookList.getBooks().get(i).getTitle().equals(searchText.getText())
                || bookList.getBooks().get(i).getWriter().equals(searchText.getText())
                || bookList.getBooks().get(i).getISBN().equals(searchText.getText())){
          try {
            System.out.println(bookList.getBooks().get(i));
            bookArrayList.add(bookList.getBooks().get(i));
            ObservableList books = FXCollections.observableArrayList();
            books.addAll(bookArrayList);
            bookTableView.setItems(books);
            stringsX.add(" "+getTime()+":     "+"Manager searched a book by: "+searchText.getText());
            adapter4.addStrings(stringsX);
            getManagerLogs();
          }
          catch (Exception e){
            System.out.println("no book found");
          }
        }
        else {
          System.out.println("Searched: "+i);
        }
      }
      searchText.setText("");
    }
    else {
      JOptionPane.showMessageDialog(null,"Please enter search context");
    }
  }


  //add article to article.bin
  public void addArticle() throws IOException {
    if (!artTT.getText().equals("") && !artWT.getText().equals("") && !artRelTimeT.getText().equals("")){
      if (artBox.getSelectionModel().getSelectedItem() != null){
        Article article = new Article(artTT.getText(),artWT.getText(),artRelTimeT.getText(),
                artBox.getSelectionModel().getSelectedItem().toString(),
                null,null,null,null,null);

        articleList.add(article);
        adapter1.addArticleList(articleList);
        stringsX.add(" "+getTime()+":     "+"Manager added a article: "+"<"+article.getTitle()+">");
        adapter4.addStrings(stringsX);
        getManagerLogs();
        getAllArticles();
        artClear();
      }
      else {
        JOptionPane.showMessageDialog(null,"please select status");
      }
    }
    else {
      JOptionPane.showMessageDialog(null,"TextField can not be null");
    }
  }


  //set articles to articleListView
  public void getAllArticles(){
    ObservableList<Article> articles = FXCollections.observableArrayList();
    articles.addAll(adapter1.getArticleList().getArticles());
    articleListView.setItems(articles);
  }


  //delete an article by selected one
  public void deleteArticle() throws IOException {
    Article article = articleListView.getSelectionModel().getSelectedItem();
    if (article != null){
      for (int i = 0; i < articleList.getArticles().size(); i++) {
        if (articleList.getArticles().get(i).getTitle().equals(article.getTitle()) &&
                articleList.getArticles().get(i).getWriter().equals(article.getWriter())){
          articleList.remove(articleList.getArticles().get(i));
          stringsX.add(" "+getTime()+":     "+"Manager deleted a book: "+"<"+article.getTitle()+">");
          adapter4.addStrings(stringsX);
          getManagerLogs();
        }
      }
    }
    else {
      JOptionPane.showMessageDialog(null,"Please select an item");
    }
    adapter1.addArticleList(articleList);
    getAllArticles();

  }


  //edit info of article
  public void changeArticle() throws IOException {
    Article article = articleListView.getSelectionModel().getSelectedItem();
    if (article != null){
      for (int i = 0; i < articleList.getArticles().size(); i++) {
        if (articleList.getArticles().get(i).getTitle().equals(article.getTitle()) &&
                articleList.getArticles().get(i).getWriter().equals(article.getWriter())){

          artTT.setText(articleList.getArticles().get(i).getTitle());
          artWT.setText(articleList.getArticles().get(i).getWriter());
          artRelTimeT.setText(articleList.getArticles().get(i).getReleaseTime());
          articleList.remove(articleList.getArticles().get(i));
          stringsX.add(" "+getTime()+":     "+"Manager edited a book: "+"<"+article.getTitle()+">");
          adapter4.addStrings(stringsX);
          getManagerLogs();

        }
      }
    }
  }


  //search article in article.bin by title and writer
  public void searchArticle(){
    ArrayList<Article> articlesArrayList = new ArrayList<>();

    if (articleST.getText() != null){
      for (int i = 0; i < articleList.getArticles().size(); i++) {
        if (articleList.getArticles().get(i).getTitle().equals(articleST.getText()) ||
                articleList.getArticles().get(i).getWriter().equals(articleST.getText()) ||
                articleList.getArticles().get(i).getReleaseTime().equals(articleST.getText())){
          try {
            articlesArrayList.add(articleList.getArticles().get(i));
            ObservableList articles = FXCollections.observableArrayList();
            articles.addAll(articlesArrayList);
            articleListView.setItems(articles);
            stringsX.add(" "+getTime()+":     "+"Manager searched a article by: "+articleST.getText());
            adapter4.addStrings(stringsX);
            getManagerLogs();
          }
          catch (Exception e){
            System.out.println("no article found");
          }
        }
      }
      articleST.setText("");
    }
    else {
      JOptionPane.showMessageDialog(null,"Please enter search context");
    }
  }


  //cdData initialization
  public void setAllCDs(){
      for (int i = 0; i < cdList.getCdArrayList().size(); i++) {
          if (cdList.getCdArrayList().get(i) != null){
            labelA.setText("< "+cdList.getCdArrayList().get(0).getName()+" >");
            labelA1.setText(cdList.getCdArrayList().get(0).getStatus());

            labelB.setText("< "+cdList.getCdArrayList().get(1).getName()+" >");
            labelB1.setText(cdList.getCdArrayList().get(1).getStatus());

            labelC.setText("< "+cdList.getCdArrayList().get(2).getName()+" >");
            labelC1.setText(cdList.getCdArrayList().get(2).getStatus());

            labelD.setText("< "+cdList.getCdArrayList().get(3).getName()+" >");
            labelD1.setText(cdList.getCdArrayList().get(3).getStatus());

            labelE.setText("< "+cdList.getCdArrayList().get(4).getName()+" >");
            labelE1.setText(cdList.getCdArrayList().get(4).getStatus());

            labelF.setText("< "+cdList.getCdArrayList().get(5).getName()+" >");
            labelF1.setText(cdList.getCdArrayList().get(5).getStatus());
          }
      }
  }


  //edit info of cds
  public void changeCDInfo(){

    img1But.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent actionEvent) {
        if (img1TF != null){
          labelA.setText("< "+img1TF.getText()+" >");
        }
        try {
          labelA1.setText(img1.getSelectionModel().getSelectedItem().toString());
        }
        catch (Exception e){
          JOptionPane.showMessageDialog(null,"Please select status");
        }
        img1TF.setText("");
      }
    });

    img2But.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent actionEvent) {
        if (img2TF != null){
          labelB.setText(img2TF.getText());
        }
        try {
          labelB1.setText(img2.getSelectionModel().getSelectedItem().toString());
        }
        catch (Exception e){
          JOptionPane.showMessageDialog(null,"Please select status");
        }
        img2TF.setText("");
      }
    });

    img3But.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent actionEvent) {
        if (img3TF != null){
          labelC.setText(img3TF.getText());
        }
        try {
          labelC1.setText(img3.getSelectionModel().getSelectedItem().toString());
        }
        catch (Exception e){
          JOptionPane.showMessageDialog(null,"Please select status");
        }
        img3TF.setText("");
      }
    });

    img4But.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent actionEvent) {
        if (img4TF != null){
          labelD.setText(img4TF.getText());
        }
        try {
          labelD1.setText(img4.getSelectionModel().getSelectedItem().toString());
        }
        catch (Exception e){
          JOptionPane.showMessageDialog(null,"Please select status");
        }
        img4TF.setText("");
      }
    });

    img5But.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent actionEvent) {
        if (img5TF != null){
          labelE.setText(img5TF.getText());
        }
        try {
          labelE1.setText(img5.getSelectionModel().getSelectedItem().toString());
        }
        catch (Exception e){
          JOptionPane.showMessageDialog(null,"Please select status");
        }
        img5TF.setText("");
      }
    });

    img6But.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent actionEvent) {
        if (img6TF != null){
          labelF.setText(img6TF.getText());
        }
        try {
          labelF1.setText(img6.getSelectionModel().getSelectedItem().toString());
        }
        catch (Exception e){
          JOptionPane.showMessageDialog(null,"Please select status");
        }
        img6TF.setText("");
      }
    });

  }


  //choose image from location
  public Image getImage(){
    FileChooser fileChooser = new FileChooser();
    File file = fileChooser.showOpenDialog(new Stage());
    Image image = new Image("file:"+file.getAbsolutePath());

    return image;
  }


  //set img1
  public void chooseImg1(){
    try {
      imgA.setImage(getImage());
    }
    catch (Exception e){
      System.out.println("No picture is set");
    }

  }


  //set img2
  public void chooseImg2(){
    try {
      imgB.setImage(getImage());
    }
    catch (Exception e){
      System.out.println("No picture is set");
    }

  }


  //set img3
  public void chooseImg3(){
    try {
      imgC.setImage(getImage());
    }
    catch (Exception e){
      System.out.println("No picture is set");
    }

  }


  //set img4
  public void chooseImg4(){
    try {
      imgD.setImage(getImage());
    }
    catch (Exception e){
      System.out.println("No picture is set");
    }

  }


  //set img5
  public void chooseImg5(){
    try {
      imgE.setImage(getImage());
    }
    catch (Exception e){
      System.out.println("No picture is set");
    }

  }


  //set img6
  public void chooseImg6(){
    try {
      imgF.setImage(getImage());
    }
    catch (Exception e){
      System.out.println("No picture is set");
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


  public void getAllLogs(){
    String str = "";

    for (int i = 0; i<strings.size(); i++) {
      String temp = strings.get(i);
      str += temp +"\n";
      logs.setText(str);
    }

  }


  public void getManagerLogs(){
    String str = "";

    for (int i = 0; i < stringsX.size(); i++) {
      String temp = stringsX.get(i);
      str += temp +"\n";
      logsX.setText(str);
    }
  }


  public String getTime(){
    LocalDateTime dateTime = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    return dateTime.format(formatter);
  }



}
