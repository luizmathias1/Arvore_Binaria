import java.util.Scanner;

public class UserInterface {

    ArvoreController controller = new ArvoreController();

    public boolean app() {
        showOptions();
        return chooseOption(option(1, 4));
    }


    public boolean chooseOption(int option) {
        switch (option) {
            case 1:
                inserirdado();
                return true;
            case 2:
                mostrardados();
                return true;
            case 3:
                delete();
                return true;
            default:
                return true;
        }
    }

    private void inserirdado(){
        Scanner teclado = new Scanner(System.in);
        int dado;

        try {
            System.out.println("Digite o valor: ");
            dado = teclado.nextInt();
            controller.Insert(dado);
        } catch (Exception e){
            System.out.println("Valor invalido inserido");
        }
    }

    private void mostrardados(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Deseja ver a em qual ordem \n [1] - PreOrdem \n [2] - InOrdem \n [3] - PosOrdem");
        try{
            int opcao = teclado.nextInt();
            switch (opcao){
                case 1:
                    System.out.println("Pré Ordem");
                    controller.PreOrdem();
                    break;
                case 2:
                    System.out.println("Em Ordem");
                    controller.InOrdem();
                    break;
                case 3:
                    System.out.println("Pós Ordem");
                    controller.PosOrdem();
                    break;
                default:
                    System.out.println("Valor Inserido Invalido");
            }
        }catch (Exception e){
            System.out.println("Valor Invalido Inserido");
        }
    }

    private void delete(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Digite o valor a ser removido");
        int dado = teclado.nextInt();
        try{
            controller.RemoveValue(dado);
        }catch (Exception e){
            System.out.println("Valor Invalido");
        }
    }

    public void showOptions() {
        System.out.println("\n[1] Inserir um elemento");
        System.out.println("\n[2] Mostrar Arvore");
        System.out.println("\n[3] Remover um elemento");
    }

    public int option(int min, int max) {
        Scanner teclado = new Scanner(System.in);
        int opcao = -1;

        do {
            try {
                System.out.print("Digite uma opção: ");
                opcao = teclado.nextInt();

            } catch (Exception e) {
                System.out.println("Digite um valor válido.");
                teclado.next(); // Limpa a entrada inválida
            }
        } while (opcao < min || opcao > max);

        return opcao;
    }

}
