package shapes.game;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.geometry.Pos;

/*	@Project: Shapes (Practical programming assignment, ADS)
 * 	@Author: Anonymous ADS student
 * 	@Version: 21.11.2021
 * 	The Shapes class is used to build a GUI that renders and modifies 2D objects based on user input.
 */

public class Shapes extends Application
{
	// attributes
	private int i; // variable used in the function to create polygons
	private Polygon polygon = new Polygon();	// the shape that the program displays

/*  
 * 	methods to calculate the shapes of polygons of N-sides
 *	(merely includes method for regular polygons at present)
 */
	
		// method that calculates the shape of a regular polygon of N-sides
		public static Polygon myRegularPolygon(int sides)
		{
			int i = 0; // local variable to be used in the function
			Polygon regularPolygon = new Polygon(); // new instance of the polygon object
			
			for(i = 0; i < sides; i++) // function to create regular polygon of N-sides
			{
				// local variables (drawing a regular polygon is based on a circle)
				int x = 300 / 2;
				int y = 300 / 2;
				int radius = (int)(Math.min(400, 400) * 0.4); // calculate the radius
				double angle = 2 * Math.PI / sides;	// calculate the angle
				//	calculate the array points based on 'i'
				double point1 = (x + radius * Math.cos(i * angle));
				double point2 = (y - radius * Math.sin(i * angle));
				// getting points for the new object (array of doubles)
				regularPolygon.getPoints().addAll(new Double[]{point1,point2});
			}	
					
				// setting stroke and fill the polygon to the desired colours
				if (i % 2 == 0)	//even numbers
				{
					regularPolygon.setStroke(Color.KHAKI);	
					regularPolygon.setFill(Color.KHAKI);
				
				}
					else	// uneven numbers
					{
						regularPolygon.setStroke(Color.DARKSEAGREEN);
						regularPolygon.setFill(Color.DARKSEAGREEN);
					}
				
				return regularPolygon; //return newly created polygon of N-sides
		}

/*  
 * 	Graphical User Interface
 */
		
