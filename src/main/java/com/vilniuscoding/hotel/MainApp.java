package com.vilniuscoding.hotel;

import javafx.application.Application;

import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;

import javafx.scene.control.Alert;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.io.PrintStream;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import java.util.Locale;

import javafx.geometry.HPos;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;

import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

public class MainApp extends Application {

	private Stage stage;

	PrintStream standardOut;
	private DatePicker checkInDatePicker;
	private DatePicker checkOutDatePicker;

	Booking booking = new Booking();
	RoomPrice roomPrice = new RoomPrice();
	Customer customer = new Customer();
	RoomType roomType = new RoomType();
	Rooms rooms = new Rooms();
	Calculations calc = new Calculations();

	@Override
	public void start(Stage stage) {

		this.stage = stage;
		stage.setTitle(" Hotel Booking Reservation ");
		initUI();
		stage.show();
	}

	private void initUI() {

		VBox vbox = new VBox(20);

		vbox.setStyle("-fx-padding: 40;-fy-padding: 50;");
		Scene scene = new Scene(vbox, 1000, 900);
		scene.getStylesheets().add(getClass().getResource("MainApp.css").toExternalForm());
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

						setTooltip(new Tooltip("You're about to stay for " + p + " nights"));

					}

				};

			}

		};

		checkOutDatePicker.setDayCellFactory(dayCellFactory);
		checkOutDatePicker.setValue(checkInDatePicker.getValue().plusDays(1));

		checkInDatePicker.setOnAction(new EventHandler<ActionEvent>() {
			// public LocalDate checkIn;

			@Override
			public void handle(ActionEvent event) {
				calc.setCheckIn(checkInDatePicker.getValue());
				booking.setBookDate(String.valueOf(LocalDate.now()));
				booking.setBookStart(String.valueOf(calc.getCheckIn()));
				System.err.println("Selected Check-in date: " + calc.getCheckIn());
				return;
			}
		});

		checkOutDatePicker.setOnAction(new EventHandler<ActionEvent>() {
			// public LocalDate checkOut;
			@Override
			public void handle(ActionEvent event) {
				calc.setCheckOut(checkOutDatePicker.getValue());
				System.err.println("Selected Check-out date: " + calc.getCheckOut());

				booking.setBookEnd(String.valueOf(calc.getCheckOut()));
				System.out.println("Total stay nights: " + calc.calcStayNights(calc.getCheckIn(), calc.getCheckOut()));

				return;

			}

		});

		GridPane gridPane = new GridPane();
		gridPane.setHgap(10);
		gridPane.setVgap(10);
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
		gridPane.add(companyNameLabel, 31, 1);

		TextField companyNameField = new TextField();
		companyNameField.setPrefHeight(20);
		companyNameField.setPromptText("Enter text here");
		gridPane.add(companyNameField, 31, 2);

		Label companyIdLabel = new Label("Company or passport ID : ");
		gridPane.add(companyIdLabel, 31, 3);

		TextField companyIdField = new TextField();
		companyIdField.setPrefHeight(20);
		companyIdField.setPromptText("Enter text here");
		gridPane.add(companyIdField, 31, 4);

		Label customerNameLabel = new Label("Customer Name : ");
		gridPane.add(customerNameLabel, 31, 5);

		TextField customerNameField = new TextField();
		customerNameField.setPrefHeight(20);
		customerNameField.setPromptText("Enter text here");
		gridPane.add(customerNameField, 31, 6);

		Label customerSurNameLabel = new Label("Customer Last Name : ");
		gridPane.add(customerSurNameLabel, 31, 7);

		TextField customerSurNameField = new TextField();
		customerSurNameField.setPrefHeight(20);
		customerSurNameField.setPromptText("Enter text here");
		gridPane.add(customerSurNameField, 31, 8);

		Label customerPhoneLabel = new Label("Phone Number : ");
		gridPane.add(customerPhoneLabel, 31, 9);

		TextField customerPhoneField = new TextField();
		customerPhoneField.setPrefHeight(20);
		customerPhoneField.setPromptText("Enter text here");
		gridPane.add(customerPhoneField, 31, 10);

		Label customerAdressLabel = new Label("Adress : ");
		gridPane.add(customerAdressLabel, 31, 11);

		TextField customerAdressField = new TextField();
		customerPhoneField.setPrefHeight(20);
		customerAdressField.setPromptText("Enter text here");
		gridPane.add(customerAdressField, 31, 12);

		Label customerCityLabel = new Label("City : ");
		gridPane.add(customerCityLabel, 31, 13);

		TextField customerCityField = new TextField();
		customerCityField.setPrefHeight(20);
		customerCityField.setPromptText("Enter text here");
		gridPane.add(customerCityField, 31, 14);

		Label customerCountryLabel = new Label("Country : ");
		gridPane.add(customerCountryLabel, 31, 15);

		TextField customerCountryField = new TextField();
		customerCountryField.setPrefHeight(20);
		customerCountryField.setPromptText("Enter text here");
		gridPane.add(customerCountryField, 31, 16);

		Label customerPostalLabel = new Label("Post Code : ");
		gridPane.add(customerPostalLabel, 31, 17);

		TextField customerPostalField = new TextField();
		customerPostalField.setPrefHeight(20);
		customerPostalField.setPromptText("Enter text here");
		gridPane.add(customerPostalField, 31, 18);

		Label customerEmailLabel = new Label("Email adress : ");
		gridPane.add(customerEmailLabel, 31, 19);

		TextField customerEmailField = new TextField();
		customerEmailField.setPrefHeight(20);
		customerEmailField.setPromptText("Enter text here");
		gridPane.add(customerEmailField, 31, 20);

		Label customerBirthLabel = new Label("Date of Birth : ");
		gridPane.add(customerBirthLabel, 31, 21);

		TextField customerBirthField = new TextField();
		customerBirthField.setPrefHeight(20);
		customerBirthField.setPromptText("Enter text here");
		gridPane.add(customerBirthField, 31, 22);

		Label typeOfRoomLabel = new Label("Choose type of room  : ");
		gridPane.add(typeOfRoomLabel, 20, 1);

		MenuButton typeOfRoomMenu = new MenuButton("Room Type");
		typeOfRoomMenu.setMinWidth(150);
		typeOfRoomMenu.setMinHeight(25);
		typeOfRoomMenu.setMaxWidth(150);
		typeOfRoomMenu.setMaxHeight(25);
		typeOfRoomMenu.setPrefWidth(150);
		typeOfRoomMenu.setPrefHeight(25);

		gridPane.add(typeOfRoomMenu, 20, 2);
		MenuItem standSingleRoom = new MenuItem("Standart Single Room (1 - 2)");
		MenuItem standDoubleRoom = new MenuItem("Standart Double Room (3 - 4)");
		MenuItem superiorRoom = new MenuItem("Superior Room (5 - 10)");
		MenuItem deluxeRoom = new MenuItem("Deluxe Room (11 - 16)");
		typeOfRoomMenu.getItems().addAll(standSingleRoom, standDoubleRoom, superiorRoom, deluxeRoom);

		standSingleRoom.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				typeOfRoomMenu.setText("Standart Single Room (1 - 2)");
				roomType.setId(1);
				roomType.setType("Standart Single Room");
				roomPrice.setPrice(30.00);

			}
		});

		standDoubleRoom.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				typeOfRoomMenu.setText("Standart Double Room (3 - 4)");
				roomType.setId(2);
				roomType.setType("Standart Double Room");
				roomPrice.setPrice(40.00);
			}
		});

		superiorRoom.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				typeOfRoomMenu.setText("Superior Room (5 - 10)");
				roomType.setId(3);
				roomType.setType("Superior Room");
				roomPrice.setPrice(85.00);
			}
		});

		deluxeRoom.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				typeOfRoomMenu.setText("Deluxe Room (11 - 16)");
				roomType.setId(4);
				roomType.setType("Deluxe Room");
				roomPrice.setPrice(100.00);
			}
		});

		Label roomQtyLabel = new Label("Number of rooms : ");
		gridPane.add(roomQtyLabel, 20, 5);

		TextField roomQtyField = new TextField();
		roomQtyField.setPrefHeight(20);
		roomQtyField.setPromptText("Number of Rooms");
		gridPane.add(roomQtyField, 20, 6);

		Label roomNumberLabel = new Label("Room number : ");
		gridPane.add(roomNumberLabel, 20, 3);

		TextField roomNumberField = new TextField();
		roomNumberField.setPrefHeight(20);
		roomNumberField.setPromptText("Room number");
		gridPane.add(roomNumberField, 20, 4);

		Label roomCheckOutNumberLabel = new Label("Check IN_Out Room NR. : ");
		gridPane.add(roomCheckOutNumberLabel, 20, 8);

		TextField roomCheckOutNumberField = new TextField();
		roomCheckOutNumberField.setPrefHeight(20);
		roomCheckOutNumberField.setPromptText("Check Out Room number");
		gridPane.add(roomCheckOutNumberField, 20, 9);

		Button button = new Button("Book");
		gridPane.add(button, 0, 24);
		button.setLayoutX(300);
		button.setLayoutY(200);
		button.setMinWidth(150);
		button.setMinHeight(50);
		button.setMaxWidth(150);
		button.setMaxHeight(50);
		button.setPrefWidth(150);
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

				if (roomQtyField.getText().isEmpty()) {
					showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!",
							"Please enter number of rooms needed");

					return;

				}

				if (roomNumberField.getText().isEmpty()) {
					showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!",
							"Please enter the number of the Room");

					return;

				}

				calc.setPricePerRoom(roomPrice.getPrice());

				calc.setRoomQty(Integer.parseInt(roomQtyField.getText()));

				booking.setTotalPay(calc.calcTotalPay(calc.getStayNights(), calc.getPricePerRoom(), calc.getRoomQty()));

				customer.setId(companyIdField.getText());
				customer.setCompany(companyNameField.getText());
				customer.setForename(customerNameField.getText());
				customer.setSurname(customerSurNameField.getText());
				customer.setPhone(customerPhoneField.getText());
				customer.setStreet(customerAdressField.getText());
				customer.setCity(customerCityField.getText());
				customer.setCountry(customerCountryField.getText());
				customer.setPostal(customerPostalField.getText());
				customer.setEmail(customerEmailField.getText());
				customer.setBirth(customerBirthField.getText());

				customer.insertCustomer(); // Insert customer data to data base

				booking.insertBooking(); // Insert booking data to data base

				showAlert(Alert.AlertType.CONFIRMATION, gridPane.getScene().getWindow(), "Registration Successful!",
						"Customer: " + customerNameField.getText() + " " + customerSurNameField.getText() + '\n'
								+ "Room: " + typeOfRoomMenu.getText() + '\n' + "Room price per night: "
								+ roomPrice.getPrice() + " EUR" + '\n' + "Room Number: " + roomNumberField.getText()
								+ '\n' + "Ordered nights: " + calc.getStayNights() + '\n' + "Room quantity: "
								+ roomQtyField.getText() + '\n' + "Total price: " + calc.getTotalPrice() + " EUR");

			}

		});

		Button button1 = new Button("Check Rooms Status");
		gridPane.add(button1, 20, 24);
		button1.setLayoutX(300);
		button1.setLayoutY(400);
		button1.setMinWidth(150);
		button1.setMinHeight(50);
		button1.setMaxWidth(150);
		button1.setMaxHeight(50);
		button1.setPrefWidth(150);
		button1.setPrefHeight(50);

		button1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {

				TextArea textArea = new TextArea();
				textArea.setPrefHeight(400);
				textArea.setMinWidth(300);
				textArea.setMinHeight(400);
				textArea.setMaxWidth(300);
				textArea.setMaxHeight(400);
				textArea.setPrefWidth(300);
				textArea.setPrefHeight(400);
				// textArea.setEditable(false);
				PrintStream printStream = new PrintStream(new CustomOutputStream(textArea));

				// keeps reference of standard output stream
				standardOut = System.out;

				// re-assigns standard output stream and error output stream
				System.setOut(printStream);
				System.setErr(printStream);

				StackPane secondaryLayout = new StackPane();
				secondaryLayout.getChildren().add(textArea);

				Scene secondScene = new Scene(secondaryLayout, 400, 700);
				secondScene.getStylesheets().add(getClass().getResource("MainApp.css").toExternalForm());

				// New window (Stage)
				Stage newWindow = new Stage();
				newWindow.setTitle("Hotel Room Status");
				newWindow.setScene(secondScene);

				// Set position of second window, related to primary window.
				newWindow.setX(stage.getX() + 1000);
				newWindow.setY(stage.getY() + 100);
				newWindow.show();

				rooms.getRooms();

//				showAlert(Alert.AlertType.CONFIRMATION, gridPane.getScene().getWindow(), "ROOM STATUS", "ROOM STATUS: "
//						+ '\n' + "Id, Floor, Description, Occupied, Cleaned: " + '\n' + rooms.getRooms());

			}
		});

		Button button2 = new Button("Check Out");
		gridPane.add(button2, 20, 10);
		button2.setMinWidth(150);
		button2.setMinHeight(25);
		button2.setMaxWidth(150);
		button2.setMaxHeight(25);
		button2.setPrefWidth(150);
		button2.setPrefHeight(25);

		button2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {

				if (roomCheckOutNumberField.getText().isEmpty()) {
					showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!",
							"Please enter Check Out Room number");

					return;

				}

				rooms.setId(Integer.parseInt(roomCheckOutNumberField.getText()));
				rooms.setOccupied(false);
				rooms.setCleaned(true);
				rooms.changeStatusCleaned();
				rooms.changeStatusOccupied();
			}
		});

		Button button3 = new Button("Check In");
		gridPane.add(button3, 20, 11);
//		button3.setLayoutX(300);
//		button3.setLayoutY(400);
		button3.setMinWidth(150);
		button3.setMinHeight(25);
		button3.setMaxWidth(150);
		button3.setMaxHeight(25);
		button3.setPrefWidth(150);
		button3.setPrefHeight(25);

		button3.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {

				if (roomCheckOutNumberField.getText().isEmpty()) {
					showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!",
							"Please enter Check IN_OUT Room number");

					return;

				}

				rooms.setId(Integer.parseInt(roomCheckOutNumberField.getText()));
				rooms.setOccupied(true);
				rooms.setCleaned(false);
				rooms.changeStatusCleaned();
				rooms.changeStatusOccupied();
			}
		});

	}

	public void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
		Alert alert = new Alert(alertType);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.setContentText(message);
		alert.initOwner(owner);
		alert.show();
	}

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		launch(args);

	}
}
