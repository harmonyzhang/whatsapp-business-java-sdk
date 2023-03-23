package com.whatsapp.api.domain.phone;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.whatsapp.api.domain.phone.type.NameStatusType;
import com.whatsapp.api.domain.phone.type.QualityRatingType;
import lombok.Data;

/**
 * The type Phone number.
 */
@Data
@JsonInclude(value = Include.NON_NULL)
public class PhoneNumber {

    @JsonProperty("display_phone_number") String displayPhoneNumber;

    @JsonProperty("quality_rating") QualityRatingType qualityRating;

    @JsonProperty("verified_name") String verifiedName;

    @JsonProperty("id") String id;

    @JsonProperty("code_verification_status") String codeVerificationStatus;

    @JsonProperty("name_status") NameStatusType nameStatus;
}