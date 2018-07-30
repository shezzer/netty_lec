package com.meituan.nettyThrift;

import generated.Person;
import generated.PersonService;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

/**
 * @author hewentao
 * @date 2018/7/30 下午3:03
 */
public class NiftyClient {
    public static void main(String[] args) throws Exception{
        TTransport transport = new TSocket("localhost",8899);
        transport.open();
        TProtocol protocol = new TBinaryProtocol(transport);
        PersonService.Client client = new PersonService.Client(protocol);

        Person person = client.getPersonByUsername("张三");
        System.out.println(person.getUsername());
        System.out.println(person.getAge());
        System.out.println(person.isMarried());

        System.out.println("-----------");

        Person person1 = new Person();
        person1.setUsername("李四");
        person1.setAge(30);
        person1.setMarried(true);

        client.savePerson(person1);

        transport.close();
    }
}
