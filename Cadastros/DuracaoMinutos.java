package Cadastros;

public class DuracaoMinutos {

	Viagem viagem;
	private int duracaoMinutos;
	
	public DuracaoMinutos(Viagem viagem) {
		super();
		this.viagem = viagem;
	}
	
	public int getDuracaMinutos() {
		
		if (viagem.getMinutosTermino() > viagem.getMinutoInicio()) {
				int duracao = viagem.getMinutosTermino() - viagem.getMinutoInicio();
				setDuracaoMinutos(duracao);
		}else {
			   int duracao = 60 - viagem.getMinutoInicio() +  viagem.getMinutosTermino();
			 	setDuracaoMinutos(duracao);
			if (this.duracaoMinutos == 60) //caso especial
				setDuracaoMinutos(0);
		}
		return this.duracaoMinutos;
	}
 
	private void setDuracaoMinutos(int duracaoMinutos) {
		this.duracaoMinutos = duracaoMinutos;
	}

}
