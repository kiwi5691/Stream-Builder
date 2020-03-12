package cn.stream.streambuilder.web;

import cn.stream.streambuilder.construction.file.ObjectFile;
import cn.stream.streambuilder.stream.base.BaseStream;
import cn.stream.streambuilder.stream.prototype.buildData.ListBuilder;
import cn.stream.streambuilder.stream.prototype.buildData.base.BuildData;
import cn.stream.streambuilder.stream.prototype.endOperation.OpToList;
import cn.stream.streambuilder.stream.prototype.endOperation.base.EndOperations;
import cn.stream.streambuilder.stream.prototype.intermediate.FilterWithBaseJudge;
import cn.stream.streambuilder.stream.prototype.intermediate.base.Intermediate;
import cn.stream.streambuilder.web.base.JacksonUtil;
import cn.stream.streambuilder.web.base.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
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
    public Object constructClass(@RequestBody String body) throws Exception {


        List content = ObjectFile.classCharSetTsList(JacksonUtil.parseString(body, "classContent"));
        ObjectFile.readWrite(content,JacksonUtil.parseString(body, "serial"));
        return Response.ok();
    }
}
