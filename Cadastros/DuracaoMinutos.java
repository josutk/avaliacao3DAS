package Cadastros;

public class DuracaoMinutos {

	Viagem viagem;
	private int duracaoMinutos;
	
	public DuracaoMinutos(Viagem viagem) {
		super();
		this.viagem = viagem;
	}
	
	public int getDuracaMinutos() {
		
		if (viagem.getMinutosTermino() > viagem.getMinutoInicio()) 
			this.duracaoMinutos = viagem.getMinutosTermino() - viagem.getMinutoInicio();
		else {
			this.duracaoMinutos = 60 - viagem.getMinutoInicio() +  viagem.getMinutosTermino();
			if (this.duracaoMinutos == 60) //caso especial
				this.duracaoMinutos = 0;
		}
		return this.duracaoMinutos;
	}
}
