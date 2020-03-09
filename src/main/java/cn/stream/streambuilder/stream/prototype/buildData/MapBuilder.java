package cn.stream.streambuilder.stream.prototype.buildData;

import cn.stream.streambuilder.stream.prototype.buildData.base.BuildData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public  class MapBuilder implements BuildData {
    private String var1;
    private String extend2;
    private final String baseArgs ="entrySet().stream().";
    @Override
    public String var() {
        return this.var1;
    }

    @Override
    public StringBuilder build() {
        return new StringBuilder(baseArgs)
                .append(var1)
                .append(extend2);
    }

    @Override
    public String extend() {
        return this.extend2;
    }
}
