package com.oeoe.lookcast.dto;

import java.util.List;

public record PopularLookResult(
    String gender,
    String location,
    List<String> code
) {}
