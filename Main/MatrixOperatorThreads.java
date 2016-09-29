package Main;

public class MatrixOperatorThreads extends Thread
{
	int id, valor, tempo;
	
	public MatrixOperatorThreads(int id, int valor, int tempo) {
		this.id = id;
		this.valor = valor;
		this.tempo = tempo;
	}
	

	@Override
	public void run() {
		for(int i = 0; i < valor; i++)
		{
			System.out.println("id(" + id +")" + " valor: " + i);
			try {
				Thread.sleep(tempo);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	
}
