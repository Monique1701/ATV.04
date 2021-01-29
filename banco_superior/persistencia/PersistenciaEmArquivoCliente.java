package banco_superior.persistencia;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import banco_superior.exercicio.ClientePessoaFisica;
import banco_superior.exercicio.ClientePessoaJuridica;
import banco_superior.exercicio.ICliente;
import banco_superior_excecao.ClienteJaCadastradoException;
import banco_superior_excecao.ClienteNaoEncontradoException;

public class PersistenciaEmArquivoCliente implements IPersistenciaCliente{

	private List<ICliente> clientesCadastrados = new ArrayList<ICliente>();
	
	public PersistenciaEmArquivoCliente()
	{
		lerConteudoArquivo(); 
	}
	
	@Override
	public void cadastrarCliente(ICliente obj) throws ClienteJaCadastradoException{
		if(!clientesCadastrados.contains(obj)) {
			clientesCadastrados.add(obj);
			salvarEmArquivo();
		} 
		else 
			throw new ClienteJaCadastradoException("Cliente do tipo "+obj.getClass().getName()+" já se encontra cadastrado no banco!");
	}
		
		


	@Override
	public ICliente localizarClientePorCPF(String cpf) throws ClienteNaoEncontradoException {
		ICliente cliente = new ClientePessoaFisica(cpf);
		
		if(clientesCadastrados.contains(cliente)) {
			int index  = clientesCadastrados.indexOf(cliente);
			cliente = clientesCadastrados.get(index);
		}
		else 
			throw new ClienteNaoEncontradoException("Cliente de "+cpf+" não encontrado!");
		
			
		
		return cliente;
	}

	@Override
	public ICliente localizarClientePorCNPJ(String cnpj) throws ClienteNaoEncontradoException {
	ICliente cliente = new ClientePessoaJuridica(cnpj);
		
		if(clientesCadastrados.contains(cliente)) {
			int index  = clientesCadastrados.indexOf(cliente);
			cliente = clientesCadastrados.get(index);
		}
		else 
			throw new ClienteNaoEncontradoException("Cliente de "+cnpj+" não encontrado!");
		
		return cliente;
		
	}

	@Override
	public void removerCliente(ICliente obj) {
		if(clientesCadastrados.contains(obj)) {
			clientesCadastrados.remove(obj);
			salvarEmArquivo(); 
		} else {
			System.err.println("Não pode remover um cliente que não está cadastrado");
		}
		
		
		
	}

	private void salvarEmArquivo()
	{
		try
		{
			FileOutputStream fos = new FileOutputStream("persistencia_cliente.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(clientesCadastrados);
			oos.close();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
			
		}
		catch (IOException e) {
			e.printStackTrace();
			
		}
	}
	
	@SuppressWarnings("unchecked")
	private void lerConteudoArquivo()
	{
		try 
		{
			FileInputStream fis = new FileInputStream("persistencia_cliente.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			Object obj = ois.readObject();
			clientesCadastrados = (ArrayList<ICliente>)obj;
			
		} 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void atualizarClientePorCPF(ICliente objClienteAtualizar) {
		// TODO Auto-generated method stub
		if(clientesCadastrados.contains(objClienteAtualizar)) {
			int index = clientesCadastrados.indexOf(objClienteAtualizar);
			clientesCadastrados.set(index, objClienteAtualizar);
			salvarEmArquivo();
			System.out.println("Atualização realizada com sucesso!");
		} else {
			System.err.println("Cliente não está cadastrado!");
		}
		
	}

	@Override
	public void atualizarClientePorCNPJ(ICliente objClienteAtualizar) {
		// TODO Auto-generated method stub
		if(clientesCadastrados.contains(objClienteAtualizar)) {
			int index = clientesCadastrados.indexOf(objClienteAtualizar);
			clientesCadastrados.set(index, objClienteAtualizar);
			salvarEmArquivo();
			System.out.println("Atualização realizada com sucesso!");
			
		}else {
			System.out.println("Cliente não está cadastrado!");
		}
		
	}

	
}
		
		
	
	
		
		 


