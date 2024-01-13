package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.WorkerLevel;

public class Worker {
	// Atributos
	private String nome;
	private WorkerLevel nivel;
	private Double salarioBase;
	
	// Associações
	private Department departamento;
	private List<HourContract> contratos = new ArrayList<>();
	
	public Worker() {
		
	}

	public Worker(String nome, WorkerLevel nivel, Double salarioBase, Department departamento) {
		this.nome = nome;
		this.nivel = nivel;
		this.salarioBase = salarioBase;
		this.departamento = departamento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(Double salarioBase) {
		this.salarioBase = salarioBase;
	}

	public WorkerLevel getNivel() {
		return nivel;
	}

	public void setNivel(WorkerLevel nivel) {
		this.nivel = nivel;
	}

	public Department getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Department departamento) {
		this.departamento = departamento;
	}

	public List<HourContract> getContratos() {
		return contratos;
	}
	
	public void adicionarContrato(HourContract contrato) {
		contratos.add(contrato);
	}
	
	public void removerContrato(HourContract contrato) {
		contratos.remove(contrato);
	}
	
	public Double gerarRenda(int mes, int ano) {
		double soma = salarioBase;
		Calendar calendario = Calendar.getInstance();
		for (HourContract c : contratos) {
			calendario.setTime(c.getData());
			int cAno = calendario.get(Calendar.YEAR);
			int cMes = 1 + calendario.get(Calendar.MONTH);;
			if (cAno == ano && cMes == mes) {
				soma += c.valorTotal();
			}
		}
		return soma;
	}
}
