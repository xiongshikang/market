/**

 * 上海谨微数据服务有限公司
 */
package cn.guludai.market.web;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

import cn.guludai.container.web.main.WebApplication;

/**
 * @author gaopeng
 */
@EnableDiscoveryClient
@ComponentScan("cn.guludai.market")
@EnableFeignClients({ "cn.guludai.resource.api", "cn.guludai.app.api" })
public class MarketApplication extends WebApplication {
	public static void main(String[] args) {
		SpringApplication.run(MarketApplication.class, args);
	}
}
 