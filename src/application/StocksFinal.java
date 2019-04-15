package application;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import application.Stocks.Record;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Label;

public class StocksFinal extends Application {
	Scene scene1, scene2, scene3, scene4;
	
	static String selectedStock = "HP";
	public GicNode getParent(List listOfGicsNodes, String parent) {
		GicNode tmpGn = null;

		for (int i = 0; i < listOfGicsNodes.size(); i++) {
			tmpGn = (GicNode) listOfGicsNodes.get(i); // gictype

			if (tmpGn.giccd.equals(parent)) {
				break;
			}
		}
		
		return tmpGn;
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Stock Screener");

		// Scene 1

		GridPane root = new GridPane();
		 
	       root.setPadding(new Insets(20));
	       root.setHgap(25);
	       root.setVgap(15);
	
	       Label labelUserName = new Label("Username");
	       TextField fieldUserName = new TextField();
	 
	       Label labelPassword = new Label("Password");
	 
	       PasswordField fieldPassword = new PasswordField();
	 
	       Button loginButton = new Button("Login");
	       loginButton.setOnAction(e -> primaryStage.setScene(scene2));
	       
	       
	       Button signUpButton = new Button("Create Account");
	       loginButton.setOnAction(e -> primaryStage.setScene(scene2));
	       
	       // Put on cell (0,1)
	       GridPane.setHalignment(labelUserName, HPos.RIGHT);
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
	       root.add(loginButton, 1, 4);
	       
	       GridPane.setHalignment(signUpButton, HPos.RIGHT);
	       root.add(signUpButton, 1, 3);
	 
	       scene1 = new Scene(root, 300, 300);
		

		// Scene 2

			GridPane rootie = new GridPane();
			rootie.setPadding(new Insets(20));
			rootie.setHgap(25);
			rootie.setVgap(15);


			Button button2a = new Button("Find Stock");
			button2a.setOnAction(e -> primaryStage.setScene(scene3));
			 
	        TableColumn columnF1 = new TableColumn("Symbol");
	        columnF1.setCellValueFactory(
	                new PropertyValueFactory<>("f1"));
	 
	        TableColumn columnF2 = new TableColumn("Last Trade");
	        columnF2.setCellValueFactory(
	                new PropertyValueFactory<>("f2"));
	 
	        TableColumn columnF3 = new TableColumn("Change $");
	        columnF3.setCellValueFactory(
	                new PropertyValueFactory<>("f3"));
	 
	        TableColumn columnF4 = new TableColumn("Change %");
	        columnF4.setCellValueFactory(
	                new PropertyValueFactory<>("f4"));
	 
	        TableColumn columnF5 = new TableColumn("Day's Gain");
	        columnF5.setCellValueFactory(
	                new PropertyValueFactory<>("f5"));
	 
	        TableColumn columnF6 = new TableColumn("Qty");
	        columnF6.setCellValueFactory(
	                new PropertyValueFactory<>("f6"));
	        
	        TableColumn columnF7 = new TableColumn("Price Paid");
	        columnF7.setCellValueFactory(
	                new PropertyValueFactory<>("f7"));
	        
	        TableColumn columnF8 = new TableColumn("Total Gain $");
	        columnF8.setCellValueFactory(
	                new PropertyValueFactory<>("f8"));
	        
	        TableColumn columnF9 = new TableColumn("Total Gain %");
	        columnF9.setCellValueFactory(
	                new PropertyValueFactory<>("f9"));
	        
	        TableColumn columnF10 = new TableColumn("Market Value");
	        columnF10.setCellValueFactory(
	                new PropertyValueFactory<>("f10"));
	 
	        tableView.setItems(dataList);
	        tableView.getColumns().addAll(
	                columnF1, columnF2, columnF3, columnF4, columnF5, columnF6,
	                columnF7, columnF8, columnF9, columnF10
	                
	        		);
	        Label label2 = new Label("Holdings Page ");
			label2.setFont(Font.font("Arial", FontWeight.BOLD, 14));
			Button button2 = new Button("Log Out");
			button2.setOnAction(e -> primaryStage.setScene(scene1));
			rootie.add(label2, 0, 0);
			rootie.add(button2, 0, 2);
			
			TextField entered = new TextField();
			rootie.add(entered, 0, 4);
			
			Button button2b = new Button("Add Selected");
			rootie.add(button2b, 0, 5);
			button2b.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					System.out.println("[INFO] got action event ");
					
					String value1 = (String)entered.getText();
		            String stockSelect = value1;
		            
					System.out.println("[INFO] selected= " + stockSelect);
					//Scene 4

					Button button4 = new Button("Reselect Stock");
					button4.setOnAction(e -> primaryStage.setScene(scene3));
					
					Button button4a = new Button("Reselect Stock from Spreadsheet");
					button4a.setOnAction(e -> primaryStage.setScene(scene2));

					WebView browser = new WebView();
					WebEngine webEngine = browser.getEngine();
				
					webEngine.load("https://eresearch.fidelity.com/eresearch/goto/evaluate/snapshot.jhtml?symbols=" + (String)stockSelect + "&type=o-NavBar");
					

					VBox layout4 = new VBox(20);
					layout4.getChildren().addAll(browser, button4, button4a);
					scene4 = new Scene(layout4, 1000, 800);
					primaryStage.setScene(scene4);
				}
			});
			
	 
	        VBox vBox = new VBox();
	        vBox.setSpacing(10);
	        vBox.getChildren().add(tableView);
	        
	        rootie.add(tableView, 0, 0);
	        rootie.add(button2a, 0, 3);
	        
	        scene2 = new Scene(rootie, 800, 600);
	        readCSV();
			

		// Scene 3

		Label label3 = new Label("S&P GIcs 500 Page");
		Button button3 = new Button("back");
		button3.setOnAction(e -> primaryStage.setScene(scene2));
		
