public class Variable {
    Type type;
    int int_value;
    int[] obj_value;
    Function function_value;

    public Variable(Type type) {
        this.type = type;
        this.int_value = 0;
        this.obj_value = null;
        this.function_value = null;
    }
}
