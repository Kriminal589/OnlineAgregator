package parser.citilink;

import org.jetbrains.annotations.NotNull;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class Insert {

    public void addVideocard(@NotNull List<String> info, Double cost, @NotNull Connection connection, @NotNull String url) {
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
            throw new RuntimeException(e);
        }
    }

    public void addMotherboard(@NotNull List<String> info, @NotNull Double cost, @NotNull Connection connection, @NotNull String url, @NotNull String name) {
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
            throw new RuntimeException(e);
        }
    }

    public void addPowerSupply(@NotNull String name, @NotNull Connection connection, @NotNull String url, @NotNull Double cost, @NotNull String power) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO  power_supply " +
                    "(name, cost, url, power) VALUES (?, ?, ?, ?)");

            statement.setString(1, name);
            statement.setDouble(2, cost);
            statement.setString(3, url);
            statement.setString(4, power);

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void addProcessor(@NotNull String name, @NotNull Connection connection, @NotNull String url, @NotNull Double cost, @NotNull List<String> info) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO  processor " +
                    "(name, cost, url, core, socket) VALUES (?, ?, ?, ?, ?)");

            statement.setString(1, name);
            statement.setDouble(2, cost);
            statement.setString(3, url);
            statement.setString(4, info.get(0));
            statement.setString(5, info.get(1));

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void addRAM(@NotNull List<String> info, @NotNull Connection connection, @NotNull String url, @NotNull Double cost) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO  ram " +
                    "(name, cost, url, frequency, type, memory) VALUES (?, ?, ?, ?, ?, ?)");

            statement.setString(1, info.get(0));
            statement.setDouble(2, cost);
            statement.setString(3, url);
            statement.setString(4, info.get(3));
            statement.setString(5, info.get(1));
            statement.setString(6, info.get(2));

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void addROM(@NotNull String name, @NotNull String memory, @NotNull Connection connection, @NotNull String url, @NotNull Double cost, @NotNull String type) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO  rom " +
                    "(name, cost, url, type, memory) VALUES (?, ?, ?, ?, ?)");

            statement.setString(1, name);
            statement.setDouble(2, cost);
            statement.setString(3, url);
            statement.setString(4, type);
            statement.setString(5, memory);

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
