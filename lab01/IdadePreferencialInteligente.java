package lp2.lab01;
public class IdadePreferencialInteligente {
	public static void main(String[] args) { // Definindo uma fun��o
		int nascimento = 1998;
		int hoje = 2021;
		int idade = hoje - nascimento;
		if (idade >= 60) {
			System.out.println("Preferencial Idoso");
		} else {
			System.out.println("Voc� tem " + idade + " anos. Voc� ainda n�o pode usar o atendimento especial.");
		}
	}
}