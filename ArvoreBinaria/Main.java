public class Main {
    public static void main(String[] args) {
        ArvoreController controller = new ArvoreController();
        ArvoreBinaria tree = new ArvoreBinaria();
        Node no =  new Node();


        controller.Insert(14);
        controller.Insert(15);
        controller.Insert(4);
        controller.Insert(9);
        controller.Insert(7);
        controller.Insert(18);
        controller.Insert(3);
        controller.Insert(5);
        controller.Insert(16);
        controller.Insert(20);
        controller.Insert(17);
        controller.Insert(9);
        controller.Insert(5);

        //controller.PreOrdem();
        controller.InOrdem();
        //controller.PosOrdem();

        controller.RemoveValue(18);
        controller.RemoveValue(20);
        controller.RemoveValue(14);

        System.out.println("\n Print após a remoção");
        controller.InOrdem();
    }
}
