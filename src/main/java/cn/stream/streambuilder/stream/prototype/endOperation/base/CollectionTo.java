package cn.stream.streambuilder.stream.prototype.endOperation.base;

import static cn.stream.streambuilder.stream.constant.BaseEnd.COLLECTSUFFIX;
import static cn.stream.streambuilder.stream.constant.BaseSyntax.ENDSUFFIX;

public abstract class CollectionTo implements EndOperations {

    @Override
    public abstract String var();
    @Override
    public abstract String extend();

    //collect();
    @Override
    public StringBuilder toEnd() {
        return new StringBuilder(COLLECTSUFFIX)
                .append(this.var())
                .append(this.extend())
                .append(ENDSUFFIX);
    }
}
