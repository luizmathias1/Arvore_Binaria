public class Main {
    public static void main(String[] args) {
        ArvoreController controller = new ArvoreController();
        UserInterface ui = new UserInterface();

        boolean keepAsking;
        do {
            keepAsking = ui.app(); // roda o app
        } while (keepAsking);
    }
}
