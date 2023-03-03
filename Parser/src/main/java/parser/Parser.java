package parser;

import parser.citilink.ParserVideoCard;

import java.io.IOException;

public class Parser {
    public static void main(String[] args) throws IOException {
        ParserVideoCard parserCitilink = new ParserVideoCard();
        parserCitilink.parser();
    }
}
