package com.meituan.sixLec;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Random;

/**
 * Created by 13054 on 2018-7-28.
 */
public class TestClientHandler extends SimpleChannelInboundHandler<AllDataInfo.MyMessage> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, AllDataInfo.MyMessage msg) throws Exception {

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        int randomInt = new Random().nextInt(3);

        AllDataInfo.MyMessage myMessage = null;
        if(0 == randomInt){
            myMessage = AllDataInfo.MyMessage.newBuilder().
                    setDataType(AllDataInfo.MyMessage.DataType.PersonType).
                    setPerson(AllDataInfo.Person.newBuilder().setName("张三").setAge(20).setAddress("北京").build())
                    .build();
        }else if(1 == randomInt){
            myMessage = AllDataInfo.MyMessage.newBuilder().
                    setDataType(AllDataInfo.MyMessage.DataType.DogType).
                    setDog(AllDataInfo.Dog.newBuilder().setName("阿黄").setAge(2).build())
                    .build();
        }else{
            myMessage = AllDataInfo.MyMessage.newBuilder().
                    setDataType(AllDataInfo.MyMessage.DataType.CatType).
                    setCat(AllDataInfo.Cat.newBuilder().setName("阿花").setCity("上海").build())
                    .build();
        }
        ctx.channel().writeAndFlush(myMessage);
    }
}
