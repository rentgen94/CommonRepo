package io.github.rentgen94.Controllers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import org.json.JSONArray;

import java.awt.*;
import java.awt.datatransfer.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

/**
 * Created by Let's_rock on 20.07.2017.
 */
public class RootLayoutController implements ClipboardOwner {
    @FXML
    private TextArea textArea;
    @FXML
    private TextArea translationArea;
    @FXML
    private ChoiceBox<String> fromLang;
    @FXML
    private ChoiceBox<String> toLang;
    @FXML
    private CheckBox checkWrap;

    private Clipboard clipboard;
    private ObservableList<String> langs = FXCollections.observableArrayList(new String[]{"en", "ru"});
    @FXML
    private void initialize() {
        clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        Transferable transferable = clipboard.getContents(this);
        refreshContent(transferable);
        fromLang.setItems(langs);
        fromLang.getSelectionModel().select(0);
        toLang.setItems(langs);
        toLang.getSelectionModel().select(1);
        textArea.setText("First init");
        translationArea.setWrapText(true);
        checkWrap.selectedProperty().addListener((observable, oldValue, newValue) -> {
            textArea.setWrapText(newValue);
            translationArea.setWrapText(newValue);
        });
    }

    private void refreshContent(Transferable transferable) {
        clipboard.setContents(transferable, this);
        String text = "";
        if (clipboard.getContents(null).isDataFlavorSupported(DataFlavor.stringFlavor)) {
            try {
                text = (String) clipboard.getData(DataFlavor.stringFlavor);
            } catch (UnsupportedFlavorException | IOException e) {
                e.printStackTrace();
            }
            translate(text, textArea, translationArea);
        }
    }

    @Override
    public void lostOwnership(Clipboard clipboard, Transferable t) {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Transferable contents = clipboard.getContents(this);
        refreshContent(contents);
    }

    private String callUrlAndParseResult(String langFrom, String langTo,
                                         String word) throws Exception {
        String url = "https://translate.googleapis.com/translate_a/single?" +
                "client=gtx&" +
                "sl=" + langFrom +
                "&tl=" + langTo +
                "&dt=t&q=" + URLEncoder.encode(word, "UTF-8");

        URL obj = new URL(url);
        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("192.168.2.1", 8080));
        HttpURLConnection con = (HttpURLConnection) obj.openConnection(proxy);

        con.setRequestProperty("User-Agent", "Mozilla/5.0");

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream(), "UTF-8"));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        return parseResult(response.toString());
    }

    private String parseResult(String inputJson) throws Exception {
      /*
       * inputJson for word 'hello' translated to language Hindi from English-
       * [[["नमस्ते","hello",,,1]],,"en"]
       * We have to get 'नमस्ते ' from this json.
       */
        StringBuilder stringBuilder = new StringBuilder();

        JSONArray jsonArray = new JSONArray(inputJson);
        JSONArray jsonArray2 = (JSONArray) jsonArray.get(0);
        for (int i = 0; i < jsonArray2.length(); i++) {
            JSONArray jsonArray3 = (JSONArray) jsonArray2.get(i);
            stringBuilder.append(jsonArray3.get(0).toString());
        }

        return stringBuilder.toString();
    }

    public void changeLang() {
        int selectedFrom = fromLang.getSelectionModel().getSelectedIndex();
        fromLang.getSelectionModel().select(toLang.getSelectionModel().getSelectedIndex());
        toLang.getSelectionModel().select(selectedFrom);
    }

    private void translate(String from, TextArea fromArea, TextArea toArea) {
        fromArea.setText(from);
        try {
            toArea.setText(callUrlAndParseResult(fromLang.getValue(), toLang.getValue(), from));
        } catch (Exception e) {
            toArea.setText(e.getMessage());
        }
    }

    public void onKeyTranslate(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.ENTER) {
            if (keyEvent.getSource() instanceof TextArea) {
                TextArea source = (TextArea) keyEvent.getSource();
                if (source.equals(translationArea)) {
                    changeLang();
                }
                translate(source.getText(), textArea, translationArea);
                keyEvent.consume();
                textArea.requestFocus();
                textArea.selectAll();
            }
        }
    }
}
