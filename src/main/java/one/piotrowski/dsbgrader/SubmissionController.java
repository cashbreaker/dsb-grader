package one.piotrowski.dsbgrader;

import java.io.IOException;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/submission")
public class SubmissionController {
    @GetMapping("/test")
    public void test() {
        System.out.println("request detected");
    }

    @GetMapping("/upload")
    public void uploadSubmission(@RequestBody Resource file,
                                 @RequestBody Long submissionId,
                                 @RequestBody Long scriptId,
                                 @RequestBody String key,
                                 @RequestBody String url) {
        try {
            System.out.println(file.getFile().getAbsolutePath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        RestTemplate restTemplate = new RestTemplate();
        Feedback feedback = new Feedback(submissionId, scriptId, "test Feedback", 10, key, true);
        restTemplate.postForEntity(url,feedback, Void.class);
    }
}
