package studio.aroundhub.application.controller;

import org.springframework.web.bind.annotation.*;
import studio.aroundhub.application.dto.AccountDTO;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/hello-rest/post-api")
public class PostController {

    @PostMapping("/hello")
    public String postHello() {
        // GET request와 마찬가지로
        // 아무 input이 없어도 원하는 동작을 지정할수 있는 첫단계
        // body를 활용하지않는다는건 사실상 POST를 사용할 의미가 없는것

        return "Hello Post Api";
    }

    @PostMapping("/request-body/basic")
    public String requestBodyBasic(@RequestBody Map<String, String> params) {
        // RequestBody - uri에서 파라미터를 받는게 아니라 POST니까 body에서 내용을받아 처리

        final String unknown = "UNKNOWN";
        Map<String, String> accountInfo = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        accountInfo.put("owner", unknown);
        accountInfo.put("accountCode", unknown);
        accountInfo.put("password", unknown);

        for (String paramKey : params.keySet()) {
            for (String infoKey : accountInfo.keySet()) {
                if (infoKey.equals(paramKey)) {
                    accountInfo.put(infoKey, params.get(paramKey));
                }
            }
        }

        sb.append("Account info\n");
        sb.append("owner name : " + accountInfo.get("owner") + "\n");
        sb.append("account code : " + accountInfo.get("accountCode") + "\n");
        sb.append("password : " + accountInfo.get("password"));

        return sb.toString();
    }

    @PostMapping("/request-body/dto")
    public String requestBodyDto(@RequestBody AccountDTO accountDTO) {
        // RequestBody - 마찬가지로 body에 받은 입력을 dto 통해 처리 가능

        return accountDTO.toString();
    }
}
