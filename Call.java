public class Call {
    String identifier;
    Parameters parameters;

    void parse() {
        Parser.scanner.nextToken();
        Parser.checkCurrentTokenIs(false, Core.ID);

        identifier = Parser.scanner.getId();

        Parser.scanner.nextToken();
        Parser.checkCurrentTokenIs(true, Core.LPAREN);

        parameters = new Parameters();
        parameters.parse();

        Parser.checkCurrentTokenIs(true, Core.RPAREN);
        Parser.checkCurrentTokenIs(false, Core.SEMICOLON);
    }
}
