package cn.stream.streambuilder.stream.prototype.endOperation.base;

import static cn.stream.streambuilder.stream.constant.BaseEnd.COUNTSUFFIX;
import static cn.stream.streambuilder.stream.constant.BaseSyntax.ENDSUFFIX;

public abstract class CountTo implements EndOperations {
    @Override
    public abstract String var();
    @Override
    public abstract String extend();


    //count();
    @Override
    public StringBuilder toEnd() {
        return new StringBuilder(COUNTSUFFIX).append(this.var())
                .append(this.extend())
                .append(ENDSUFFIX);
    }
}
