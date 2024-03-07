public class Function {

    String procedureName;
    StmtSeq stmt_seq;
    Parameters parameters;

    /**
     * Parses the <procedure> non-terminal in the Core context-free-grammar, which is defined as:
     *      <procedure> ::= procedure ID is <decl-seq> begin <stmt-seq> end | procedure ID is begin <stmt-seq> end
     */
    void parse() {

        Parser.checkCurrentTokenIs(true, Core.PROCEDURE);
        Parser.checkCurrentTokenIs(false, Core.ID);

        procedureName = Parser.scanner.getId();
        Parser.scanner.nextToken();

        Parser.checkCurrentTokenIs(true, Core.LPAREN);

        parameters = new Parameters();
        parameters.parse();

        Parser.checkCurrentTokenIs(true, Core.RPAREN);

        Parser.checkCurrentTokenIs(true, Core.IS);

        stmt_seq = new StmtSeq();
        stmt_seq.parse();

        Parser.checkCurrentTokenIs(false, Core.END);
    }

    void printer() {
        System.out.print("procedure " + procedureName + " (");
        parameters.printer();
        System.out.println(") is");
        stmt_seq.printer();
        System.out.println("end");
    }
}
