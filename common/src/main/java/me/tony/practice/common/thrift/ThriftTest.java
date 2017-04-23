package me.tony.practice.common.thrift;

import me.tony.practice.common.Base;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.*;
import org.junit.Test;

import java.util.List;

/**
 * Created by tony on 2017/1/31.
 */
public class ThriftTest extends Base {

    public static final int PORT = 8008;

    @Test
    public void serve() throws TTransportException {
        TServerTransport serverTransport = new TServerSocket(PORT);
        TServer.Args args = new TServer.Args(serverTransport);
        args.processor(new UserService.Processor<UserService.Iface>(new UserServiceImpl()));
        TServer server = new TSimpleServer(args);
        logger.info("Thrift Server Start");
        server.serve();
    }

    @Test
    public void client() throws TException {
        TTransport transport = new TSocket("127.0.0.1", PORT);
        TProtocol protocol = new TBinaryProtocol(transport);
        UserService.Client client = new UserService.Client(protocol);
        transport.open();
        User user = client.findByUsercode("1001");
        logger.info("method:{}, result: user-{}-{}", "findByUsercode", user.getUsercode(), user.getName());
        List<User> list = client.findByName("Jim");
        logger.info("method:{}, result: list size is {}", "findByName", list.size());
    }

//    @Test
//    public void asyncServe() throws TTransportException, IOException {
//        TAsyncClientManager clientManager = new TAsyncClientManager();
//        TProtocolFactory protocolFactory = new TCompactProtocol.Factory();
//        TNonblockingTransport transport = new TNonblockingSocket(PORT);
//        TServerTransport serverTransport = new TNonblockingServerSocket(PORT);
//        TServer.Args args = new TServer.Args(serverTransport);
//        args.processor(new UserService.AsyncProcessor<UserService.AsyncIface>(new UserServiceImpl()));
//        TServer server = new TSimpleServer(args);
//        logger.info("Thrift Async Server Start");
//        server.serve();
//    }
//
//    @Test
//    public void asyncClient() {
//        TTransport transport = new TSocket("127.0.0.1", PORT);
//        TProtocol protocol = new TBinaryProtocol(transport);
////        UserService.AsyncClient.Factory factory = new UserService.AsyncClient.Factory();
//        UserService.AsyncClient client = new UserService.AsyncClient(protocol);
//    }

}
