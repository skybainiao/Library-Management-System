package View;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GetStart extends Application
{

  @Override public void start(Stage stage) throws Exception
  {
    stage.setTitle("Book System");
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getResource("Controller.fxml"));
    Scene scene = new Scene(loader.load());
    stage.setScene(scene);
    stage.show();

  }
}
