package com.codecool.contributor.controller;

import com.codecool.contributor.model.Project;
import com.codecool.contributor.service.ProjectStorage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.stream.Stream;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@WebMvcTest(value=ProjectController.class,secure = false)
public class ProjectControllerTest {
    private String URI;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProjectStorage projectStorage;


    @Test
    public void projectListTest() throws Exception {
        URI = "/api/projects";
        String body = "Body";

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get(URI)
                .accept(MediaType.TEXT_PLAIN).content(body)
                .contentType(MediaType.TEXT_PLAIN);

        Project testProjectForAdd = Project.builder()
                .title("TestProjectForAdd")
                .shortDesc("shortDescTest")
                .description("DescTest")
                .organisation("OrgTest")
                .requirements("reqTest")
                .build();
        Mockito.when(projectStorage.getAll()).thenReturn(Stream.of(testProjectForAdd));

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();

        verify(projectStorage).getAll();
    }

    @Test
    public void deleteProjectByIdTest() throws Exception {
        URI = "/api/project/1";
        String body = "1";

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .delete(URI)
                .accept(MediaType.TEXT_PLAIN).content(body)
                .contentType(MediaType.TEXT_PLAIN);
        doNothing().when(projectStorage).remove(1);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();

        verify(projectStorage).remove(1);
    }

    @Test
    public void testPut(){

    }

    @Test
    public void addProjectTest() throws Exception {
        URI = "/api/project/add";
        String body = "    {\n" +
                "        \"id\": 1,\n" +
                "        \"name\": \"ProjectCook\",\n" +
                "        \"description\": \"Cook some stuff!\",\n" +
                "        \"shortDesc\": \"cooky\",\n" +
                "        \"organisation\": \"cCompany\",\n" +
                "        \"requirements\": \"Igen\",\n" +
                "        \"tags\": [\n" +
                "            \"tag1\",\n" +
                "            \"tag2\"\n" +
                "        ],\n" +
                "        \"status\": \"OPEN\"\n" +
                "    },";

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post(URI)
                .accept(MediaType.APPLICATION_JSON)
                .content(body)
                .contentType(MediaType.APPLICATION_JSON);

        doNothing().when(projectStorage).add(any(Project.class));

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        verify(projectStorage).add(any(Project.class));
    }


}