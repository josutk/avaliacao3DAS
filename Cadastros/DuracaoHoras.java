package Cadastros;

public class DuracaoHoras {
	
	private Viagem viagem;
	private int duracaoHoras; 

	public DuracaoHoras(Viagem viagem) {
		super();
		this.viagem = viagem;
	}
	
	
	public int getDuracaoHoras() {
		
		if (viagem.getHoraTermino() == viagem.getHoraInicio())
			this.duracaoHoras = 0;
		if (viagem.getHoraTermino() > viagem.getHoraInicio()) //varias possibilidades... 
			if (viagem.getHoraTermino() == viagem.getHoraInicio() + 1) {  
				if (viagem.getMinutosTermino() < viagem.getHoraInicio())  //nao chegou a uma hora
					this.duracaoHoras = 0;
				else //durou pelo menos uma hora
					this.duracaoHoras = 1;
			} else { //possivelmente ultrapassou duas horas
				if (viagem.getHoraTermino() -  viagem.getHoraInicio() > 2) //
					this.duracaoHoras = viagem.getHoraTermino()-  viagem.getHoraInicio();
				else if (viagem.getHoraTermino() -  viagem.getHoraInicio() == 2 &&   //certamente menos de duas horas  
						 viagem.getMinutosTermino() < viagem.getMinutoInicio())    //e mais de uma hora
					this.duracaoHoras = 1;
				else //duracao de duas horas, certamente
					this.duracaoHoras = 2;
			}
		
		if (viagem.getHoraTermino() < viagem.getHoraInicio()) 
			this.duracaoHoras = -1; //para casos em que a hora de termino nao foi registrada
		return this.duracaoHoras;
	}

}
