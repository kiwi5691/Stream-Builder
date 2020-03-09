package cn.stream.streambuilder.stream.prototype.endOperation.base;

public abstract class CollectionTo implements EndOperations {

    @Override
    public abstract String var();
    @Override
    public abstract String extend();

    @Override
    public StringBuilder toEnd() {
        return new StringBuilder("collect(")
                .append(this.var())
                .append(this.extend())
                .append(");");
    }
}
