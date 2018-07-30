package com.meituan.sixLec;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * Created by 13054 on 2018-7-28.
 */
public class TestServerHandler extends SimpleChannelInboundHandler<AllDataInfo.MyMessage> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, AllDataInfo.MyMessage msg) throws Exception {
        AllDataInfo.MyMessage.DataType dataType = msg.getDataType();

        if(dataType == AllDataInfo.MyMessage.DataType.PersonType){
            AllDataInfo.Person person = msg.getPerson();
            System.out.println(person.getName());
            System.out.println(person.getAge());
            System.out.println(person.getAddress());
        }else if(dataType == AllDataInfo.MyMessage.DataType.DogType){
            AllDataInfo.Dog dog = msg.getDog();
            System.out.println(dog.getName());
            System.out.println(dog.getAge());
        }else {
            AllDataInfo.Cat cat = msg.getCat();
            System.out.println(cat.getName());
            System.out.println(cat.getCity());
        }

    }
}
