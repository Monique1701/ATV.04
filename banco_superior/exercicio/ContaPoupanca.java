package banco_superior.exercicio;

import java.io.Serializable;

import banco_superior_excecao.SaldoInsuficienteException;

public class ContaPoupanca implements IConta, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Atributos
	private String nome;
	String numeroConta;
	String agencia;
	private float saldo;
	boolean status;
	protected String tipoConta;
	String dataAbertura;
	
	
	
	
	public ContaPoupanca(String nome, String numeroConta, String agencia, String tipoConta, String dataAbertura) {
		this.nome = nome;
		this.numeroConta = numeroConta;
		this.agencia = agencia;
		this.saldo = 0f;
		this.status = true;
		this.tipoConta = tipoConta;
		this.dataAbertura = dataAbertura;
	}
	
	
	
	@Override
	public String toString() {
		return "ContaPoupanca [nome=" + nome + ", numeroConta=" + numeroConta + ", agencia=" + agencia + ", saldo="
				+ saldo + ", status=" + status + ", tipoConta=" + tipoConta + ", dataAbertura=" + dataAbertura + "]";
	}



	@Override
	public void transferencia(IConta contaDestino, float valorTransferido) throws SaldoInsuficienteException{
		// TODO Auto-generated method stub
		
		if(contaDestino instanceof ContaPoupanca) {
			this.sacar(valorTransferido+(valorTransferido*TAXA_ADMINISTRACAO));
			contaDestino.depositar(valorTransferido);
		
		} else if(contaDestino instanceof ContaInvestimento) {
			this.sacar(valorTransferido+(valorTransferido*TAXA_ADMINISTRACAO));
			contaDestino.depositar(valorTransferido);
		
		} else {
			this.sacar(valorTransferido+(valorTransferido*TAXA_ADMINISTRACAO));
			contaDestino.depositar(valorTransferido);
		
		}
		
	}
	
	@Override
	public void sacar(float valorSacado) throws SaldoInsuficienteException {
		if(valorSacado > 0 && this.saldo >= (valorSacado+(valorSacado*CUSTO_SACAR_CONTA_POUPANCA)) &&  this.status)
		{
			this.saldo -= (valorSacado+(valorSacado*CUSTO_SACAR_CONTA_POUPANCA));
		
		} else if((valorSacado+(valorSacado*CUSTO_SACAR_CONTA_POUPANCA))> saldo)
		{
			throw new SaldoInsuficienteException("Saldo insuficente");
		}
	
	}

	@Override
	public void depositar(float valorDepositado) {
		if (valorDepositado>0 && this.status) {
			this.saldo += valorDepositado;
			System.out.println("Valor depositado com sucesso!!");
		} else if (valorDepositado<=0) {
			System.err.println("Valor insuficiente para depósito!!");
		} else if(this.status == false) {
			System.err.println("Impossível realizar depósito, conta desativada!!");
		} else {
			System.out.println("Não foi possível realizar o depósito!!");
		}
		
	}

	@Override
	public void desativarConta() {
		this.status = false;
		System.out.println("Conta desativada");
		
	}

	@Override
	public void ativarConta() {
		this.status = true;
		System.out.println("Conta ativada");
		
	}




	@Override
	public void pagarMensalidade() {
		float valor = 0;
		if(this.tipoConta == "CI") {
			valor = 22;
		} else if(this.tipoConta == "CP") {
			valor = 20;
		}
		if(this.status) {
			this.saldo = this.saldo - valor;
			System.out.println("Mensalidade paga com sucesso  " + this.nome);
		} else {
			System.out.println("IMPOSSÍVEL PAGAR UMA CONTA FECHADA!");
		}
	}

	
	
	


}