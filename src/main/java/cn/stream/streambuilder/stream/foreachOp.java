package cn.stream.streambuilder.stream;

import cn.stream.streambuilder.stream.prototype.intermediate.base.Intermediate;

public abstract class foreachOp  implements Intermediate {
    @Override
    public StringBuilder  IntermediateOp() {
        return new StringBuilder("foreach().");
    }
}
