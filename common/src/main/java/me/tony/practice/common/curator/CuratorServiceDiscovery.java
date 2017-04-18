package me.tony.practice.common.curator;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryNTimes;

/**
 * Created by tony on 2017/2/9.
 */
public class CuratorServiceDiscovery {
    private CuratorFramework client;

    public CuratorServiceDiscovery() {
        CuratorFrameworkFactory.Builder builder = CuratorFrameworkFactory.builder()
                .connectString("127.0.0.1:2181")
                .retryPolicy(new RetryNTimes(Integer.MAX_VALUE, 1000))
                .connectionTimeoutMs(5000);
        client = builder.build();
    }

    public void start() {
        client.start();
    }
}
