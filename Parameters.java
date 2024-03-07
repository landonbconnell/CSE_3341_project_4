public class Parameters {
    String identifier;
    Parameters parameters;

    void parse() {
        Parser.checkCurrentTokenIs(false, Core.ID);
        identifier = Parser.scanner.getId();
        Parser.scanner.nextToken();

        if (Parser.currentTokenIs(Core.COMMA)) {
            Parser.scanner.nextToken();
            parameters = new Parameters();
            parameters.parse();
        }
    }

    void printer() {
        System.out.print(identifier);
        if (parameters != null) {
            System.out.print(", ");
            parameters.printer();
        }
    }
}
