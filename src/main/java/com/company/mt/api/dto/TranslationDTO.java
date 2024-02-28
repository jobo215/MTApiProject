package com.company.mt.api.dto;

import com.company.mt.api.constants.ErrorMessageConstants;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class TranslationDTO {

    @NotEmpty(message = ErrorMessageConstants.SOURCE_LANGUAGE_EMPTY)
    private String source_language;

    @NotEmpty(message = ErrorMessageConstants.TARGET_LANGUAGE_EMPTY)
    private String target_language;

    @NotEmpty(message = ErrorMessageConstants.DOMAIN_EMPTY)
    private String domain;

    @NotEmpty(message = ErrorMessageConstants.CONTENT_EMPTY)
    private String content;

}
