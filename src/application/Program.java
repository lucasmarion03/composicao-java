package application;

// Libs
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

// Entidades
import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner input = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
			// Preenchimento de dados do funcionário 
			System.out.print("Entre com o nome do departamento: ");
			String nomeDepartamento = input.nextLine();
			System.out.println("==Insira os dados do funcionário==");
			System.out.print("Nome: ");
			String nomeFuncionario = input.nextLine();
			System.out.print("Nível: ");
			String nivelFuncionario = input.nextLine();
			System.out.print("Salário base: ");
			double salarioBase = input.nextDouble();
			Worker funcionario = new Worker(nomeFuncionario, WorkerLevel.valueOf(nivelFuncionario), salarioBase, new Department(nomeDepartamento));
			
			// Preenchimento de dados dos contratos
			System.out.print("Informe o número de contratos do funcionário: ");
			int n = input.nextInt();
			for (int i = 1; i <= n; i++) {
				System.out.println("================");
				System.out.println("Contrato #" + i);
				System.out.print("Data (DD/MM/YYYY): ");
				Date dataContrato = sdf.parse(input.next());
				System.out.print("Valor por hora: ");
				double valorHora = input.nextDouble();
				System.out.print("Duração do contrato: ");
				int horas = input.nextInt();
				HourContract contrato = new HourContract(dataContrato, valorHora, horas);
				funcionario.adicionarContrato(contrato);
			}
			System.out.println("================");
			
			System.out.print("Entre com o mês e ano para calcular o salário (MM/YYYY): ");
			String data = input.next();
			int mes = Integer.parseInt(data.substring(0, 2));
			int ano = Integer.parseInt(data.substring(3));
			
			System.out.println("Nome: " + funcionario.getNome());
			System.out.println("Departmanento: " + funcionario.getDepartamento().getNome());
			System.out.println("Salário em " + data + ": " + String.format("%.2f", funcionario.gerarRenda(mes, ano)));
			
			
		input.close();

	}

}
