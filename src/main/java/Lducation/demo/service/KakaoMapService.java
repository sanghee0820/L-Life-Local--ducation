package Lducation.demo.service;

import Lducation.demo.configure.KakaoMapConfig;
import java.util.HashMap;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
@Slf4j
public class KakaoMapService {

    private final KakaoMapConfig kakaoMapConfig;

    public HashMap<String, Object> getPosition(String latitude, String longitude) {

        WebClient webClient = WebClient.create(kakaoMapConfig.getAPI_URL());
        HashMap<String, Object> data = webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/geo/coord2regioncode")
                        .queryParam("x", latitude)
                        .queryParam("y", longitude)
                        .build())
                .header("Authorization", "KakaoAK " + kakaoMapConfig.getSECRET_KEY())
                .retrieve()
                .bodyToMono(HashMap.class)
                .block();

        log.info(String.valueOf(data));
        return data;
    }
}
