package cn.stream.streambuilder.stream.prototype.intermediate.base;

public abstract class filterOp implements Intermediate {
    @Override
    public abstract String var();
    @Override
    public abstract String extend();

    @Override
    public StringBuilder IntermediateOp() {
        return new StringBuilder("filter(").append(this.var())
                .append(this.extend())
                .append(").");
    }
}
