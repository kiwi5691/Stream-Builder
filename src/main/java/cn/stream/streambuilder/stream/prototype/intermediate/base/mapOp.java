package cn.stream.streambuilder.stream.prototype.intermediate.base;

public abstract class mapOp implements Intermediate {
    @Override
    public abstract String var();
    @Override
    public abstract String extend();

    @Override
    public StringBuilder IntermediateOp() {
        return new StringBuilder("map(")
                .append(this.var())
                .append(this.extend())
                .append(");");
    }
}
