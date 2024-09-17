public class ArvoreController {

    private final ArvoreBinaria tree;
    private  Node no;

    public ArvoreController() {
        this.tree = new ArvoreBinaria();
    }

    public void Insert(int dado) {
        tree.setRaiz(InsertTree(tree.getRaiz(), dado));
    }

    private Node InsertTree(Node atual, int dado) {

        if (atual == null) { // cria a raiz se estiver nula
            Node no = new Node();
            no.setInfo(dado);
            return no;
        }

        if (dado >= atual.getInfo()) { // adiciona o valor

            atual.setDireita(InsertTree(atual.getDireita(), dado)); //direita
        }
        else {
            atual.setEsquerda(InsertTree(atual.getEsquerda(), dado)); //esquerda
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

    public void RemoveValue(int dado) {
        this.tree.setRaiz(remover(this.tree.getRaiz(), dado));
    }


    private Node remover(Node no, int dado) {
        if (no == null) {
            return null;
        }

        if (dado < no.getInfo()) {
            no.setEsquerda(remover(no.getEsquerda(), dado)); // Remover na subárvore esquerda
        } else if (dado > no.getInfo()) {
            no.setDireita(remover(no.getDireita(), dado)); // Remover na subárvore direita
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
