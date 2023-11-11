package Lducation.demo.course.service;

import Lducation.demo.course.configure.KakaoMapConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
@Slf4j
public class KakaoMapService {
    private final KakaoMapConfig kakaoMapConfig;

    public String getPosition(String latitude, String longitude) {
        HashMap<String, Object> data = this.callKakaoMapAPI(latitude, longitude);

        try {
            LinkedHashMap responseData = ((LinkedHashMap) ((ArrayList) data.get("documents")).get(0));
            log.info(String.valueOf(responseData.get("region_2depth_name")));
            return String.valueOf(responseData.get("region_2depth_name"));
        } catch (Exception e) {
            log.info(e.getMessage());
            return null;
        }
    }

    private HashMap callKakaoMapAPI(String latitude, String longitude) {

        WebClient webClient = WebClient.create(kakaoMapConfig.getAPI_URL());

        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/geo/coord2regioncode")
                        .queryParam("x", latitude)
                        .queryParam("y", longitude)
                        .build())
                .header("Authorization", "KakaoAK " + kakaoMapConfig.getSECRET_KEY())
                .retrieve()
                .bodyToMono(HashMap.class)
                .block();
    }
}
