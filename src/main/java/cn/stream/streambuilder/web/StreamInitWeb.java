package cn.stream.streambuilder.web;

import cn.stream.streambuilder.construction.flow.ObjectCompiler;
import cn.stream.streambuilder.construction.flow.ObjectFile;
import cn.stream.streambuilder.exception.ClassCharSetIllegalException;
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

import java.util.List;

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

        String serial=JacksonUtil.parseString(body, "serial");
        String content = JacksonUtil.parseString(body, "classContent");
        String className =ObjectFile.getClassName(content);
//        if(className!=null){

            //开始编译
//            ObjectCompiler.CompilerJava(className,serial);
//        }else {
//            throw new ClassCharSetIllegalException();
//
//        }
        return Response.ok();
    }
}
