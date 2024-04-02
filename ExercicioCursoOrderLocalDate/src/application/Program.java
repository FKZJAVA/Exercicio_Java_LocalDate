package application;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter cliente data: ");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Birth date (DD/MM/YYYY): ");
		String date1 = sc.next();
		LocalDate birthDate = LocalDate.parse(date1,DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		
		Client client = new Client(name,email,birthDate);
		
		System.out.println("Enter Order Data:");
		System.out.print("Status: ");
		String orderStatus = sc.next();
		
		Order order =  new Order(LocalDateTime.now(),OrderStatus.valueOf(orderStatus),client);
		
		System.out.print("How many items to this order? ");
		int N = sc.nextInt();
		
		for (int i = 0 ; i<N;i++) {
			System.out.printf("Enter #%d item data:\n", i + 1);
			System.out.print("Product name: ");
			sc.nextLine();
			String productName = sc.next();
			System.out.print("Product price: ");
			double productPrice = sc.nextDouble();
			System.out.print("Quantity: ");
			int quantity = sc.nextInt();

			Product product = new Product(productName, productPrice);
			OrderItem orderitem = new OrderItem(quantity, productPrice, product);

			order.addItem(orderitem);
		}
		
		System.out.println(order);
		
		
		
		
		
		
		
		
		
		
		sc.close();
	}

}
