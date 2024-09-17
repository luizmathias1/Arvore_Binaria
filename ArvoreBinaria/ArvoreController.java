public class ArvoreController {

    private final ArvoreBinaria tree;
    private  Node no;

    public ArvoreController() {
        this.tree = new ArvoreBinaria();
    }

    public void Insert(int N) {
        // Chama o método recursivo para inserir o valor na árvore
        this.tree.setRaiz(InsertTree(this.tree.getRaiz(), N));
    }

    private Node InsertTree(Node atual, int N) {

        if (atual == null) { // cria a raiz se estiver nula
            Node no = new Node();
            no.setInfo(N);
            return no;
        }


        if (N >= atual.getInfo()) { // adiciona o valor

            atual.setDireita(InsertTree(atual.getDireita(), N));
        }
        else {
            atual.setEsquerda(InsertTree(atual.getEsquerda(), N));
        }

        return atual;
    }

    public void PreOrdem() {
        percorrerPreOrdem(tree.getRaiz());
    }

    private void percorrerPreOrdem(Node no) {
        if (no != null) {

            System.out.print(no.getInfo() + " ");

            percorrerPreOrdem(no.getEsquerda());

            percorrerPreOrdem(no.getDireita());
        }
    }

    public void InOrdem(){
        percorrerInOrdem(tree.getRaiz());
    }

    private void percorrerInOrdem(Node no){
        if (no != null){

            percorrerInOrdem(no.getEsquerda());

            System.out.print(no.getInfo() + " ");

            percorrerInOrdem(no.getDireita());


        }
    }

    public void PosOrdem(){
        percorrerPosOrdem(tree.getRaiz());
    }

    private void percorrerPosOrdem(Node no){
        if (no != null){

            percorrerPosOrdem(no.getEsquerda());

            percorrerPosOrdem(no.getDireita());

            System.out.print(no.getInfo() + " ");
        }
    }

    public void RemoveValue(int N) {
        this.tree.setRaiz(remover(this.tree.getRaiz(), N));
    }


    private Node remover(Node no, int N) {
        if (no == null) {
            return null;
        }

        if (N < no.getInfo()) {
            no.setEsquerda(remover(no.getEsquerda(), N)); // Remover na subárvore esquerda
        } else if (N > no.getInfo()) {
            no.setDireita(remover(no.getDireita(), N)); // Remover na subárvore direita
        } else {


            if (no.getEsquerda() == null && no.getDireita() == null) { // Nó null
                return null;
            }


            if (no.getEsquerda() == null) { // Nó com 1 filho
                return no.getDireita();
            }
            if (no.getDireita() == null) {
                return no.getEsquerda();
            }

            Node sucessor = no.getDireita(); // Nó com 2 filhos
            while (sucessor.getEsquerda() != null) { // encontra o nosso sucessor que será o menos valor
                sucessor = sucessor.getEsquerda();
            }
            no.setInfo(sucessor.getInfo()); // valor do nó = valor do sucessor
            no.setDireita(remover(no.getDireita(), sucessor.getInfo())); // remove o sucessor
        }

        return no;
    }
}
