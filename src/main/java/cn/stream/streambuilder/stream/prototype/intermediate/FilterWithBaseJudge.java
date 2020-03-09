package cn.stream.streambuilder.stream.prototype.intermediate;

import cn.stream.streambuilder.stream.constant.BaseSyntax;
import cn.stream.streambuilder.stream.prototype.intermediate.base.filterOp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FilterWithBaseJudge extends filterOp {
    private String var1;
    private String var2;
    private String extend2;
    @Override
    public String var() {
        return BaseSyntax.OPPOSITE+this.var1+BaseSyntax.EQUALS+this.var2+BaseSyntax.SUFFIX;
    }

    @Override
    public String extend() {
        return extend2;
    }
}
