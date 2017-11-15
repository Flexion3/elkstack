package com.crauwjo.application.common;

import com.sun.jmx.snmp.defaults.DefaultPaths;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.node.NodeBuilder;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import java.net.InetAddress;

import static org.elasticsearch.node.NodeBuilder.nodeBuilder;


@Configuration
@EnableAutoConfiguration
@EnableElasticsearchRepositories(basePackages = "com.crauwjo.persistence")
public class ElasticsearchConfiguration {


//    @Bean
//    public Client client() throws Exception {
//        System.out.println("-- GOT INTO CLIENT CONFIG --");
//        Settings esSettings = Settings.builder()
//                .put("cluster.name", "jonascluster")
//                .put("http.enabled", "false")
//                .put("path.data", "~/dev/git/elkstack/docker/elasticsearch/data")
//                .put("path.home", "~/dev/git/elkstack/docker/elasticsearch-2.4.6/")
//                .build();
//
//        return TransportClient.builder().settings(esSettings).build()
//                .addTransportAddress(
//                        new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9200))
//                .addTransportAddress(
//                        new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9300));
//    }

//    EXTERNAL ELASTICSEARCH
//    @Bean
//    public ElasticsearchOperations elasticsearchTemplate() throws Exception {
//        return new ElasticsearchTemplate(client());
//    }


    //    EMBEDDED ELASTICSEARCH
    @Bean
    public NodeBuilder nodeBuilder() {
        return new NodeBuilder();
    }

    @Bean
    public ElasticsearchOperations elasticsearchTemplate() {
        System.out.println("-- GOT INTO TEMPLATE --");
        Settings esSettings = Settings.builder()
                .put("cluster.name", "jonascluster")
                .put("http.enabled", "false")
                .put("path.data", "~/dev/git/elkstack/docker/elasticsearch/data")
                .put("path.home", "~/dev/git/elkstack/docker/elasticsearch-2.4.6/")
                .build();

        return new ElasticsearchTemplate(nodeBuilder().local(true).settings(esSettings).node().client());
    }

}
