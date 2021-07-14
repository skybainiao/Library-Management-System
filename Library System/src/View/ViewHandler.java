package View;

import Model.Book;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewHandler {

  private Stage mainStage;

  public ViewHandler(){
    mainStage = new Stage();
  }

  private Scene manager;
  public void openManagerView(){
    try {
      FXMLLoader loader=new FXMLLoader();
      loader.setLocation(getClass().getResource("ManagerController.fxml"));
      Parent root=loader.load();
      ManagerController managerController=loader.getController();
      managerController.init(this);
      mainStage.setTitle("Manager");
      manager=new Scene(root);
    }
    catch (IOException e){
      e.printStackTrace();
    }
    mainStage.setScene(manager);
    mainStage.show();
  }

  private Scene getIn;
  public void openGetInView(){
    try {
      FXMLLoader loader=new FXMLLoader();
      loader.setLocation(getClass().getResource("GetInController.fxml"));
      Parent root=loader.load();
      GetInController getInController = loader.getController();
      getInController.init(this);
      mainStage.setTitle("GetIn");
      getIn=new Scene(root);
    }
    catch (IOException e){
      e.printStackTrace();
    }
    mainStage.setScene(getIn);
    mainStage.show();
  }

  private Scene borrow;
  public void openBorrowView(){
    try {
      FXMLLoader loader=new FXMLLoader();
      loader.setLocation(getClass().getResource("BorrowerController.fxml"));
      Parent root=loader.load();
      BorrowerController borrowerController = loader.getController();
      borrowerController.init();
      mainStage.setTitle("Borrow");
      borrow=new Scene(root);
    }
    catch (IOException e){
      e.printStackTrace();
    }
    mainStage.setScene(borrow);
    mainStage.show();
  }


  private Stage stage = new Stage();
  private Scene detail;
  public void openDetailView(Book book){
    try {
      FXMLLoader loader=new FXMLLoader();
      loader.setLocation(getClass().getResource("DetailController.fxml"));
      Parent root=loader.load();
      DetailController detailController = loader.getController();
      detailController.init();
      detailController.setBook(book);
      stage.setTitle("Detail");
      detail=new Scene(root);
    }
    catch (IOException e){
      e.printStackTrace();
    }
    stage.setScene(detail);
    stage.show();
  }



}
