package studio.aroundhub.application.controller;

import org.springframework.web.bind.annotation.*;
import studio.aroundhub.application.dto.AccountDTO;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/hello-rest/get-api")
public class GetController {

    @GetMapping("/path-variable/basic/{variable}")
    public String pathVariableBasic(@PathVariable String variable) {
        // uri에 중괄호로 변수를 받아 활용할 수 있는 PathVariable

        return "variable is " + variable;
    }

    @GetMapping("/path-variable/naming/{variable}")
    public String pathVariableNaming(@PathVariable("variable") String keyword) {
        // uri와 메서드 양쪽에서 별개의 이름을 가져야, 명료해질 수도 있다 (네이밍컨벤션 등)

        return "variable is " + keyword;
    }

    @GetMapping("/request-param/basic")
    public String getRequestParam(
            @RequestParam String owner,
            @RequestParam String accountCode,
            @RequestParam String password) {
        // RequestParam - 모든 파라미터를 정확히 넘겨받는 경우

        StringBuilder sb = new StringBuilder();

        sb.append("Account info\n");
        sb.append("owner name : " + owner + "\n");
        sb.append("account code : " + accountCode + "\n");
        sb.append("password : " + password);

        return sb.toString();
    }

    @GetMapping("/request-param/unknown")
    public String requestParamUnknown(@RequestParam Map<String, String> params) {
        // RequestParam - 어떤 파라미터를 받는지 모르는 경우 Map 형태로 다룰수 있는 방법
        // http://localhost:8080/hello-rest/get-api/request-param/unknown?owner=aaa&accountCode=1002541&password=9157

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

    @GetMapping("/request-param/dto")
    public String requestParamDto(AccountDTO accountDTO) {
        // RequestParam - DTO 인스턴스단위로 입력을 처리하고 싶은 경우

        return accountDTO.toString();
    }
}
