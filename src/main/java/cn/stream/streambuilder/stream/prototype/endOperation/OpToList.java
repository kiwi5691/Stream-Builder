package cn.stream.streambuilder.stream.prototype.endOperation;

import cn.stream.streambuilder.stream.prototype.endOperation.base.CollectionTo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OpToList extends CollectionTo {
    private String var1;
    private String extend2;
    private final String baseArgs ="Collectors.toList()";

    @Override
    public String var() {
        return this.var1+this.baseArgs;
    }

    @Override
    public String extend() {
        return extend2;
    }
}
