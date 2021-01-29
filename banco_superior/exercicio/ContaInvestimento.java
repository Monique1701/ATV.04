package banco_superior.exercicio;

import java.io.Serializable;

import banco_superior_excecao.SaldoInsuficienteException;

public class ContaInvestimento implements IConta, Serializable {
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
	
	public ContaInvestimento(String numeroConta)
	{
		this.numeroConta = numeroConta;
	}
	

	
	public ContaInvestimento(String nome, String numeroConta, String agencia, String tipoConta, String dataAbertura) {
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
		return "ContaInvestimento [nome=" + nome + ", numeroConta=" + numeroConta + ", agencia=" + agencia + ", saldo="
				+ saldo + ", status=" + status + ", tipoConta=" + tipoConta + ", dataAbertura=" + dataAbertura + "]";
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
		ContaInvestimento other = (ContaInvestimento) obj;
		if (numeroConta == null) {
			if (other.numeroConta != null)
				return false;
		} else if (!numeroConta.equals(other.numeroConta))
			return false;
		return true;
	}



	@Override
	public void transferencia(IConta contaDestino, float valorTransferido) throws SaldoInsuficienteException {
		// TODO Auto-generated method stub
		
		if(contaDestino instanceof ContaInvestimento) {
			this.sacar(valorTransferido+(valorTransferido*TAXA_ADMINISTRACAO));
			contaDestino.depositar(valorTransferido);
		} else if(contaDestino instanceof ContaCorrente) {
			this.sacar(valorTransferido+(valorTransferido*TAXA_ADMINISTRACAO));
			contaDestino.depositar(valorTransferido);
		} else {
			this.sacar(valorTransferido+(valorTransferido*TAXA_ADMINISTRACAO));
			contaDestino.depositar(valorTransferido);
			
		}
		
	}

	@Override
	public void sacar(float valorSacado) throws SaldoInsuficienteException {
		if(valorSacado > 0 && this.saldo >= (valorSacado+(valorSacado*CUSTO_SACAR_CONTA_INVESTIMENTO)) &&  this.status)
		{
			this.saldo -= (valorSacado+(valorSacado*CUSTO_SACAR_CONTA_INVESTIMENTO));
		}  else if ((valorSacado+(valorSacado*CUSTO_SACAR_CONTA_INVESTIMENTO))> saldo)
		{
			throw new SaldoInsuficienteException("Saldo insuficiente para a quantia de R$ "+valorSacado+" . Saldo disponível para saque R$ "+saldo);
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
		
	}

	@Override
	public void ativarConta() {
		this.status = true;
		
	}

	


	@Override
	public void pagarMensalidade() {
		float valor = 0;
		if(this.tipoConta == "CC") {
			valor = 12;
		} else if(this.tipoConta == "CI") {
			valor = 22;
		}
		if(this.status) {
			this.saldo = this.saldo - valor;
			System.out.println("Sua mensalidade " + this.nome + " foi paga com sucesso!");
		} else {
			System.out.println("IMPOSSÍVEL PAGAR UMA CONTA FECHADA!");
		}
		
	}


	
	
	
	

}
