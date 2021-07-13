package View;

import File.Adapter;
import Model.Book;
import Model.BookList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.*;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public class BorrowerController {

    private Adapter adapter;

    private Adapter adapter1;

    private BookList bookList;

    private ArrayList<String> strings;

    @FXML
    private Button refresh;

    @FXML
    private Button search;

    @FXML
    private Button booking;

    @FXML
    private Button borrow;

    @FXML
    private TextField searchText;

    @FXML
    private TextField name;

    @FXML
    private TextField email;

    @FXML
    private ChoiceBox identity;

    @FXML
    private TextField borrowTime;

    @FXML
    private TextField returnTime;

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
    private Label tip;


    public void init(){
        search.setText("Search");
        refresh.setText("Refresh");
        booking.setText("Book");
        borrow.setText("Borrow");
        tip.setText("Students can borrow books for 1 month, and lecturers can borrow books for 6 months");
        identity.getItems().addAll("Lecturer","Student");
        adapter = new Adapter("library.bin");
        adapter1 = new Adapter("String.bin");
        bookTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        bookWriter.setCellValueFactory(new PropertyValueFactory<>("writer"));
        bookReleaseTime.setCellValueFactory(new PropertyValueFactory<>("releaseTime"));
        statusOfBook.setCellValueFactory(new PropertyValueFactory<>("status"));
        isbn.setCellValueFactory(new PropertyValueFactory<>("ISBN"));
        bookList = adapter.getBookList();
        strings = adapter1.getString();
        getAllBooks();
    }


    public void getAllBooks() {
        ObservableList<Book> books = FXCollections.observableArrayList();
        books.addAll(adapter.getBookList().getBooks());
        bookTableView.setItems(books);
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


    public void book() throws IOException {
        Book book = bookTableView.getSelectionModel().getSelectedItem();
        if (book != null){
            for (int i = 0; i < bookList.getBooks().size(); i++) {
                if (bookList.getBooks().get(i).getTitle().equals(book.getTitle()) &&
                        bookList.getBooks().get(i).getWriter().equals(book.getWriter())){
                    bookList.removeBook(bookList.getBooks().get(i));
                    Book newBook = new Book(book.getTitle(),book.getWriter(),book.getReleaseTime(),book.getStatus(),
                            name.getText(),email.getText(),identity.getSelectionModel().getSelectedItem().toString(),
                            borrowTime.getText(),returnTime.getText(),book.getISBN());

                    bookList.addBook(newBook);
                    adapter.addBookList(bookList);
                    LocalDateTime dateTime = LocalDateTime.now();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                    strings.add(" "+dateTime.format(formatter)+":     "+identity.getSelectionModel().getSelectedItem().toString()+": "+name.getText()+"    booked    "+"<"+book.getTitle()+">");
                    adapter1.addStrings(strings);
                    System.out.println("Successfully booked");
                    clear();
                    //JOptionPane.showMessageDialog(null,"Successfully booked");
                    break;
                }
            }
        }
    }


    public void borrow() throws IOException {
        Book book = bookTableView.getSelectionModel().getSelectedItem();
        if (book != null){
            for (int i = 0; i < bookList.getBooks().size(); i++) {
                if (bookList.getBooks().get(i).getTitle().equals(book.getTitle()) &&
                        bookList.getBooks().get(i).getWriter().equals(book.getWriter())){
                    bookList.removeBook(bookList.getBooks().get(i));
                    Book newBook = new Book(book.getTitle(),book.getWriter(),book.getReleaseTime(),book.getStatus(),
                            name.getText(),email.getText(),identity.getSelectionModel().getSelectedItem().toString(),
                            borrowTime.getText(),returnTime.getText(),book.getISBN());

                    bookList.addBook(newBook);
                    adapter.addBookList(bookList);
                    LocalDateTime dateTime = LocalDateTime.now();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                    strings.add(" "+dateTime.format(formatter)+":     "+identity.getSelectionModel().getSelectedItem().toString()+": "+name.getText()+"    borrowed    "+"<"+book.getTitle()+">");
                    adapter1.addStrings(strings);
                    System.out.println("Successfully borrowed");
                    clear();
                    //JOptionPane.showMessageDialog(null,"Successfully borrowed");
                    break;
                }
            }
        }
    }


    public void clear(){
        name.setText("");
        email.setText("");
        borrowTime.setText("");
        returnTime.setText("");
    }








}
