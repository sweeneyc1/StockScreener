package application;

import java.io.FileInputStream;
import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Label;

public class Stocks extends Application {
	Scene scene1, scene2, scene3, scene4;
	


	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Stock Screener");
		
//Scene 1

		GridPane root = new GridPane();
		 
	       root.setPadding(new Insets(20));
	       root.setHgap(25);
	       root.setVgap(15);
	
	       Label labelUserName = new Label("User Name");
	       TextField fieldUserName = new TextField();
	 
	       Label labelPassword = new Label("Password");
	 
	       PasswordField fieldPassword = new PasswordField();
	 
	       Button loginButton = new Button("Login");
	       loginButton.setOnAction(e -> primaryStage.setScene(scene2));
	       GridPane.setHalignment(labelUserName, HPos.RIGHT);
	 
	       // Put on cell (0,1)
	       root.add(labelUserName, 0, 1);
	 
	        
	       GridPane.setHalignment(labelPassword, HPos.RIGHT);
	       root.add(labelPassword, 0, 2);
	 
	       // Horizontal alignment for User Name field.
	       GridPane.setHalignment(fieldUserName, HPos.LEFT);
	       root.add(fieldUserName, 1, 1);
	 
	       // Horizontal alignment for Password field.
	       GridPane.setHalignment(fieldPassword, HPos.LEFT);
	       root.add(fieldPassword, 1, 2);
	 
	       // Horizontal alignment for Login button.
	       GridPane.setHalignment(loginButton, HPos.RIGHT);
	       root.add(loginButton, 1, 3);
	 
	       scene1 = new Scene(root, 300, 300);
		
//Scene 2
		GridPane rootie = new GridPane();
		rootie.setPadding(new Insets(20));
		rootie.setHgap(25);
		rootie.setVgap(15);

		Label label2 = new Label("Holdings Page ");
		label2.setFont(Font.font("Arial", FontWeight.BOLD, 14));
		Button button2 = new Button("logOut");
		button2.setOnAction(e -> primaryStage.setScene(scene1));
		rootie.add(label2, 0, 0);
		rootie.add(button2, 1, 4);

		Button button2a = new Button("Find Stock");
		button2a.setOnAction(e -> primaryStage.setScene(scene3));
		rootie.add(button2a, 1, 5);

//		StackPane sp = new StackPane();
//		StackPane.setMargin(button2a, new Insets(0, 10, 0, 0));
		Image img = 
		new Image("https://i.dailymail.co.uk/i/pix/2013/06/19/article-1585809-1A618B72000005DC-158_634x366.jpg");
		ImageView imgView = new ImageView(img);
		rootie.add(imgView, 0, 1);
//		VBox vb = new VBox(20);
//		vb.setSpacing(10);
//		vb.setPadding(new Insets(0, 20, 10, 20)); 
//		vb.getChildren().addAll(imgView, button2a, button2);
		

		scene2 = new Scene(rootie, 800, 600);

//Scene 3

		GridPane root2 = new GridPane();
		root2.setPadding(new Insets(20));
	    root2.setHgap(25);
	    root2.setVgap(15); 
	    
	    
		Label label3 = new Label("S&P GICs 500 Page");
		label3.setFont(Font.font("Arial", FontWeight.BOLD, 14));
		root2.add(label3, 0, 0);
		
		Button button3 = new Button("Back");
		button3.setOnAction(e -> primaryStage.setScene(scene2));
		root.add(button3, 6, 8);

		
		TreeItem<String> treeItemRoot = new TreeItem<>("Sector");

		TreeItem<String> nodeEnergy = new TreeItem<>("Energy(Sector)");

		TreeItem<String> nodeMaterials = new TreeItem<>("Materials(Sector)");

		TreeItem<String> nodeIndustrials = new TreeItem<>("Industrials(Sector)");

		TreeItem<String> nodeConsumerDiscretionary = new TreeItem<>("Consumer Discretionary(Sector)");

