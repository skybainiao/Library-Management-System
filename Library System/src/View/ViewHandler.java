package View;

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
      managerController.init();
      mainStage.setTitle("Manager");
      manager=new Scene(root);
    }
    catch (IOException e){
      e.printStackTrace();
    }
    mainStage.setScene(manager);
    mainStage.show();
  }


}
