package banco_superior.persistencia;

import banco_superior.exercicio.ICliente;
import banco_superior_excecao.ClienteJaCadastradoException;
import banco_superior_excecao.ClienteNaoEncontradoException;

public interface IPersistenciaCliente {
	
	
	public void cadastrarCliente(ICliente obj) throws ClienteJaCadastradoException;
	
	public ICliente localizarClientePorCPF(String cpf) throws ClienteNaoEncontradoException;
	
	public ICliente localizarClientePorCNPJ(String cnpj) throws ClienteNaoEncontradoException;
	
	public void removerCliente(ICliente obj);
	
	public void atualizarClientePorCPF(ICliente objClienteAtualizar); 
	
	public void atualizarClientePorCNPJ(ICliente objClienteAtualizar);
	
	
	
}
