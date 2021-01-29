package banco_superior.exercicio;

public interface ICliente {
	
	public void adicionarcontaCliente(IConta contaCliente);
	
	public void adicionarTelefone(String telefone);
	
	public void removerTelefone(String telefone);
	
	public IConta buscarContaInvestimento(String numeroDaConta);
	
	public void setNome(String novoNome);
	
	public void setRazaoSocial(String novaRazao);
	

	
	
}
