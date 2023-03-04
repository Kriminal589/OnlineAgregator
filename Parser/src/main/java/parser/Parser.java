package parser;

import parser.citilink.ParserVideoCard;

import java.io.IOException;
import java.sql.SQLException;

public class Parser {
    public static void main(String[] args) throws SQLException {
        ParserVideoCard parserCitilink = new ParserVideoCard();
        parserCitilink.parser();
    }
}
