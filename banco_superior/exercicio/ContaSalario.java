package banco_superior.exercicio;

import java.io.Serializable;

import banco_superior_excecao.SaldoInsuficienteException;

public class ContaSalario implements IConta, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Atributos
	private String nome;
	String numeroConta;
	String agencia;
	private float saldo;
	protected String tipoConta;
	boolean status;
	String dataAbertura;
	
	

	public ContaSalario(String nome, String numeroConta, String agencia, String tipoConta, String dataAbertura) {
		this.nome = nome;
		this.numeroConta = numeroConta;
		this.agencia = agencia;
		this.saldo = 0f;
		this.status = true;
		this.tipoConta = tipoConta;
		this.dataAbertura = dataAbertura;
	}

	@Override
	public void sacar(float valorSacado) throws SaldoInsuficienteException {
		if(valorSacado <= this.saldo && this.status) {
			this.saldo -= valorSacado;
		} else if (valorSacado <= 0){
			System.err.println("Valor digitado incorreto para saque!!");
		} else if (this.status == false) {
			System.err.println("Operação inválida, conta inativa!!");
		} else 
			throw new SaldoInsuficienteException("Saldo insuficiente para a quantia de R$ "+valorSacado+" . Saldo disponível para saque R$ "+saldo);


		}
		
	

	@Override
	public void depositar(float valorDepositado) {
		if(this.status == true) {
			this.saldo = this.saldo + valorDepositado;
			System.out.println("Seu deposito foi realizado " + this.nome);
		}else {
			System.out.println("IMPOSSÍVEL DEPOSITAR EM UMA CONTA FECHADA!");
		
		}
		
	}

	@Override
	public void desativarConta() {
		this.status = false;
		System.out.println("Conta desativada");
	}

	@Override
	public void transferencia(IConta contaDestino, float valorTransferido) {
		if(contaDestino == null)
		{
			 System.err.println("Conta salário não faz transferência!");
		}
		
	}

	@Override
	public void ativarConta() {
		this.status = true;
		System.out.println("Conta ativada");
	}



	@Override
	public String toString() {
		return "ContaSalario [nome=" + nome + ", numeroConta=" + numeroConta + ", agencia=" + agencia + ", saldo="
				+ saldo + ", tipoConta=" + tipoConta + ", status=" + status + ", dataAbertura=" + dataAbertura + "]";
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numeroConta == null) ? 0 : numeroConta.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContaSalario other = (ContaSalario) obj;
		if (numeroConta == null) {
			if (other.numeroConta != null)
				return false;
		} else if (!numeroConta.equals(other.numeroConta))
			return false;
		return true;
	}

	@Override
	public void pagarMensalidade() {
		float valor = 0;
		if(this.tipoConta == "CC") {
			valor = 12;
		} else if(this.tipoConta == "CS") {
			valor = 11;
		}
		if(this.status) {
			this.saldo = this.saldo - valor;
			System.out.println(this.nome + " Sua mensalidade foi paga com sucesso!");
		} else {
			System.out.println("IMPOSSÍVEL PAGAR UMA CONTA FECHADA!");
		}
		
	}

	
	
	
	
	
	

}
