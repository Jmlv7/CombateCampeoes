import java.util.Scanner;

class Campeao {
    private String nome;
    private int vida;
    private int ataque;
    private int armadura;

    public Campeao(String nome, int vida, int ataque, int armadura) {
        this.nome = nome;
        this.vida = vida;
        this.ataque = ataque;
        this.armadura = armadura;
    }

    public void takeDamage(int ataqueOponente) {
        int dano = Math.max(ataqueOponente - this.armadura, 1);
        this.vida = Math.max(this.vida - dano, 0);
    }

    public String status() {
        if (this.vida > 0) {
            return this.nome + ": " + this.vida + " de vida";
        } else {
            return this.nome + ": 0 de vida (morreu)";
        }
    }

    public boolean estaVivo() {
        return this.vida > 0;
    }

    public int getAtaque() {
        return ataque;
    }
}

public class Combate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leitura dos dados do primeiro campeão
        System.out.println("Digite os dados do primeiro campeão:");
        System.out.print("Nome: ");
        String nome1 = scanner.nextLine();
        System.out.print("Vida inicial: ");
        int vida1 = scanner.nextInt();
        System.out.print("Ataque: ");
        int ataque1 = scanner.nextInt();
        System.out.print("Armadura: ");
        int armadura1 = scanner.nextInt();
        scanner.nextLine();  // Limpar o buffer

        // Leitura dos dados do segundo campeão
        System.out.println("\nDigite os dados do segundo campeão:");
        System.out.print("Nome: ");
        String nome2 = scanner.nextLine();
        System.out.print("Vida inicial: ");
        int vida2 = scanner.nextInt();
        System.out.print("Ataque: ");
        int ataque2 = scanner.nextInt();
        System.out.print("Armadura: ");
        int armadura2 = scanner.nextInt();

        // Instanciando os campeões
        Campeao campeao1 = new Campeao(nome1, vida1, ataque1, armadura1);
        Campeao campeao2 = new Campeao(nome2, vida2, ataque2, armadura2);

        // Leitura do número de turnos
        System.out.print("\nQuantos turnos você deseja executar? ");
        int turnos = scanner.nextInt();

        // Executando o combate
        for (int turno = 1; turno <= turnos; turno++) {
            if (!campeao1.estaVivo() || !campeao2.estaVivo()) {
                break;
            }

            // Cada campeão ataca o outro
            campeao1.takeDamage(campeao2.getAtaque());
            campeao2.takeDamage(campeao1.getAtaque());

            // Exibindo o resultado do turno
            System.out.println("\nResultado do turno " + turno + ":");
            System.out.println(campeao1.status());
            System.out.println(campeao2.status());
        }

        System.out.println("\n### FIM DO COMBATE ###");
        scanner.close();
    }
}
