package com.vilniuscoding.hotel;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.scene.text.Font;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

import com.sun.javafx.scene.control.behavior.DateCellBehavior;

import javafx.geometry.HPos;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

public class MainApp extends Application {

	private Stage stage;
	private DatePicker checkInDatePicker;
	private DatePicker checkOutDatePicker;

	@Override
	public void start(Stage stage) {

		this.stage = stage;
		stage.setTitle(" Hotel Booking Reservation ");
		initUI();
		stage.show();
	}

	private void initUI() {

		VBox vbox = new VBox(20);

		vbox.setStyle("-fx-padding: 50;");
		Scene scene = new Scene(vbox, 1300, 900);
		stage.setScene(scene);
		checkInDatePicker = new DatePicker();
		checkOutDatePicker = new DatePicker();
		checkInDatePicker.setValue(LocalDate.now());
		final Callback<DatePicker, DateCell> dayCellFactory = new Callback<DatePicker, DateCell>() {
			@Override
			public DateCell call(final DatePicker datePicker) {
				return new DateCell() {
					@Override
					public void updateItem(LocalDate item, boolean empty) {
						super.updateItem(item, empty);
						if (item.isBefore(checkInDatePicker.getValue().plusDays(1))) {
							setDisable(true);
							setStyle("-fx-background-color: #ffc0cb;");
						}
						long p = ChronoUnit.DAYS.between(checkInDatePicker.getValue(), item);

						setTooltip(new Tooltip("You're about to stay for " + p + " days"));

					}

				};

			}

		};
		checkOutDatePicker.setDayCellFactory(dayCellFactory);
		checkOutDatePicker.setValue(checkInDatePicker.getValue().plusDays(1));

		GridPane gridPane = new GridPane();
		gridPane.setHgap(10);
		gridPane.setVgap(10);
		Text scenetitle = new Text("Hotel booking and reservation system");
		scenetitle.setFont(Font.font("Tahoma", 20));
		gridPane.add(scenetitle, 18, 0);
		Label checkInlabel = new Label("Check-In Date:");
		gridPane.add(checkInlabel, 0, 1);
		GridPane.setHalignment(checkInlabel, HPos.LEFT);
		gridPane.add(checkInDatePicker, 0, 2);
		Label checkOutlabel = new Label("Check-Out Date:");
		gridPane.add(checkOutlabel, 0, 3);
		GridPane.setHalignment(checkOutlabel, HPos.LEFT);
		gridPane.add(checkOutDatePicker, 0, 4);
		vbox.getChildren().add(gridPane);

		Label companyNameLabel = new Label("Company Name : ");
		gridPane.add(companyNameLabel, 30, 1);

		TextField companyNameField = new TextField();
		companyNameField.setPrefHeight(20);
		gridPane.add(companyNameField, 30, 2);

		Label companyIdLabel = new Label("Company or passport ID : ");
		gridPane.add(companyIdLabel, 30, 3);

		TextField companyIdField = new TextField();
		companyIdField.setPrefHeight(20);
		gridPane.add(companyIdField, 30, 4);

		Label customerNameLabel = new Label("Customer Name : ");
		gridPane.add(customerNameLabel, 30, 5);

		TextField customerNameField = new TextField();
		customerNameField.setPrefHeight(20);
		gridPane.add(customerNameField, 30, 6);

		Label customerSurNameLabel = new Label("Customer Last Name : ");
		gridPane.add(customerSurNameLabel, 30, 7);

		TextField customerSurNameField = new TextField();
		customerSurNameField.setPrefHeight(20);
		gridPane.add(customerSurNameField, 30, 8);

		Label customerPhoneLabel = new Label("Phone Number : ");
		gridPane.add(customerPhoneLabel, 30, 9);

		TextField customerPhoneField = new TextField();
		customerPhoneField.setPrefHeight(20);
		gridPane.add(customerPhoneField, 30, 10);

		Label customerAdressLabel = new Label("Adress : ");
		gridPane.add(customerAdressLabel, 30, 11);

		TextField customerAdressField = new TextField();
		customerPhoneField.setPrefHeight(20);
		gridPane.add(customerAdressField, 30, 12);

		Label customerCityLabel = new Label("City : ");
		gridPane.add(customerCityLabel, 30, 13);

		TextField customerCityField = new TextField();
		customerCityField.setPrefHeight(20);
		gridPane.add(customerCityField, 30, 14);

		Label customerCountryLabel = new Label("Country : ");
		gridPane.add(customerCountryLabel, 30, 15);

		TextField customerCountryField = new TextField();
		customerCountryField.setPrefHeight(20);
		gridPane.add(customerCountryField, 30, 16);

		Label customerPostalLabel = new Label("Post Code : ");
		gridPane.add(customerPostalLabel, 30, 17);

		TextField customerPostalField = new TextField();
		customerPostalField.setPrefHeight(20);
		gridPane.add(customerPostalField, 30, 18);

		Label customerEmailLabel = new Label("Email adress : ");
		gridPane.add(customerEmailLabel, 30, 19);

		TextField customerEmailField = new TextField();
		customerEmailField.setPrefHeight(20);
		gridPane.add(customerEmailField, 30, 20);

		Label customerBirthLabel = new Label("Date of Birth : ");
		gridPane.add(customerBirthLabel, 30, 21);

		TextField customerBirthField = new TextField();
		customerBirthField.setPrefHeight(20);
		gridPane.add(customerBirthField, 30, 22);

		Button button = new Button("Book");
		gridPane.add(button, 0, 24);
		button.setLayoutX(300);
		button.setLayoutY(200);
		button.setMinWidth(100);
		button.setMinHeight(50);
		button.setMaxWidth(100);
		button.setMaxHeight(50);
		button.setPrefWidth(100);
		button.setPrefHeight(50);

		button.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (companyNameField.getText().isEmpty()) {
					showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!",
							"Please enter company name or private");

					return;

				}
				if (companyIdField.getText().isEmpty()) {
					showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!",
							"Please enter company or your passport id");
					return;
				}
				if (customerNameField.getText().isEmpty()) {
					showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!",
							"Please enter customer name");
					return;
				}

				if (customerSurNameField.getText().isEmpty()) {
					showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!",
							"Please enter your last name");

					return;

				}
				if (customerPhoneField.getText().isEmpty()) {
					showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!",
							"Please enter your phone number");

					return;

				}
				if (customerAdressField.getText().isEmpty()) {
					showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!",
							"Please enter adress");

					return;

				}
				if (customerCityField.getText().isEmpty()) {
					showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!",
							"Please enter city");

					return;

				}
				if (customerCountryField.getText().isEmpty()) {
					showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!",
							"Please enter your country");

					return;

				}
				if (customerPostalField.getText().isEmpty()) {
					showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!",
							"Please enter your post code");

					return;

				}
				if (customerEmailField.getText().isEmpty()) {
					showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!",
							"Please enter your email");

					return;

				}
				if (customerBirthField.getText().isEmpty()) {
					showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!",
							"Please enter your birth date");

					return;

				}
				
				Customer customer = new Customer();
				
				customer.setId(companyNameField.getText());
				customer.setCompany(companyIdField.getText());
				customer.setForename(customerNameField.getText());
				customer.setSurname(customerSurNameField.getText());
				customer.setPhone(customerPhoneField.getText());
				customer.setStreet(customerAdressField.getText());
				customer.setCity(customerCityField.getText());
				customer.setCountry(customerCountryField.getText());
				customer.setPostal(customerPostalField.getText());
				customer.setEmail(customerEmailField.getText());
				customer.setBirth(customerBirthField.getText());
				
				customer.insertCustomer();
		
