import springApplication.Application;

public final class Main {
    public static void main(String[] args) {
        Connection.initDB();
        Application.main(args);
    }
}
