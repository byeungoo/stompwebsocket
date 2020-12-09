package com.example.messagingstompwebsocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker  //메시지 브로커가 지원하는 WebSocket 메시지 처리를 활성화
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/topic");  //간단한 메모리 기반 메시지 브로커가 topic 접두어가 붙은 대상에서
                                                              //클라이언트로 다시 전달할 수 있게함
        config.setApplicationDestinationPrefixes("/app");  //@MessageMapping으로 주석이 추가 된 메서드에 바인딩 된 메시지의 /app 접두사를 지정
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/gs-guide-websocket").withSockJS();  // / gs-guide-websocket 끝점을 등록하여 WebSocket을
                                                    // 사용할 수없는 경우 대체 전송을 사용할 수 있도록 SockJS 대체 옵션을 활성화합니다.
    }

}
