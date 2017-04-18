package me.tony.practice.common.thrift;

import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by tony on 2017/1/31.
 */
public class UserServiceImpl implements UserService.Iface, UserService.AsyncIface {

    private static final HashMap<String, User> datasource = new HashMap<>();

    static {
        datasource.put("1001", new User("Tony", Gender.MALE, "1001", 28));
        datasource.put("1002", new User("Jim", Gender.MALE, "1002", 22));
        datasource.put("1003", new User("Mary", Gender.FEMALE, "1003", 23));
        datasource.put("1004", new User("Jim", Gender.MALE, "1004", 26));
        datasource.put("1005", new User("Lily", Gender.FEMALE, "1005", 18));
        datasource.put("1006", new User("Alex", Gender.MALE, "1006", 33));
        datasource.put("1007", new User("Mike", Gender.MALE, "1007", 27));
        datasource.put("1008", new User("Lucy", Gender.FEMALE, "1008", 40));
        datasource.put("1009", new User("Bill", Gender.MALE, "1009", 31));
    }

    @Override
    public User findByUsercode(String usercode) throws TException {
        if (null == usercode) {
            throw new RuntimeException("usercode is null");
        }
        return datasource.get(usercode);
    }

    @Override
    public boolean exist(String usercode) throws TException {
        if (null == usercode) {
            throw new RuntimeException("usercode is null");
        }
        return datasource.containsKey(usercode);
    }

    @Override
    public List<User> findByName(String name) throws TException {
        if (null == name) {
            throw new RuntimeException("name is null");
        }
        List<User> result = new ArrayList<>();
        for (User user : datasource.values()) {
            if (name.equals(user.getName())) {
                result.add(user);
            }
        }
        return result;
    }

    @Override
    public void findByUsercode(String usercode, AsyncMethodCallback<User> resultHandler) throws TException {
        if (null == usercode) {
            throw new RuntimeException("usercode is null");
        }
        resultHandler.onComplete(findByUsercode(usercode));
    }

    @Override
    public void exist(String usercode, AsyncMethodCallback<Boolean> resultHandler) throws TException {
        if (null == usercode) {
            throw new RuntimeException("usercode is null");
        }
        resultHandler.onComplete(exist(usercode));
    }

    @Override
    public void findByName(String name, AsyncMethodCallback<List<User>> resultHandler) throws TException {
        if (null == name) {
            throw new RuntimeException("name is null");
        }
        resultHandler.onComplete(findByName(name));
    }
}
