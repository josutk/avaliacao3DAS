package Cadastros;

public class DuracaoHoras {
	
	private Viagem viagem;
	private int duracaoHoras; 

	public DuracaoHoras(Viagem viagem) {
		super();
		this.viagem = viagem;
	}
	
	public int getDuracaoHoras() {
		
		if (checkInicioIgualFim(0))
			setDuracaoHoras(0);
		if (viagem.getHoraTermino() > viagem.getHoraInicio()) //varias possibilidades... 
			if (checkInicioIgualFim(1)) {  
				if (viagem.getMinutosTermino() < viagem.getHoraInicio())  //nao chegou a uma hora
					setDuracaoHoras(0);
		 		else //durou pelo menos uma hora
					setDuracaoHoras(1);
			} else { //possivelmente ultrapassou duas horas
				if (duracaoViagem() > 2) { //
					int duracao = duracaoViagem();
					setDuracaoHoras(duracao);
				}else if (duracaoViagem() == 2 &&   //certamente menos de duas horas  
						 viagem.getMinutosTermino() < viagem.getMinutoInicio()) {
					//e mais de uma hora
					setDuracaoHoras(1); ;	
				}
				else //duracao de duas horas, certamente
					setDuracaoHoras(2);
			}
		
		if (viagem.getHoraTermino() < viagem.getHoraInicio()) 
			setDuracaoHoras(-1) ; //para casos em que a hora de termino nao foi registrada
		return this.duracaoHoras;
	}

	public void setDuracaoHoras(int duracaoHoras) {
		this.duracaoHoras = duracaoHoras;
	}

	private int duracaoViagem() {
		return viagem.getHoraTermino() -  viagem.getHoraInicio();
	}

	private boolean checkInicioIgualFim(int constante) {
		return viagem.getHoraTermino() == viagem.getHoraInicio() + constante;
	}

}
