package one.piotrowski.dsbgrader;

import nl.tudelft.labracore.api.dto.RoleSummaryDTO;

public class Feedback {
    final public Long submissionId;

    final public Long scriptId;

    final public RoleSummaryDTO.TypeEnum visibleFor;

    final public String textualFeedback;

    final public Integer score;

    final public String key;

    final public Boolean success;

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
