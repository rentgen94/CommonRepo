package io.github.rentgen94;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by Let's_rock on 20.07.2017.
 */
public class Main extends Application {
    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Translate");

        initRootLayout();
    }

    private void initRootLayout() {
        Pane rootLayout;
        try {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("/View/RootLayout.fxml"));
            rootLayout = loader.load();

            //RootLayoutController controller = loader.getController();

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.setAlwaysOnTop(true);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
