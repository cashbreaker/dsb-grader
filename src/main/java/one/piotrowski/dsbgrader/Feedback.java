package one.piotrowski.dsbgrader;

import nl.tudelft.labracore.api.dto.RoleSummaryDTO;

public class Feedback {
    final private Long submissionId;

    final private Long scriptId;

    final private RoleSummaryDTO.TypeEnum visibleFor;

    final private String textualFeedback;

    final private Integer score;

    final private String key;

    final private Boolean success;

    public Feedback(Long submissionId, Long scriptId, String textualFeedback, Integer score, String key, Boolean success) {
        this.submissionId = submissionId;
        this.scriptId = scriptId;
        this.visibleFor = RoleSummaryDTO.TypeEnum.STUDENT;
        this.textualFeedback = textualFeedback;
        this.score = score;
        this.key = key;
        this.success = success;
    }
}
