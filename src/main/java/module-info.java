module com.example.connectfour {
	requires javafx.controls;
	requires javafx.fxml;


	opens com.example.connectfour to javafx.fxml;
	exports com.example.connectfour;
}