package com.meituan.nettyThrift;

import com.facebook.nifty.core.NettyServerTransport;
import com.facebook.nifty.core.ThriftServerDef;
import com.facebook.nifty.core.ThriftServerDefBuilder;
import generated.PersonService;
import org.apache.thrift.TProcessor;

/**
 * @author hewentao
 * @date 2018/7/30 下午2:59
 */
public class NiftyServer {
    public static void main(String[] args) {
        PersonService.Iface serviceInterface = new PersonServiceImpl();
        TProcessor processor = new PersonService.Processor<>(serviceInterface);
        ThriftServerDef serverDef = new ThriftServerDefBuilder().listen(8899).withProcessor(processor).build();
        final NettyServerTransport server = new NettyServerTransport(serverDef);

        server.start();


        System.out.println("服务器启动成功...");
    }
}
