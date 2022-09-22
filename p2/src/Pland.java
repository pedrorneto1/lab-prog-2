import classes.Disciplina;
import classes.GrupoEstudo;
import classes.Rendimento;

public class Pland {
 
    public static void main(String[] args) {
        Disciplina p2 = new Disciplina("Programação 2");
        p2.adicionaExercicios(2);
        p2.adicionaExercicios(3);
        System.out.println(p2.totalExercicios());
        p2.adicionaExercicios(5);
        System.out.println(p2.toString());
        System.out.println("====");
 
        Disciplina calculo = new Disciplina("Calculo");
        System.out.println(calculo.totalExercicios());
        System.out.println(calculo.toString());
        System.out.println("====");
 
        int numColegas = 4;
        GrupoEstudo estudoP2 = new GrupoEstudo("Programação 2", numColegas);
        estudoP2.cadastraColega(0, "Maria");
        estudoP2.cadastraColega(1, "Pedro");
        estudoP2.cadastraColega(2, "Mateus");
        System.out.println(estudoP2.totalCadastrados());
        System.out.println(estudoP2.getColega(0));
        System.out.println(estudoP2.getColega(3));
        System.out.println(estudoP2.isColega("Jose"));
        System.out.println(estudoP2.toString());
        System.out.println("====");
 
        int[] pesosAtividade = new int[]{1, 2, 2, 2};
        Rendimento rendimentoP2 = new Rendimento("Programação 2", pesosAtividade);
        rendimentoP2.cadastraAtividade(0, 10.0);
        rendimentoP2.cadastraAtividade(1, 8.0);
        rendimentoP2.cadastraAtividade(2, 7.5);
        System.out.println(rendimentoP2.media());
        System.out.println(rendimentoP2.aprovado());
        rendimentoP2.cadastraAtividade(3, 7.5);
        System.out.println(rendimentoP2.aprovado());
        System.out.println(rendimentoP2.toString());
        System.out.println("====");
    }   
}