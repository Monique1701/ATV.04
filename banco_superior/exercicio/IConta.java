package banco_superior.exercicio;

import banco_superior_excecao.SaldoInsuficienteException;

public interface IConta {
	public final float CUSTO_SACAR_CONTA_CORRENTE = 0.01f;
	public final float CUSTO_SACAR_CONTA_INVESTIMENTO = 0.01f;
	public final float CUSTO_SACAR_CONTA_POUPANCA = 0.01f;
	public final float RENDIMENTO_POUPANCA = 0.03f;
	public final float TAXA_ADMINISTRACAO = 0.05f;

	
	public void sacar(float valorSacado) throws SaldoInsuficienteException;
	
	public void  depositar(float valorDepositado);
	
	public void desativarConta();
	
	public void pagarMensalidade();
	
	public void transferencia(IConta contaDestino, float valorTransferido) throws SaldoInsuficienteException;
	
	public void ativarConta();
	
}
