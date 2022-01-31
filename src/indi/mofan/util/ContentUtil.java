package indi.mofan.util;

import indi.mofan.bo.ChickenSoupContent;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

/**
 * @author cheny
 * @date 2022/1/31 11:37
 */
public class ContentUtil {

    private final static String DATA_CONTENT = "content";

    /**
     * 调用第三方 API 获取鸡汤内容
     *
     * @return 鸡汤内容
     */
    public static Optional<String> getChickSoupContent() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ChickenSoupContent> entity = restTemplate.getForEntity("https://api.nextrt.com/V1/Dutang", ChickenSoupContent.class);
        if (entity.getStatusCode().is2xxSuccessful()) {
            ChickenSoupContent content = entity.getBody();
            return Optional.ofNullable(content).map(ChickenSoupContent::getData)
                    .flatMap(i -> i.stream().findFirst().map(j -> j.get(DATA_CONTENT)));
        }
        return Optional.empty();
    }
}
