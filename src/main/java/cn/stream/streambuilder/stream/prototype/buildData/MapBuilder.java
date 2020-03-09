package cn.stream.streambuilder.stream.prototype.buildData;

import cn.stream.streambuilder.stream.constant.BaseStarter;
import cn.stream.streambuilder.stream.prototype.buildData.base.BuildData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static cn.stream.streambuilder.stream.constant.BaseStarter.ENTRYSETSTREAM;


@Data
@NoArgsConstructor
@AllArgsConstructor
public  class MapBuilder implements BuildData {
    private String var1;
    private String extend2;
    @Override
    public String var() {
        return this.var1;
    }

    //entrySet().stream().
    @Override
    public StringBuilder build() {
        return new StringBuilder(ENTRYSETSTREAM)
                .append(var1)
                .append(extend2);
    }

    @Override
    public String extend() {
        return this.extend2;
    }
}
