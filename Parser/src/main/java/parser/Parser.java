package parser;

import parser.citilink.ParserCitilink;

import java.io.IOException;

public class Parser {
    public static void main(String[] args) throws IOException {
        ParserCitilink parserCitilink = new ParserCitilink();
        parserCitilink.parser();
    }
}
