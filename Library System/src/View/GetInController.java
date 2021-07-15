package View;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class GetInController {

    private ViewHandler viewHandler;

    @FXML
    private Button librarian;

    @FXML
    private Button borrow;

    @FXML
    private ImageView imageView;


    public void init(ViewHandler viewHandler){
        this.viewHandler=viewHandler;
        librarian.setText("Im librarian");
        borrow.setText("Im borrower");
        imageView.setImage(new Image("picture/t.jpeg"));
    }

    public void openMangerView(){
        viewHandler.openManagerView();
    }

    public void openBorrowView(){
        viewHandler.openBorrowView();
    }

}