// OLD CODE STARTED HERE
		String gicsFile = "C:\\Users\\sweeneyc1\\Desktop\\r_gics.txt";
		String companyFile = "C:\\Users\\sweeneyc1\\Desktop\\f_gic_comp.txt";
		String stockFile = "C:\\Users\\sweeneyc1\\Desktop\\f_gic_secur1.txt";
		String line = "";
		String cvsSplitBy = "\\|";
		List<GicNode> gicslist = new ArrayList<GicNode>();
		// load raw data for sector tree
		System.out.println("--loadig raw data for secgtor tree  names  ------------");
		try (BufferedReader br = new BufferedReader(new FileReader(gicsFile))) {
			String title = new String("0");
			GicNode rootGN = new GicNode(title, "S&P Gics Tree", "root"/* , null */);
			while ((line = br.readLine()) != null) {
				// use comma as separator
				String[] gicField = line.split(cvsSplitBy);
				String gicCode = gicField[1];
				String gicDesc = gicField[2];
				String gicType = gicField[3];

				GicNode gicNode = new GicNode(gicCode, gicDesc, gicType /* , parentGn */);
				gicslist.add(gicNode);
			} 
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("--loadig raw data for company names  ------------");
		// now read in the companies that belong to the end leaves
		try (BufferedReader br = new BufferedReader(new FileReader(companyFile))) {
			while ((line = br.readLine()) != null) {
				// use comma as separator
				String[] gicField = line.split(cvsSplitBy);
				String gicCode = gicField[1];
				String gicDesc = gicField[2];
				String gicCountry = gicField[4];
				String GGROUP = gicField[5];
				String GIND = gicField[6];
				String GSECTOR = gicField[7];
				String GSUBIN = gicField[8];
				if (gicCountry.equals("USA")) {
					GicNode compGicNode = new GicNode(gicCode, gicDesc, "COMPANY",
							GSECTOR, GGROUP, GIND, GSUBIN);
					gicslist.add(compGicNode);
				}
			} 
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("--loadig raw data for sectors ------------");
		// now read in the stocks symbols that belong to the end leaves

		try (BufferedReader br = new BufferedReader(new FileReader(stockFile))) {
			while ((line = br.readLine()) != null) {
				// use comma as separator
				String[] gicField = line.split(cvsSplitBy);
				String gicCode = gicField[1];
				String tmpTicker = gicField[9];
				GicNode parentN = this.getParent(gicslist, gicCode);
				if (parentN != null) {
					parentN.ticker = tmpTicker;
				}
			} 
		} catch (IOException e) {
			e.printStackTrace();
		}
		TreeItem<GicNode> treeItemRoot;
		GicNode gn = new GicNode("0", "S&P GICS", "TOP");
		treeItemRoot = new TreeItem<>(gn);

		// file in all the sectors and add to root
		System.out.println("--loadig graphics for -------SECTORS--------------");
		for (int i = 0; i < gicslist.size(); i++) {
			GicNode tmpGn = gicslist.get(i); // gictype
			
			if (tmpGn.gictype.contentEquals("GSECTOR")) {
				TreeItem<GicNode> tmpTreeitemNode = new TreeItem<>(tmpGn);
				tmpGn.ti = tmpTreeitemNode;
				treeItemRoot.getChildren().add(tmpTreeitemNode);
			}
		}

		System.out.println("--------END  adding SECTORS--------------");

		// file in all the groups in sectors and add them

		System.out.println("---loadingr graphics for ------GGROUP--------------");

		for (int i = 0; i < gicslist.size(); i++) {
			GicNode tmpGn = gicslist.get(i); // gictype

			// System.out.println("=->" +tmpGn.gictype+"<-=");

			if (tmpGn.gictype.contentEquals("GGROUP")) {
				// System.out.println(tmpGn.giccd + ", "+tmpGn.gictype +", "+tmpGn.gicdesc +",
				// "+tmpGn.gsubin ) ;

				TreeItem<GicNode> tmpTreeitemNode = new TreeItem<>(tmpGn);
				tmpGn.ti = tmpTreeitemNode;
				String parentStr = tmpGn.giccd.substring(0, 2);
				GicNode parentN = this.getParent(gicslist, parentStr);
				
				if (parentN != null) {
					TreeItem<GicNode> tmpParentTreeitemNode = parentN.ti;
					tmpParentTreeitemNode.getChildren().add(tmpTreeitemNode);
				}
			}
		}

		System.out.println("--------END  adding GGROUP --------------");

		// file in all the industrys in grpoups and add them

		System.out.println("------loadig grpahics for ---GIND--------------");
		for (int i = 0; i < gicslist.size(); i++) {
			GicNode tmpGn = gicslist.get(i); // gictype
			// System.out.println("=->" +tmpGn.gictype+"<-=");

			if (tmpGn.gictype.contentEquals("GIND")) {
				// System.out.println(tmpGn.giccd + ", "+tmpGn.gictype +", "+tmpGn.gicdesc +",
				// "+tmpGn.gsubin ) ;
				TreeItem<GicNode> tmpTreeitemNode = new TreeItem<>(tmpGn);
				tmpGn.ti = tmpTreeitemNode;
				String parentStr = tmpGn.giccd.substring(0, 4);
				GicNode parentN = this.getParent(gicslist, parentStr);
				if (parentN != null) {
					TreeItem<GicNode> tmpParentTreeitemNode = parentN.ti;
					tmpParentTreeitemNode.getChildren().add(tmpTreeitemNode);
				}
			}
		}

		System.out.println("--------END  adding GIND --------------");

		// file in all the industrys in grpoups and add them

		System.out.println("------loading graphics for ---GSUBIND--------------");

		for (int i = 0; i < gicslist.size(); i++) {
			GicNode tmpGn = gicslist.get(i); // gictype
			// System.out.println("=->" +tmpGn.gictype+"<-=");

			if (tmpGn.gictype.contentEquals("GSUBIND")) {
				// System.out.println(tmpGn.giccd + ", "+tmpGn.gictype +", "+tmpGn.gicdesc +",
				// "+tmpGn.gsubin ) ;
				TreeItem<GicNode> tmpTreeitemNode = new TreeItem<>(tmpGn);
				tmpGn.ti = tmpTreeitemNode;
				String parentStr = tmpGn.giccd.substring(0, 6);
				GicNode parentN = this.getParent(gicslist, parentStr);
				if (parentN != null) {
					TreeItem<GicNode> tmpParentTreeitemNode = parentN.ti;
					tmpParentTreeitemNode.getChildren().add(tmpTreeitemNode);
				}
			}
		}
		System.out.println("--------END  adding GSUBIND --------------");
		// file in all the industrys in grpoups and add them
		System.out.println("--------- loading graphics of COMPANY--------------");
		for (int i = 0; i < gicslist.size(); i++) {
			GicNode tmpGn = gicslist.get(i); // gictype
			// System.out.println("=->" +tmpGn.gictype+"<-=");
			if (tmpGn.gictype.contentEquals("COMPANY")) {
				// System.out.println(tmpGn.giccd + ", "+tmpGn.gictype +", "+tmpGn.gicdesc +",
				// "+tmpGn.gsubin ) ;
				TreeItem<GicNode> tmpTreeitemNode = new TreeItem<>(tmpGn);
				tmpGn.ti = tmpTreeitemNode;
				// String parentStr = tmpGn.giccd.substring(0, 6) ;
				String parentStr = tmpGn.gsubin;
				GicNode parentN = this.getParent(gicslist, parentStr);
				if (parentN != null) {
					TreeItem<GicNode> tmpParentTreeitemNode = parentN.ti;
					tmpParentTreeitemNode.getChildren().add(tmpTreeitemNode);
				}
			}
		}

		System.out.println("--------END  adding GSUBIND --------------");
		System.out.println("--------graphic loading done ------------");
		TreeView<GicNode> treeView = new TreeView<>(treeItemRoot);
		StackPane root3 = new StackPane();
		root3.getChildren().add(treeView);

		// -- ---------------------------- OLD STUFF ENDS

		Button button3b = new Button("ShowSelected");
		button3b.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("[INFO] got action event ");
				MultipleSelectionModel<TreeItem<GicNode>> selectionModel = treeView.getSelectionModel();
				int iii = selectionModel.getSelectedIndex();
				System.out.println("[INFO] selected= " + iii);
				TreeItem x = selectionModel.getSelectedItem();
				GicNode y = (GicNode) x.getValue();
				System.out.println("[INFO] selected= " + y.ticker); // toString());
				
				selectedStock = y.ticker;

				// Scene 4

				Button button4 = new Button("Reselect Stock");
				button4.setOnAction(e -> primaryStage.setScene(scene3));
				
				Button button4a = new Button("Reselect Stock from Spreadsheet");
				button4a.setOnAction(e -> primaryStage.setScene(scene2));


				WebView browser = new WebView();
				WebEngine webEngine = browser.getEngine();

				webEngine.load("https://eresearch.fidelity.com/eresearch/goto/evaluate/snapshot.jhtml?symbols="

						+ selectedStock + "&type=o-NavBar");

				VBox layout4 = new VBox(20);
				layout4.getChildren().addAll(browser, button4, button4a);
				scene4 = new Scene(layout4, 1000, 800);
				primaryStage.setScene(scene4);

			} // end button

		});
		
		root3.getChildren().add(button3b);
		scene3 = new Scene(root3, 800, 600);
		
