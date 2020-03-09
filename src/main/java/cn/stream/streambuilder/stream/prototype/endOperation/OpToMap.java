package cn.stream.streambuilder.stream.prototype.endOperation;

import cn.stream.streambuilder.stream.prototype.endOperation.base.CollectionTo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static cn.stream.streambuilder.stream.constant.BaseEnd.COLLECTORSTOMAP;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OpToMap extends CollectionTo {
    private String var1;
    private String extend2;
    private final String baseArgs ="Collectors.toList()";

    //Collectors.toMap();
    @Override
    public String var() {
        return this.var1+COLLECTORSTOMAP;
    }

    @Override
    public String extend() {
        return extend2;
    }
}
