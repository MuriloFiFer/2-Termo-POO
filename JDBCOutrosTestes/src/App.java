public class App {
    public static void main(String[] args) throws Exception {
        ConnectionDAI obj = new ConnectionDAO();
        obj.cleanup();
        obj.doexample();
    }
}
