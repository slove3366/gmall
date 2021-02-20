package com.atguigu.utils

import java.util.Properties

import org.apache.kafka.clients.consumer.ConsumerRecord
import org.apache.spark.streaming.StreamingContext
import org.apache.spark.streaming.kafka010.{ConsumerStrategies, KafkaUtils, LocationStrategies}
import org.apache.spark.streaming.dstream.InputDStream
import org.codehaus.jackson.map.deser.std.StringDeserializer

/**
  * @Description
  * @Author dyhkeep
  * @Create 2021-02-20 14:10
  */
object MyKafkaUtil {
  //1，创建配置信息对象
  private val properties: Properties = PropertiesUtil.load("config.properties")
  //2,用于初始化链接到集群的地址

  private val broker_list: String = properties.getProperty("kafka.broker.list")
  //3,kafka消费者配置

  val KafkaParam=Map(
    "bootstrap.servers"->broker_list,
    "key.deserializer"->classOf[StringDeserializer],
    "value.deserializer"->classOf[StringDeserializer],
    //消费者组
    "group.id"->"bigdata0923",
    //如果没有初始化偏移量或者当前的偏移量不存在任何的服务器上，可以使用这个配置属性
    //可以使用这个配置，latest自动重置偏移量为最新的偏移量
    "auto.offset.reset"->"latest",
    //
    //
    "enable.auto.commit"->(true:java.lang.Boolean)
  )

  //创建DStream,返回接受到的输入数据
  def getKafkaStream(topic:String,ssc:StreamingContext):InputDStream[ConsumerRecord[String,String]]={
    KafkaUtils.
  }


}
