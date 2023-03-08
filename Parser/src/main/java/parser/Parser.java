package parser;

import parser.citilink.ParserCitilink;

import java.sql.SQLException;

public class Parser {
    public static void main(String[] args) throws SQLException {
        ParserCitilink parserCitilink = new ParserCitilink();

        parserCitilink.parsAll();
    }
}
