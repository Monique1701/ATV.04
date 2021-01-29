package banco_superior.exercicio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


public class ClientePessoaJuridica implements ICliente, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	 String nomeFantasia;
	 String cnpj;
	 String dataNascimento;
	 String razaoSocial;
	 String email;
	
	HashSet<String> telefones = new HashSet<String>();
	
	private List<IConta> contas = new ArrayList<IConta>();
	
	
	public ClientePessoaJuridica(String cnpj) {
		this.cnpj = cnpj;
	}
	
	
	public ClientePessoaJuridica(String nomeFantasia, String cnpj, String dataNascimento, String razaoSocial,
			String email) {
		super();
		this.nomeFantasia = nomeFantasia;
		this.cnpj = cnpj;
		this.dataNascimento = dataNascimento;
		this.razaoSocial = razaoSocial;
		this.email = email;
	}

	

	@Override
	public String toString() {
		return "ClientePessoaJuridica [nomeFantasia=" + nomeFantasia + ", cnpj=" + cnpj + ", dataNascimento="
				+ dataNascimento + ", razaoSocial=" + razaoSocial + ", email=" + email + ", telefones=" + telefones
				+ ", contas=" + contas + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cnpj == null) ? 0 : cnpj.hashCode());
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
		ClientePessoaJuridica other = (ClientePessoaJuridica) obj;
		if (cnpj == null) {
			if (other.cnpj != null)
				return false;
		} else if (!cnpj.equals(other.cnpj))
			return false;
		return true;
	}


	public void adicionarcontaCliente(IConta contaCliente) {
		contas.add(contaCliente);
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
		 this.telefones.add(telefone);
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


	@Override
	public IConta buscarContaInvestimento(String numeroDaConta) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void setNome(String novoNome) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void setRazaoSocial(String novaRazao) {
		// TODO Auto-generated method stub
		this.razaoSocial = novaRazao;
	}
	 
	

}





	
	

