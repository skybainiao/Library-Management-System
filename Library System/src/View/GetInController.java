package View;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class GetInController {

    private ViewHandler viewHandler;

    @FXML
    private Button librarian;

    @FXML
    private Button borrow;


    public void init(ViewHandler viewHandler){
        this.viewHandler=viewHandler;
        librarian.setText("Im librarian");
        borrow.setText("Borrow book");
    }

    public void openMangerView(){
        viewHandler.openManagerView();
    }

    public void openBorrowView(){
        viewHandler.openBorrowView();
    }

}
