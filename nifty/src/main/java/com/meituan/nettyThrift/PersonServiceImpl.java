package com.meituan.nettyThrift;

import generated.DataException;
import generated.Person;
import generated.PersonService;
import org.apache.thrift.TException;


/**
 * @author hewentao
 * @date 2018/7/29 上午11:31
 */
public class PersonServiceImpl implements PersonService.Iface {
    @Override
    public Person getPersonByUsername(String username) throws DataException, TException {
        System.out.println("get Client param : " + username);
        Person person = new Person();
        person.setUsername(username);
        person.setAge(20);
        person.setMarried(false);
        return person;
    }

    @Override
    public void savePerson(Person person) throws DataException, TException {
        System.out.println("get Client param : " );
        System.out.println(person.getUsername());
        System.out.println(person.getAge());
        System.out.println(person.isMarried());
    }
}
