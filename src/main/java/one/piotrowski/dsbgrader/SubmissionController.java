package one.piotrowski.dsbgrader;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/submission")
public class SubmissionController {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @GetMapping("/test")
    public void test() {
        System.out.println("request detected");
    }

//    @PostMapping("/upload")
//    public void uploadSubmission(@RequestBody(required = false) Resource file,
//                                 @RequestBody(required = false) Long submissionId,
//                                 @RequestBody(required = false) Long scriptId,
//                                 @RequestBody(required = false) String key,
//                                 @RequestBody(required = false) String url) {
//        System.out.println("Submission received");
//        try {
//            System.out.println(file.getFile().getAbsolutePath());
//            System.out.println(url);
//            System.out.println(submissionId);
//            System.out.println(scriptId);
//            System.out.println(key);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        RestTemplate restTemplate = new RestTemplate();
//        Feedback feedback = new Feedback(submissionId, scriptId, "test Feedback", 10, key, true);
//        restTemplate.postForEntity(url,feedback, Void.class);
//    }

    @RequestMapping(path = "/uploadSubmission", method = RequestMethod.POST, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<Void> uploadSubmission(@RequestPart Resource file,
                                 @RequestPart Long submissionId,
                                 @RequestPart Long scriptId,
                                 @RequestPart String key,
                                 @RequestPart String url) throws JsonProcessingException {
        System.out.println("Submission received");
        //            System.out.println(file.getFile().getAbsolutePath());
        System.out.println(url);
        System.out.println(submissionId);
        System.out.println(scriptId);
        System.out.println(key);

        Feedback feedback = new Feedback(submissionId, scriptId, "test Feedback", 10, key, true);
        System.out.println(objectMapper.writeValueAsString(feedback));
//        RestTemplate restTemplate = new RestTemplate();
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        HttpEntity<String> request = new HttpEntity<>(objectMapper.writeValueAsString(feedback), headers);
//
//        restTemplate.postForEntity(url,request, Void.class);
        return ResponseEntity.ok(null);
    }
}
