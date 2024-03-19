Landon Connell

Assign.java - Has code for parsing, printing, and executing the <assign> non-terminal.
Call.java - Has code for parsing, printing, and executing the <call> non-terminal.
Cmpr.java - Has code for parsing, printing, and executing the <cmpr> non-terminal.
Cond.java - Has code for parsing, printing, and executing the <cond> non-terminal.
Core.java - A file containing enums that serve as tokens.
Decl.java - Has code for parsing, printing, and executing the <decl> non-terminal.
DeclInteger.java - Has code for parsing, printing, and executing the <decl-integer> non-terminal.
DeclObj.java - Has code for parsing, printing, and executing the <decl-obj> non-terminal.
DeclSeq.java - Has code for parsing, printing, and executing the <decl-seq> non-terminal.
Executor.java - Inititates the execution of the program, and contains various methods for using and managing the scope/frame stacks.
Expr.java - Has code for parsing, printing, and executing the <expr> non-terminal.
Factor.java - Has code for parsing, printing, and executing the <factor> non-terminal.
Function.java - Has code for parsing, printing, and executing the <function> non-terminal.
If.java - Has code for parsing, printing, and executing the <if> non-terminal.
Loop.java - Has code for parsing, printing, and executing the <loop> non-terminal.
Main.java - A program that drives a compiler process which involves scanning an input file, generating a parse tree, and
    executing the code.
Out.java - Has code for parsing, printing, and executing the <out> non-terminal.
Parameters.java - Has code for parsing, printing, and executing the <parameters> nonterminal.
Parser.java - This class initiates the parsing process by invoking the 'parse()' method on a 'Procedure' object and
    provides helper methods to validate token correctness during the parsing of the Core programming language.
Procedure.java - Has code for parsing, printing, and executing the <procedure> non-terminal.
Scanner.java - A class defining a "Scanner" object, which takes source code as input, and outputs a stream of tokens.
Scope.java - A file containing enums for the different types of scopes (global, local, if, and loop)
Stmt.java - Has code for parsing, printing, and executing the <stmt> non-terminal.
StmtSeq.java - Has code for parsing, printing, and executing the <stmt-seq> non-terminal.
Term.java - Has code for parsing, printing, and executing the <term> non-terminal.
Type.java - A file containing enums symbolizing valid Core language variable types (integer and object).
Variable.java - A class defining a "Variable" object which contains 'type' and 'int/object_value' members.

Special Features:

Interpreter Design:

To add function-calling capabilities to my interpreter, I introduced additional classes to represent the new non-terminals in
the grammar. Additionally, I modified the DeclSeq class to parse function definitions and add them to the 'functions' Map in the
Executor class. Finally, I modified the scope management system by transitioning from a single stack of scopes to a stack of
stacks of scopes. This new data structure functions as a frame/call stack and supports our ability to temporarily halt execution
at a specific point within the parse tree. We can then transition to a different segment of the tree to execute code, and upon
completion, return to the original point of execution.

Thus, to implement function calling, my approach involved this simple process:
1. Map the values of the arguments from the informal parameters list to the corresponding variable names in the formal parameter list (Map<String, Variable>).
2. Add this mapping to a new frame (Deque<Map<String, Variable>>).
3. Push the frame to the stack of frames (Deque<Deque<Map<String, Variable>>>).
4. Execute the function.
5. Pop the frame from the stack of frames.

Interpreter Testing and Bugs:


