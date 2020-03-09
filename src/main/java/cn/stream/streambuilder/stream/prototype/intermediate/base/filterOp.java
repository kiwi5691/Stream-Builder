package cn.stream.streambuilder.stream.prototype.intermediate.base;

import cn.stream.streambuilder.stream.constant.BaseOperator;
import cn.stream.streambuilder.stream.constant.BaseSyntax;

import static cn.stream.streambuilder.stream.constant.BaseOperator.FILTERSUFFIX;
import static cn.stream.streambuilder.stream.constant.BaseSyntax.MIDSUFFIX;

public abstract class filterOp implements Intermediate {
    @Override
    public abstract String var();
    @Override
    public abstract String extend();

    //filter().
    @Override
    public StringBuilder IntermediateOp() {
        return new StringBuilder(FILTERSUFFIX).append(this.var())
                .append(this.extend())
                .append(MIDSUFFIX);
    }
}
