package com.sgenlecroyant.gomicroservices.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@Component
public class CustomGlobalFiler {

//	@Override
//	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//		ServerHttpRequest request = exchange.getRequest();
////		request.
//		return null;
//	}

}
