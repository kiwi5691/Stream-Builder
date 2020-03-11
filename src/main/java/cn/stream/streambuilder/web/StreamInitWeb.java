package cn.stream.streambuilder.web;

import cn.stream.streambuilder.stream.base.BaseStream;
import cn.stream.streambuilder.stream.prototype.buildData.ListBuilder;
import cn.stream.streambuilder.stream.prototype.buildData.base.BuildData;
import cn.stream.streambuilder.stream.prototype.endOperation.OpToList;
import cn.stream.streambuilder.stream.prototype.endOperation.base.EndOperations;
import cn.stream.streambuilder.stream.prototype.intermediate.FilterWithBaseJudge;
import cn.stream.streambuilder.stream.prototype.intermediate.base.Intermediate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/")
public class StreamInitWeb {
//后期改为vertx

    @PostMapping("dataToInit")
    public String dataToInit(){
        BuildData buildDate = new ListBuilder("","");
        Intermediate intermediate = new FilterWithBaseJudge("a","b","");
        EndOperations endOperations =new OpToList("","");
        BaseStream baseStream = new BaseStream(buildDate,intermediate,endOperations);

        return baseStream.construct();
    }

    @PostMapping("constructClass")
    public String constructClass(@RequestBody String body){


        return "body";
    }
}