		TreeItem<String> nodeConsumerStaples = new TreeItem<>("Consumer Staples(Sector)");

		TreeItem<String> nodeHealthCare = new TreeItem<>("Health Care(Sector)");

		TreeItem<String> nodeFinancials = new TreeItem<>("Financials(Sector)");

		TreeItem<String> nodeInformationTechnology = new TreeItem<>("Information Technology(Sector)");

		treeItemRoot.getChildren().addAll(nodeEnergy, nodeMaterials, nodeIndustrials, nodeConsumerDiscretionary,
				nodeConsumerStaples, nodeHealthCare, nodeFinancials, nodeInformationTechnology);

		TreeItem<String> nodeIndustryGroupEnergy = new TreeItem<>("Energy (Industry Group)");

		nodeEnergy.getChildren().addAll(nodeIndustryGroupEnergy);

		TreeItem<String> nodeIndustryEnergyEquipmentAndServices = new TreeItem<>(
				"Energy Equipment & Services(Industry)");

		TreeItem<String> nodeIndustryOilGasAnConsumableFuels = new TreeItem<>("Oil, Gas & Consumable Fuels(Industry)");

		nodeIndustryGroupEnergy.getChildren().addAll(nodeIndustryEnergyEquipmentAndServices,
				nodeIndustryOilGasAnConsumableFuels);

		TreeItem<String> subIndustryOilAnGasDrilling = new TreeItem<>("Oil & Gas Drilling(SubIndustry)");

		TreeItem<String> subIndustryOilAnGasEquipmentAnServices = new TreeItem<>(
				"Oil & Gas Equipment & Services(SubIndustry)");

		nodeIndustryEnergyEquipmentAndServices.getChildren().addAll(subIndustryOilAnGasDrilling,
				subIndustryOilAnGasEquipmentAnServices);

		// UNT SDRL ARHVF ORIG PACDQ NE ESV SDLP FROT CETEF PDS ICD AKTAF ESVIF RIG PTEN
		// HP DO NBR.PA NBR WEEEF PHXHF TDGCF PKD RDC VTGDF PES

		TreeItem<String> ticketUnt = new TreeItem<>("UNT");

		TreeItem<String> tickerSDRL = new TreeItem<>("SDRL");

		TreeItem<String> tickerARHVF = new TreeItem<>("ARHVF");

		subIndustryOilAnGasDrilling.getChildren().addAll(ticketUnt, tickerSDRL, tickerARHVF);

		
		//
		
		TreeView<String> treeView = new TreeView<>(treeItemRoot);

		root2.add(treeView, 2, 4);
		
		
		

		Button button3b = new Button("Apply Selected");
		
		button3b.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("[INFO] got action event ");
				MultipleSelectionModel<TreeItem<String>> selectionModel = treeView.getSelectionModel();
				int iii = selectionModel.getSelectedIndex();
				System.out.println("[INFO] selected= " + iii);
				TreeItem x = selectionModel.getSelectedItem();
				//Scene 4

				Button button4 = new Button("Reselect Stock");
				button4.setOnAction(e -> primaryStage.setScene(scene3));

				WebView browser = new WebView();
				WebEngine webEngine = browser.getEngine();
			
				webEngine.load("https://eresearch.fidelity.com/eresearch/goto/evaluate/snapshot.jhtml?symbols=" + (String) x.getValue() + "&type=o-NavBar");
				

				VBox layout4 = new VBox(20);
				layout4.getChildren().addAll(browser, button4);
				scene4 = new Scene(layout4, 1000, 800);
				primaryStage.setScene(scene4);
			}
		});
		
		root.add(button3b, 7, 8);
		

		root2.getChildren().addAll(button3, button3b);

		scene3 = new Scene(root2, 800, 600);
//		VBox layout3 = new VBox(20);layout3.getChildren().addAll(label3,button3,button3a);
//		scene3=new Scene(layout3,800,600);
	


//



//     
//    Start Program 
		
		primaryStage.setScene(scene1);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
