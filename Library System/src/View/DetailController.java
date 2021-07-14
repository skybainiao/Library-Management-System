package View;

import Model.Book;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class DetailController {

    @FXML
    private Label title;

    @FXML
    private Label writer;

    @FXML
    private Label name;

    @FXML
    private Label email;

    @FXML
    private Label identify;

    @FXML
    private Label startTime;

    @FXML
    private Label endTime;

    private Book book;


    public void init(){
        Platform.runLater(()->{
            title.setText("Book Title  <"+book.getTitle()+">");
            writer.setText("Book Writer:  "+book.getWriter());
            name.setText("Borrower name: "+book.getName());
            email.setText("Email: "+book.getEmail());
            identify.setText("Identify: "+book.getIdentity());
            startTime.setText("Borrow Time: "+book.getBorrowTime());
            endTime.setText("Return Time: "+book.getReturnTime());
        });

    }


    public void setBook(Book book){
        this.book=book;
    }




}