//				ArrayList<String> customers = customer.getCustomers();

				System.out.println(companyNameField.getText());
				System.out.println(customerNameField.getText());
				System.out.println(companyIdField.getText());
				System.out.println(customerNameField.getText());
				System.out.println(customerSurNameField.getText());
				System.out.println(customerAdressField.getText());
				System.out.println(customerCityField.getText());
				System.out.println(customerCountryField.getText());
				System.out.println(customerPostalField.getText());
				System.out.println(customerEmailField.getText());
				System.out.println(customerBirthField.getText());

				showAlert(Alert.AlertType.CONFIRMATION, gridPane.getScene().getWindow(), "Registration Successful!",
						"Welcome " + customerNameField.getText() + customerSurNameField.getText());
			}

			private void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
				Alert alert = new Alert(alertType);
				alert.setTitle(title);
				alert.setHeaderText(null);
				alert.setContentText(message);
				alert.initOwner(owner);
				alert.show();
			}

		});

		Button button1 = new Button("Add guests");
		gridPane.add(button1, 30, 24);
		button1.setLayoutX(300);
		button1.setLayoutY(400);
		button1.setMinWidth(100);
		button1.setMinHeight(50);
		button1.setMaxWidth(100);
		button1.setMaxHeight(50);
		button1.setPrefWidth(100);
		button1.setPrefHeight(50);

		button1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("Add additional guests, please: ");
			}
		});

	}

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		launch(args);

	}
}






//		Guests guest = new Guests();
//		
//		guest.setId(2749896);
//		guest.setCompany("private");
//		guest.setForename("Marius");
//		guest.setSurname("Berþinskas");
//		guest.setPhone("+37068274345");
//		guest.setStreet("Liepø 3");
//		guest.setCity("Klaipëda");
//		guest.setCountry("Lithuania");
//		guest.setPostal("LT-05132");
//		guest.setEmail("marius.b@gmail.com");
//		guest.setBirth(19991125);
//		
//		guest.insertGuest();
//
//		ArrayList<String> guests = guest.getGuests();
//
//		System.out.println(customers);
//		System.out.println(guests);
//		
//		
//	}
//
//	public boolean someLibraryMethod() {
//		// TODO Auto-generated method stub
//		return false;
//	}
//}
