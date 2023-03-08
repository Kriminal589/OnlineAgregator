package parser.citilink;

import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebDriver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class Insert {

    public void addVideocard(@NotNull List<String> info, Double cost, @NotNull Connection connection, @NotNull String url, @NotNull WebDriver driver) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO videocard " +
                    "(name, cost, url, memory, frequency) VALUES (?, ?, ?, ?, ?)");

            statement.setString(1, info.get(0));
            statement.setDouble(2, cost);
            statement.setString(3, url);
            statement.setString(4, info.get(2));
            statement.setString(5, info.get(1));

            statement.executeUpdate();
        } catch (SQLException e) {
            driver.quit();
            throw new RuntimeException(e);
        }
    }

    public void addMotherboard(@NotNull List<String> info, Double cost, @NotNull Connection connection, @NotNull String url, @NotNull WebDriver driver, @NotNull String name) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO motherboard " +
                    "(name, cost, url, socket, size_form) VALUES (?, ?, ?, ?, ?)");

            statement.setString(1, name);
            statement.setDouble(2, cost);
            statement.setString(3, url);
            statement.setString(4, info.get(1));
            statement.setString(5, info.get(0));

            statement.executeUpdate();
        } catch (SQLException e) {
            driver.quit();
            throw new RuntimeException(e);
        }
    }
}
