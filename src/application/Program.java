package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import entities.Employee;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("How many employees will be registered?");
		
		int n = sc.nextInt();
		
	
		
		List<Employee> list = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			
			System.out.printf("Employee #" + i + "\n");
			System.out.printf("Id: \n");
		    int id = sc.nextInt();
			System.out.printf("Nome: \n");
			String name = sc.next();
			System.out.printf("Salary: \n");
			double salary = sc.nextDouble();
			
			System.out.printf("=================\n");
			System.out.printf("");
			System.out.printf("");
			
			
			list.add(new Employee(id, name, salary));
			
			
		}
		
		for(Employee x : list) {
			System.out.println("id: " + x.getId() + ", " + "Nome: " + x.getName() + ", " + "Salary: " + x.getSalary());
		}
		
		System.out.println("\nFala ai o id do homi que tu quer dar aumento: ");
		int scrid = sc.nextInt(); 
		List<Employee> result = list.stream().filter(x -> x.getId() == scrid).collect(Collectors.toList());
		
		if(result.isEmpty()) {
		  System.out.println("Id inválido.");	
			
		}else{	
			System.out.println("\nDiz a porcentagem: ");
			int aum = sc.nextInt();
			for(Employee x : result) {
				x.aumento(x.getSalary(), aum);
			}
			
			for(Employee x : list) {
				System.out.println("id: " + x.getId() + ", " + "Nome: " + x.getName() + ", " + "Salary: " + x.getSalary());
			}
		}
		sc.close();
		

	}

}
