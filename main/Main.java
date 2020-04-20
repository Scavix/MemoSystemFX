package main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.MyPost;
import model.Tags;

public class Main extends Application{
	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void start(Stage stage) throws Exception {
		HBox root = new HBox();
		Button b1 = new Button();
		Button b2 = new Button();
		b1.setPrefSize(100, 100);
		b2.setPrefSize(100, 100);
		stage.setTitle("Diario");
		b1.setText("Read");
		b2.setText("Write");
		b1.setOnAction((event1)-> {
			MyPost mypost = new MyPost();
			try {
				mypost.pre();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			TextArea ta = new TextArea();
			ta.setText(mypost.toString());
			FlowPane fp = new FlowPane();
			fp.getChildren().addAll(ta);
			stage.setScene(new Scene(fp, Color.BLUE));
			stage.show();
		});    
		b2.setOnAction((event2)-> {
			System.out.println("Hello World!");
			TextField ta = new TextField();
			ta.setText("Scrivi qui");
			ta.setEditable(true);
			Button bbb = new Button("Ok");
			List<model.Tags> l = Arrays.asList(model.Tags.values());
			ComboBox<Tags> cb = new ComboBox<Tags>(FXCollections.observableArrayList(l));
			FlowPane fp = new FlowPane();
			bbb.setOnAction((evento)->{
				MyPost mypost = new MyPost();
				try {
					mypost.pre();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				mypost.aggiungi(ta.getText(),cb.getValue());
				try {
					mypost.salva();
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
			fp.getChildren().addAll(ta,cb,bbb);
			stage.setScene(new Scene(fp, Color.BLUE));
			stage.show();
		});  
		root.getChildren().addAll(b1,b2);
		stage.setScene(new Scene(root, 200, 100));
		stage.show();
	}
}
