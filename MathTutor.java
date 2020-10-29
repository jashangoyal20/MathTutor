package testpack;


import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class MathTutor extends Application {
protected int Rcount;
protected int Wcount,click;
protected Label right,wrong,num1,num2,result;
protected int num,numm;
protected String Snum, Snumm,rc;

	public static void main(String[] args) {
		launch(args);
	}
	
	
	
	public Label getRandom1(int num) {
		
	    Snum=Integer.toString(num);
	    Label lbl=new Label(Snum);
		lbl.setFont(Font.font("Courier", 24));
	    lbl.setPrefWidth(40);
		return lbl ;
	}
	
	public Label getRandom2(int num) {
		
	    Snum=Integer.toString(num);
	    Label lbl2=new Label(Snum);
	    lbl2.setFont(Font.font("Courier", 24));
	    lbl2.setPrefWidth(40);
		return lbl2 ;
	}
	

	
public BorderPane getPane() {
	BorderPane bpane = new BorderPane();
	
	HBox pane=new HBox();
	
	Label lbl=new Label("Math Practice");
	lbl.setFont(Font.font("Courier", 24));
    lbl.setTextFill(Color.web("#0076a3"));	
	pane.getChildren().add(lbl);
	pane.setAlignment(Pos.TOP_CENTER);
	Label mult=new Label("X");
    mult.setPrefWidth(40);
    
    Label equal=new Label("=");
    equal.setPrefWidth(40);
    
    num=(int) (1+Math.random()*10);
    numm=(int) (1+Math.random()*10);
    num1=getRandom1(num);
    num2=getRandom1(numm);


	GridPane gp=new GridPane();
	TextField txt=new TextField();
	txt.setPrefWidth(30);
	gp.setAlignment(Pos.TOP_CENTER);
    gp.setPadding(new Insets(0, 20, 13.5, 20));
    gp.setHgap(5.5);
    gp.setVgap(15.5);
            
    GridPane.setHalignment(mult, HPos.CENTER);
    GridPane.setHalignment(equal, HPos.CENTER);
    GridPane.setHalignment(txt, HPos.CENTER);
    
      right=new Label("0");	
      wrong=new Label("0"); 
      num1.setVisible(false);
      num2.setVisible(false);
      mult.setVisible(false);
      equal.setVisible(false);
      txt.setVisible(false);
      HBox rightWrong=new HBox();
      Label lblResult=new Label("");
      
    Button start=new Button("Start New");
	Button aButton=new Button("Next");

	aButton.setVisible(false);
	start.setPrefWidth(80);
	
	

	 start.setOnAction(e -> {
		 aButton.setVisible(true);
		 num1.setVisible(true);
	     num2.setVisible(true);
	     mult.setVisible(true);
	     equal.setVisible(true);
	     txt.setVisible(true);
	        lbl.setText("How Much is:");
			lblResult.setText("");
			Wcount=0;
			Rcount=0;
            right.setText("0");
            wrong.setText("0");
            aButton.setDisable(false);
            start.setDisable(true);
            click=0;
            txt.requestFocus();
	 });
	 
	 
	 
	aButton.setPrefWidth(80);


	
	     aButton.setOnAction(e -> {
	    	
	    if(txt.getText().isEmpty()) {
	    	Alert alert=new Alert(AlertType.WARNING, "PLease enter a valid value");
			alert.showAndWait();	
	         txt.requestFocus();
}
	       
	    else {
	    	
         Integer value1 = Integer.valueOf(num1.getText());
         Integer value2 = Integer.valueOf(num2.getText());
         Integer r = value1 * value2;
         Integer userin= Integer.valueOf(txt.getText());



         if(r==userin)
         {	    	 
        	 click++;
        	 if(click==10) {
        		    aButton.setDisable(true);
        			lblResult.setText("Result");
        			start.setDisable(false);
        			if(Rcount>=7) {
       	    		 lbl.setText("Good Job");
       	    	 }
       	    	 if(Wcount>=3) {
       	    		 lbl.setText("Needs More Practice");
       	    	 }
        		}
        	 Rcount++;
        	 
        	 rc=Integer.toString(Rcount);
	         right.setText(rc);
         }
         
         if(r!=userin)
         {
        	 click++;
        	 if(click==10) {
        			aButton.setDisable(true);
        			lblResult.setText("Result");
        			start.setDisable(false);
        			if(Rcount>=7) {
        	    		 lbl.setText("Good Job");
        	    	 }
        	    	 if(Wcount>=3) {
        	    		 lbl.setText("Needs More Practice");
        	    	 }
        			   		}
         Wcount++;
         
         String wc=Integer.toString(Wcount);
         wrong.setText(wc);
         
         }

         
         int a=(int)(1+Math.random()*10);
         num1.setText(Integer.toString(a));
         int b=(int)(1+Math.random()*10);
         num2.setText(Integer.toString(b));
         txt.setText("");
         txt.requestFocus();
        
} });
	     
	     Label lblcorrect=new Label("Correct");
	     Label lblWrong=new Label("Wrong");
	    gp.add(num1, 0, 1);
	 	gp.add(mult, 1, 1);
	 	gp.add(num2, 2, 1);
	 	gp.add(equal, 3, 1);
	  	gp.add(txt , 4, 1);
	    gp.add(start, 1, 2);
	    gp.add(aButton, 4, 2);
    
	    right.setFont(Font.font("Courier", 24));
	    wrong.setFont(Font.font("Courier", 24));
	    right.setTextFill(Color.web("#0076a3"));
	    wrong.setTextFill(Color.web("#0076a3"));
//	    right.setPrefWidth(120);
//	    wrong.setPrefWidth(120);
	    lblWrong.setFont(Font.font("Courier", 24));
	    lblcorrect.setFont(Font.font("Courier", 24));
	  
	    rightWrong.setPadding(new Insets(0, 20, 13.5, 20));
	    rightWrong.getChildren().addAll(lblResult,lblcorrect,right,new Label("                   "),lblWrong,wrong);
        
	    rightWrong.setSpacing(10);
	    rightWrong.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
	    
		rightWrong.setAlignment(Pos.TOP_CENTER);
	 
	 bpane.setTop(pane);
	 bpane.setCenter(gp);
	 bpane.setBottom(rightWrong);
	 
	 return bpane;
}
	@Override
	public void start(Stage ps) throws Exception {
		Scene scene = new Scene(getPane(), 400,200);
		ps.setScene(scene);
		ps.setTitle("Math Tutor");
		ps.show();
	}
}
