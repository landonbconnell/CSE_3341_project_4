public class Parameters {
    String identifier;
    Parameters parameters;

    void parse() {
        Parser.checkCurrentTokenIs(false, Core.ID);
        identifier = Parser.scanner.getId();
        Parser.scanner.nextToken();

        if (Parser.currentTokenIs(Core.COMMA)) {
            parameters = new Parameters();
            parameters.parse();
        }
    }
}
