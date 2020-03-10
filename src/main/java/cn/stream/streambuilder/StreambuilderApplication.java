package cn.stream.streambuilder;

import cn.stream.streambuilder.stream.base.BaseStream;
import cn.stream.streambuilder.stream.prototype.buildData.ListBuilder;
import cn.stream.streambuilder.stream.prototype.buildData.base.BuildData;
import cn.stream.streambuilder.stream.prototype.endOperation.OpToList;
import cn.stream.streambuilder.stream.prototype.endOperation.base.EndOperations;
import cn.stream.streambuilder.stream.prototype.intermediate.FilterWithBaseJudge;
import cn.stream.streambuilder.stream.prototype.intermediate.base.Intermediate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class StreambuilderApplication {

//    Map<String,String> stringStringMap = new HashMap<>();

    public static void main(String[] args) {
//         BuildData buildDate = new ListBuilder("","");
//         Intermediate intermediate = new FilterWithBaseJudge("a","b","");
//         EndOperations endOperations =new OpToList("","");
//
//        BaseStream baseStream = new BaseStream(buildDate,intermediate,endOperations);
//        System.out.println(baseStream.construct());
        SpringApplication.run(StreambuilderApplication.class, args);

    }

}
