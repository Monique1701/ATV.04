package banco_superior.exercicio;


import banco_superior.persistencia.IPersistenciaCliente;
import banco_superior.persistencia.PersistenciaEmArquivoCliente;
import banco_superior_excecao.ClienteNaoEncontradoException;


public class Programa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		IPersistenciaCliente pac = new PersistenciaEmArquivoCliente();
		
		
		ICliente cliente1 = null;
		
		
		
		
		try 
		{
		cliente1 = pac.localizarClientePorCPF("122");
		
			
		} 
		catch (ClienteNaoEncontradoException e) 
		 {
		// TODO Auto-generated catch block
			e.printStackTrace();
		 }
		
		
		System.out.println(cliente1);
		
	
	
	
	


//	
//		try
//		{
//			cliente1.buscarContaInvestimento("060").sacar(99f);
//		}
//		
//		catch (SaldoInsuficienteException e) 
//		{
//			// TODO Auto-generated catch block
//			System.err.println(e.getMessage());
//	
//		}		
//		System.out.println(cliente1);
			
//			cliente1.buscarContaInvestimento("060").depositar(10f);
//		
//			try 
//			{
//			cliente1.buscarContaInvestimento("060").sacar(100f);
//			} 
//			catch (SaldoInsuficienteException e)
//			{
//				// TODO Auto-generated catch block
//			e.printStackTrace();
//			}
//		
//		

	
		
	
	
	}

}
