package cn.stream.streambuilder.stream.prototype.intermediate.base;


import static cn.stream.streambuilder.stream.constant.BaseOperator.MAPSUFFIX;
import static cn.stream.streambuilder.stream.constant.BaseSyntax.MIDSUFFIX;


public abstract class mapOp implements Intermediate {
    @Override
    public abstract String var();
    @Override
    public abstract String extend();

    //map().
    @Override
    public StringBuilder IntermediateOp() {
        return new StringBuilder(MAPSUFFIX)
                .append(this.var())
                .append(this.extend())
                .append(MIDSUFFIX);
    }
}
