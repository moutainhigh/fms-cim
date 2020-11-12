/**
 * Author : chizf
 * Date : 2020年11月12日 下午5:18:10
 * Title : org.fms.cim.client.rpc.config.RpcConfig.java
 *
**/
package org.fms.cim.client.rpc.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.riozenc.titanTool.spring.web.client.TitanTemplate;

@Configuration
public class RpcConfig {
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean
	public TitanTemplate titanTemplate(RestTemplate restTemplate) {
		return new TitanTemplate(restTemplate);

	}
}