//         Start Program
		primaryStage.setScene(scene1);
		primaryStage.show();

	}
	//class to display excel!!
		public class Record {
	        //Assume each record have 6 elements, all String
	        private SimpleStringProperty f1, f2, f3, f4, f5, f6, f7, f8, f9, f10;
	 
	        public String getF1() {
	            return f1.get();
	        }
	        public String getF2() {
	            return f2.get();
	        }
	        public String getF3() {
	            return f3.get();
	        }
	        public String getF4() {
	            return f4.get();
	        }
	        public String getF5() {
	            return f5.get();
	        }
	        public String getF6() {
	            return f6.get();
	        }
	        public String getF7() {
	            return f7.get();
	        }
	        public String getF8() {
	            return f8.get();
	        }
	        public String getF9() {
	            return f9.get();
	        }
	        public String getF10() {
	            return f10.get();
	        }
	 
	        Record(String f1, String f2, String f3, String f4,
	                String f5, String f6, String f7, String f8, 
	                String f9, String f10) {
	            this.f1 = new SimpleStringProperty(f1);
	            this.f2 = new SimpleStringProperty(f2);
	            this.f3 = new SimpleStringProperty(f3);
	            this.f4 = new SimpleStringProperty(f4);
	            this.f5 = new SimpleStringProperty(f5);
	            this.f6 = new SimpleStringProperty(f6);
	            this.f7 = new SimpleStringProperty(f7);
	            this.f8 = new SimpleStringProperty(f8);
	            this.f9 = new SimpleStringProperty(f9);
	            this.f10 = new SimpleStringProperty(f10);
	        }
	 
	    }
	 
	    private final TableView<Record> tableView = new TableView<>();
	 
	    private final ObservableList<Record> dataList
	            = FXCollections.observableArrayList();
	    
	    // GET TO WORK::
	    
	    
	    private void readCSV() {
	    	 
	        String CsvFile = "C:\\Users\\sweeneyc1\\Desktop\\holdings.csv";
	        String FieldDelimiter = ",";
	 
	        BufferedReader br;
	 
	        try {
	            br = new BufferedReader(new FileReader(CsvFile));
	 
	            String line;
	            while ((line = br.readLine()) != null) {
	                String[] fields = line.split(FieldDelimiter, -1);
	 
	                Record record = new Record(fields[0], fields[1], fields[2],
	                        fields[3], fields[4], fields[5], fields[6], fields[7], 
	                        fields[8], fields[9]);
	                dataList.add(record);
	 
	            }
	 
	        } catch (FileNotFoundException ex) {

	        } catch (IOException ex) {
          
	        }
	 
	    }
	public static void main(String[] args) {

		launch(args);

	}

}
