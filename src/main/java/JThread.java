import app.App;
import parser.Parser;

import java.sql.SQLException;

public class JThread extends Thread{
    private final String[] args;

    public JThread(String[] args) {
        this.args = args;
    }

    public void run() {
        try {
            Parser.main(args);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
