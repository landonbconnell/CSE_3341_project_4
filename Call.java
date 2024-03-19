import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    void printer() {
        System.out.print("begin " + identifier + " (");
        parameters.printer();
        System.out.println(");");
    }

    void execute() {
        Function function = Executor.functions.get(identifier);

        List<String> informals = parameters.execute();
        List<String> formals = function.parameters.execute();

        Deque<Map<String, Variable>> frame = new ArrayDeque<>();
        frame.add(new HashMap<>());

        for (int i = 0; i < informals.size(); i++) {
            frame.getFirst().put(formals.get(i), Executor.getVariable(informals.get(i)));
        }

        Executor.pushFrame(frame);
        Executor.pushScope(Scope.LOCAL);

        function.execute();

        Executor.popFrame();
    }
}
