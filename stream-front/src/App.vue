<template>
  <div>


 <Badge style="float:left;margin:10px;" :count="0">
        <Button icon="ios-bowtie" @click="value1  = true" shape="circle" type="success">对象</Button>
    </Badge>
    <Modal
            v-model="modal5"
            title="请阅读右侧注意事项"
             @on-ok="okCreate"
             @on-cancel="cancelCreate"

            width="800">
             <Input type="textarea" v-model="baseClass" :rows="10" placeholder="please enter the description" />
       </Modal>
       <Modal
                   v-model="modal4"
                   title="具体事项"
                   width="400">
                   <p>导入一个类,格式如下</p>
                   <p >public class Person {</p>
                   <p style="padding-left:2em">  private String name;</p>
                   <p style="padding-left:2em">  private String gender;</p>
                   <p style="padding-left:2em">  ..省略get/set等方法 </p>
                   <p> }</p>

          </Modal>
     <Drawer :closable="false" width="640" v-model="value1">
                 <p :style="pStyle">这里存储着你创建的对象</p>
                 <Button type="success"  @click="modal5 = true" icon="md-add" style="float:left;" >创建</Button>
                 <Button type="error" @click="modal4 = true" icon="ios-alert-outline">注意</Button>
                 <Divider />
                 <p :style="pStyle">Contacts</p>
                  <div class="demo-drawer-profile">
                                      <Row>
                                          <Col span="12">
                                              打开json格式
                                          </Col>
                                          <Col span="12">
                                              打开class格式
                                          </Col>
                                      </Row>
                                      <Row>
                                          <Col span="12">
                                              打开xml格式
                                          </Col>
                                      </Row>
                                  </div>
                 <Divider />
                 <p :style="pStyle">Contacts</p>
                 <div class="demo-drawer-profile">
                     <Row>
                         <Col span="12">
                             打开json格式
                         </Col>
                         <Col span="12">
                             打开class格式
                         </Col>
                     </Row>
                     <Row>
                         <Col span="12">
                             打开xml格式
                         </Col>
                     </Row>
                 </div>
             </Drawer>


<div id="nav">
     <p style="padding:20px;text-align:center;">当前正在进行第 {{ current + 1 }} 步</p>
       <Steps :current="current" style="text-align:center;">
           <Step title="创建"></Step>
           <Step title="中间操作"></Step>
           <Step title="结束操作"></Step>
       </Steps>
       <div style="padding:20px;text-align:center;" >
       <Button type="primary" @click="next">Next step</Button>
       </div>
    </div>

<!--这里是create开始-->

<div id="create">

  <div style="float:left;">
  <div style="padding-left:10px;width:110px;">
    <Alert>
          集合类型
          <template slot="desc">第一步 </template>
      </Alert>
      </div>
 <RadioGroup  v-model="vertical" style="padding-left:20px;" vertical>
        <Radio label="List"></Radio>
        <Radio label="Map"></Radio>
        <Radio label="Array"></Radio>
    </RadioGroup>
  </div>
</div>

<div style="float:left;">
  <div style="padding-left:20px;width:170px;">
    <Alert show-icon>
          数据类型
           <Icon type="ios-bulb-outline" slot="icon"></Icon>
          <template slot="desc">第二步 </template>
      </Alert>
          <i-switch v-model="isObject" @on-change="change" />
          <Button type="info" @click="value1  = true" >处理对象</Button>
      </div>

 <RadioGroup v-show="!isObject" v-model="datatype" style="padding:10px; padding-left:50px;" vertical>
        <Radio label="String"></Radio>
        <Radio label="Integer"></Radio>
        <Radio label="Double"></Radio>
        <Radio label="Long"></Radio>
    </RadioGroup>

    <Select  v-show="isObject" v-model="objects" style="padding:10px; padding-left:20px; ">
            <Option v-for="item in cityList" :value="item.value" :key="item.value">{{ item.label }}</Option>
        </Select>
  </div>

</div>


    </div>
<!--这里是create结束-->







</template>

<script>
	import {construct} from "./api/classConstruct";

export default {
  name: 'App',
  data () {
              return {
                  theme1: 'light',
                  current: 0,
                   vertical: 'List',
                   datatype: 'String',
                   isObject:false,
                   objects:'',
                   value1: false,
                    pStyle: {
                                       fontSize: '16px',
                                       lineHeight: '24px',
                                       display: 'block',
                                       marginBottom: '16px'
                                   },

                    modal5: false,
                    modal4: false,
                    baseClass: '',



              }
          },
   methods: {
          next () {
                 if (this.current == 2) {
                               this.current = 0;
                     } else {
                               this.current += 1;
                           }
                   },

          change (status) {
                        if(status){
                            this.$Message.info('目前处理对象');
                        }else{
                          this.$Message.info('目前处理数据类型');
                        }
                      },

	      async  okCreate() {
         	    const result = construct(this.baseClass);
              this.$Message.info('创建成功');
              this.$Message.info(result);
         	},
               cancelCreate () {
                          this.$Message.info('取消创建');
                    }
          }


}
</script>

<style>
#create{



}
.column {

 margin:10px;
 float:left;
padding-left:20px;
}

.row {
display:inline

}
# nav{
top:0;
}
# bar{
width: 200px;

position: absolute;

left: 50%;

margin-left: -100px;

background-color: aqua;
}
#app {
  text-align: center;
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: #2c3e50;
  margin-top: 60px;
}
 .demo-drawer-profile{
        font-size: 14px;
    }
    .demo-drawer-profile .ivu-col{
        margin-bottom: 12px;
    }
</style>
