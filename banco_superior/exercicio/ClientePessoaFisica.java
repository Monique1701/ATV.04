package banco_superior.exercicio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;



public class ClientePessoaFisica implements ICliente, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String nome;
	String cpf;
	String rg;
	String dataNascimento;
	
	HashSet<String> telefones = new HashSet<String>();
	
	private List<IConta> contas = new ArrayList<IConta>();
;	
	
	public ClientePessoaFisica(String nome, String cpf, String rg, String dataNascimento) {
	
		this.rg = rg;
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		
	}
	
	public ClientePessoaFisica(String cpf)
	{
		this.cpf = cpf;
	}
	
	@Override
	public String toString() {
		return "ClientePessoaFisica [nome=" + nome + ", cpf=" + cpf + ", rg=" + rg + ", dataNascimento="
				+ dataNascimento + ", telefones=" + telefones + ", contas=" + contas + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
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
		ClientePessoaFisica other = (ClientePessoaFisica) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}

	public boolean contemContaCliente(IConta conta)
	{
		return this.contas.contains(conta);                                                               
	}
	
	
	public void removerConta(IConta conta)
	{
		if(contas.contains(conta)) 
		{
			contas.remove(conta);
			System.out.println("Conta removida com sucesso");
		}
		else 
		{
			System.out.println("Conta Inexistente");
			
		}
	}
	 public void adicionarTelefone(String telefone)
	 {
		 	telefones.add(telefone);
	 }
	 
	 public void removerTelefone(String telefone)
	 {
		 if(telefones.contains(telefone))
		 {
			 telefones.remove(telefone);
		 }
		 else 
		 {
			 System.out.println("Cliente não tem o referido relefone");
		 }
	 }


	public void adicionarcontaCliente(IConta contaCliente) {
		contas.add(contaCliente);
		
	}


	
	public IConta buscarContaInvestimento(String numeroDaConta)
	{
		IConta conta = new ContaInvestimento(numeroDaConta);
		if(contas.contains(conta))
		{
			int index = contas.indexOf(conta);
			conta = contas.get(index);
		}
		return conta;
	}

	@Override
	public void setNome(String novoNome) {
		// TODO Auto-generated method stub
		this.nome = novoNome;
	}

	@Override
	public void setRazaoSocial(String novaRazao) {
		// TODO Auto-generated method stub
		
	}



	
	
	
	
	

}
