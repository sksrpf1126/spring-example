package backend.retrofit.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class ApiTestController {

    private final ApiTestService apiTestService;

    @GetMapping("/retrofit/test")
    public ApiTestResponse apiTest() throws IOException {
        return apiTestService.apiTest();
    }

}
