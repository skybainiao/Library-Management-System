package Start;

import View.ViewHandler;
import javafx.application.Application;
import javafx.stage.Stage;

public class GetStart extends Application {

  @Override public void start(Stage stage) throws Exception {
    ViewHandler viewHandler = new ViewHandler();
    viewHandler.openGetInView();
  }
}
