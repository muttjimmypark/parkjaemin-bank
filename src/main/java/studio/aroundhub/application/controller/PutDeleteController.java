package studio.aroundhub.application.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import studio.aroundhub.application.dto.AccountDTO;

import java.util.*;

@RestController
@RequestMapping("/hello-rest/put-delete-api")
public class PutDeleteController {

    // 레이어드 아키텍처 구성하는 실습때 분리시킬것. 지금은 http메서드별 기능확인용
    Map<String, AccountDTO> accountDTOMap = new HashMap<>();

    @PutMapping("/hello")
    public String putHello() {
        // 마찬가지로 일단 되는지 확인용도로 이거부터 시작

        return "Hello Put Api";
    }

    @PutMapping("/request-body/basic")
    public String requestBodyBasic(@RequestBody Map<String, String> params) {
        // body에서 string parameter로 받는 형식

        AccountDTO accountDTO = new AccountDTO();
        boolean[] flag = new boolean[3];
        Arrays.fill(flag, false);

        for (String key : params.keySet()) {
            if (key.equals("owner") && flag[0] == false) {
                accountDTO.setOwner(params.get("owner"));
                flag[0] = true;
                continue;
            }

            if (key.equals("accountCode") && flag[1] == false) {
                accountDTO.setAccountCode(params.get("accountCode"));
                flag[1] = true;
                continue;
            }

            if (key.equals("password") && flag[2] == false) {
                accountDTO.setPassword(params.get("password"));
                flag[2] = true;
            }
        }

        if (accountDTO.getOwner() != null) {
            accountDTOMap.put(accountDTO.getOwner(), accountDTO);
            return accountDTOMap.toString();
        } else {
            return "Owner name is not filled";
        }
    }

    @PutMapping("/request-body/dto")
    public String requestBodyDto(@RequestBody AccountDTO accountDTO) {
        // body에서 json형태로 dto를 받는 형식

        accountDTOMap.put(accountDTO.getOwner(), accountDTO);
        return accountDTOMap.toString();
    }

    /*
    ResponseEntity
    100번대로만 출력되는 응답들을 개발자가 지정해서 return할수 있는
    스프링프레임워크 클래스
     */
    @PutMapping("/response-entity")
    public ResponseEntity<AccountDTO> responseEntityPut(@RequestBody AccountDTO accountDTO) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(accountDTO);
    }

    /*
    DELETE method는 실질적으로 아래와 같은 경우로만 사용된다고 한다.
     */
    @DeleteMapping("/delete/{variable}")
    public String DeleteVariable(@PathVariable String variable) {
        if (accountDTOMap.containsKey(variable)) {
            accountDTOMap.remove(variable);

            return accountDTOMap.toString();
        }

        return "cannot find " + variable;
    }


}
