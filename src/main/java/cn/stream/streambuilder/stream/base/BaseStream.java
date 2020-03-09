package cn.stream.streambuilder.stream.base;

import cn.stream.streambuilder.stream.prototype.buildData.base.BuildData;
import cn.stream.streambuilder.stream.prototype.endOperation.base.EndOperations;
import cn.stream.streambuilder.stream.prototype.intermediate.base.Intermediate;

public class BaseStream {
    private BuildData buildDate;
    private Intermediate intermediate;
    private EndOperations endOperations;

    public BaseStream(BuildData buildDate,Intermediate intermediate,EndOperations endOperations){
        this.buildDate= buildDate;
        this.intermediate= intermediate;
        this.endOperations= endOperations;
    }

    public String construct(){
       return buildDate.build().append(intermediate.IntermediateOp()).append(endOperations.toEnd()).toString();
    }
}
