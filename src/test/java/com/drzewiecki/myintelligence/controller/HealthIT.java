package com.drzewiecki.myintelligence.controller;

import com.drzewiecki.myintelligence.IntegrationTest;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


public class HealthIT extends IntegrationTest {

    @Test
    void testApplicationStart() {

    }

    @Test
    void testActuatorHealth() throws Exception {
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/actuator/health");

        mvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("{\"status\":\"UP\"}"));
    }
}
