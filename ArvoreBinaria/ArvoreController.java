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
        // Se o nó atual for null, insere o novo nó
        if (atual == null) {
            Node no = new Node();
            no.setInfo(N);  // Define o valor do novo nó
            return no;      // Retorna o novo nó, ele será o filho (esquerda ou direita) do nó pai
        }

        // Se o número N é maior ou igual ao valor do nó atual, vai para a subárvore direita
        if (N >= atual.getInfo()) {
            // Atualiza o nó direito do nó atual (chamada recursiva para inserir na subárvore direita)
            atual.setDireita(InsertTree(atual.getDireita(), N));
        }
        // Se o número N é menor, vai para a subárvore esquerda
        else {
            // Atualiza o nó esquerdo do nó atual (chamada recursiva para inserir na subárvore esquerda)
            atual.setEsquerda(InsertTree(atual.getEsquerda(), N));
        }

        // Retorna o nó atual com suas subárvores possivelmente modificadas
        return atual;
    }

    public void PreOrdem() {
        percorrerPreOrdem(tree.getRaiz());
    }

    private void percorrerPreOrdem(Node no) {
        if (no != null) {
            // Visite o nó atual
            System.out.print(no.getInfo() + " ");

            // Percorra a subárvore esquerda
            percorrerPreOrdem(no.getEsquerda());

            // Percorra a subárvore direita
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
            no.setInfo(sucessor.getInfo()); // Substituir o valor do nó pelo valor do sucessor
            no.setDireita(remover(no.getDireita(), sucessor.getInfo())); // Remover o sucessor
        }

        return no;
    }
}