		//method to set up the GUI
		@Override
		public void start(Stage stage)
		{
			// LABELS
			
			// create and configure a welcome message
			Label welcomeMessage = new Label("Welcome to the shapes game!");
			welcomeMessage.setTextAlignment(TextAlignment.CENTER); // align the text within the label
			welcomeMessage.setTextFill(Color.BLACK); // set the colour of the text within the label
			welcomeMessage.setFont(Font.font("Courier New", 18)); // set the font for the text within the label
    	
			// create and configure a label for the text fields of component 1
			Label messageOne = new Label("How many sides do you want your shape to have?");
			messageOne.setTextAlignment(TextAlignment.CENTER);
			messageOne.setTextFill(Color.BLACK);
			messageOne.setFont(Font.font("Courier New", 18));
    	
			// create and configure a label for the text fields of component 1
			Label instructionOne = new Label("Select an integer between 4 and 8 inclusive\nand click enter to generate your shape.");
			instructionOne.setTextAlignment(TextAlignment.CENTER);
			instructionOne.setTextFill(Color.BLACK);
			instructionOne.setFont(Font.font("Courier New", 12));
    	
			// create and configure a labels for the text field of component 2
			Label messageThree= new Label("Now click on the buttons below\nfor some additional fun!");
			messageThree.setTextAlignment(TextAlignment.CENTER);
			messageThree.setTextFill(Color.BLACK);
			messageThree.setFont(Font.font("Courier New", 18));
			
			// TEXT FIELD
    	
			// create text field to accept user input
			TextField textField = new TextField();	
    	
			// CANVAS
    	
			// create canvas instance to hold polygons
	        Canvas emptyCanvas = new Canvas(300,300);
	        StackPane myCanvas = new StackPane(emptyCanvas); // place canvas within StackPane
	        
	        // BUTTONS
	        
	        // create 'enter' button for Text Field
	     	Button textFieldButton = new Button();
	     	textFieldButton.setTextFill(Color.BLACK); // set the colour of the text within the button
	     	textFieldButton.setFont(Font.font("Courier New", 12)); // set the font for the text in the button
	     	textFieldButton.setText("Enter"); // set the text displayed on the button
    	
	        // create and configure a button to add one side
	        Button buttonPlus = new Button();
	        buttonPlus.setTextFill(Color.BLACK);
	        buttonPlus.setFont(Font.font("Courier New", 12));
	        buttonPlus.setText("Push me to add one side");
        
	        // create and configure a button to remove one side
	        Button buttonMinus = new Button();
	        buttonMinus.setTextFill(Color.BLACK);
	        buttonMinus.setFont(Font.font("Courier New", 12));
	        buttonMinus.setText("Push me to remove one side");
        
	        // create and configure a button to reset and restart game
	        Button buttonPlayAgain = new Button();
	        buttonPlayAgain.setTextFill(Color.BLACK);
	        buttonPlayAgain.setFont(Font.font("Courier New", 12));
	        buttonPlayAgain.setText("Play again!");
	        
	        // POLYGON INSTANCE(S)
        
	        polygon = myRegularPolygon(i);	// create an instance of regular polygon
	        
	        // HORIZONTAL/VERTICAL BOXES
	        
	        // create and configure HBox to hold text field and its button
	        HBox component1A = new HBox(10);
	        component1A.setBackground(Background.EMPTY); // set box background
	        component1A.setAlignment(Pos.CENTER); // align box
	        component1A.getChildren().addAll(textField, textFieldButton); // add children to bow-x
        
	        // create and configure HBox to centre canvas
	        HBox component1B = new HBox(10);
	        component1B.setBackground(Background.EMPTY);
	        component1B.setAlignment(Pos.CENTER);
	        component1B.getChildren().addAll(myCanvas);
        
	        // create and configure HBox to hold component2's buttons 
	        HBox component2 = new HBox(10);
	        component2.setBackground(Background.EMPTY);
	        component2.setAlignment(Pos.CENTER);
	        component2.getChildren().addAll(buttonMinus, buttonPlus);
        
	        //create and configure VBox to hold all other components
	        VBox verticalBox = new VBox(10);
	        verticalBox.setBackground(Background.EMPTY);
	        verticalBox.setAlignment(Pos.CENTER);
	        verticalBox.getChildren().addAll(welcomeMessage, messageOne, instructionOne, component1A, component1B, messageThree, component2);
        
	        // FUNCTION ASSIGNMENTS
	        
	        // assign the function to "buttonPlus" button
	        buttonPlus.setOnAction( e -> 
	        { 
	        	if (i == 8)
	        	{
	        		Alert message2 = new Alert(AlertType.INFORMATION); //set alert message to be displayed
	        		message2.setTitle("*** Invalid action ***");
	        		message2.setHeaderText(null);
	        		message2.setContentText("You are not allowed to generate shapes with more than eight sides.");
	        		message2.showAndWait(); // require action from the user to hide alert message
	        	}
  			
	        		else if ((i >= 4) && (i <= 7))
	        		{	
	        			component1B.getChildren().remove(polygon); // remove old polygon
	        			i+=1;
	        			polygon = myRegularPolygon(i);
	        			component1B.getChildren().add(polygon); // add newly created polygon
  					
	        			// disable buttons after click
  	  					buttonPlus.setDisable(true);
  	  					buttonMinus.setDisable(true);
  	  					verticalBox.getChildren().add(buttonPlayAgain); // display 'play again' button
	        		}		
  			
	        			else if (textField.getText().equals("")) // disallows empty strings
	        			{
	        				Alert message = new Alert(AlertType.INFORMATION);
	        				message.setTitle("*** Invalid action ***");
	        				message.setHeaderText(null);
	        				message.setContentText("You need to enter a valid input before you can play.");
	        				message.showAndWait();
	        			}
	        });
  		
	        // assign the function to "buttonMinus" button
	        buttonMinus.setOnAction( e -> 
	        { 
	        	if (i == 4)
	        	{
	        		Alert message2 = new Alert(AlertType.INFORMATION);
	        		message2.setTitle("*** Invalid action ***");
	        		message2.setHeaderText(null);
	        		message2.setContentText("You are not allowed to generate shapes with less than four sides.");
	        		message2.showAndWait();
	        	}
  			
	        		else if (i > 4)
	        		{
	        			component1B.getChildren().remove(polygon);
	        			i-=1;
	        			polygon = myRegularPolygon(i);
	        			component1B.getChildren().add(polygon);
  					
	        			// disable buttons after click
  	  					buttonMinus.setDisable(true);
  	  					buttonPlus.setDisable(true);
  	  					// adds PlayAgain button to reset/restart the application
  	  					verticalBox.getChildren().add(buttonPlayAgain);
	        		}	
  			
	        			else if (textField.getText().equals(""))
	        			{
	        				Alert message2 = new Alert(AlertType.INFORMATION);
	        				message2.setTitle("*** Invalid action ***");
	        				message2.setHeaderText(null);
	        				message2.setContentText("You need to enter a valid input before you can play.");
	        				message2.showAndWait();
	        			}
  		});
  		
	        // assign the function to "textFieldButton"
	        textFieldButton.setOnAction( e -> 
	        {		
	        	try {
	        			// accept user input and convert it into an Integer; set i = input.
	        			i = Integer.parseInt(textField.getText());
  			
	        			if ((i >= 4) && (i <= 8))
	        			{
	        				polygon = myRegularPolygon(i);
	        				component1B.getChildren().remove(myCanvas);
	        				component1B.getChildren().add(polygon);
				
	        				// disable button after click
	        				textFieldButton.setDisable(true);
	        			}
	        				else if ((i < 4) || (i > 8) || (i <= 0))
	        				{
	        					Alert alert = new Alert(AlertType.INFORMATION);
	        					alert.setTitle("*** Warning ***");
	        					alert.setHeaderText(null);
	        					alert.setContentText("Invalid range, please try again.");
	        					alert.showAndWait();
	        					textFieldButton.setDisable(false);
	        				}
	        		}	// end of try
  	
	        	catch (Exception any)
	        	{
	        		Alert alert2 = new Alert(AlertType.INFORMATION);
	        		alert2.setTitle("*** Warning ***");
	        		alert2.setHeaderText(null);
	        		alert2.setContentText("Invalid entry! Please try again.");
	        		alert2.showAndWait();
	        		// avoid disabling text field button if input is invalid
	        		textFieldButton.setDisable(false);
	        	}
	  				
	  		});
	        
	        // assign the function to play again button
	  		buttonPlayAgain.setOnAction(e -> {
	  		restart(stage); // calls method to restart the stage
	  	    });
	        
	  		// SCENE
        
	  		// create and configure a new scene
	  		Scene scene = new Scene(verticalBox, 580, 580, Color.LIGHTGRAY);
	  		
	  		stage.setScene(scene); // add the scene to the stage
	  		stage.setTitle("THE SHAPES GAME"); // set the title for the stage
	  		stage.setResizable(false); // disallows resizing of stage
	  		stage.show(); // show the stage
        
		}	// end of stage
		
/*  
 *	Methods to reset and launch the application 
 */
	
		// method to reset the application using the PlayAgain button
		void cleanup() {
		
		}
		
		// method to restart the application using the PlayAgain button
		void restart(Stage stage) 
		{
	    cleanup();
	    start(stage);
		}
	
		// method to launch the application
		public static void main(String[] args)
		{
        launch(args);
		}
    
}	// end of Shapes class
