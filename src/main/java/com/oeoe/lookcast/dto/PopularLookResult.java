package com.oeoe.lookcast.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.List;

public record PopularLookResult(
    @NotBlank(message = "성별은 필수값 입니다") String gender,
    @NotBlank(message = "주소는 필수값 입니다") String location,
    @NotNull(message = "코디조합은 필수값 입니다") List<String> code
) {}
