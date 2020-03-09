package cn.stream.streambuilder.stream.prototype.endOperation.base;

public abstract class CountTo implements EndOperations {
    @Override
    public abstract String var();
    @Override
    public abstract String extend();


    @Override
    public StringBuilder toEnd() {
        return new StringBuilder("count(").append(this.var())
                .append(this.extend())
                .append(");");
    }
}
