package com.codecool.contributor.service;

import com.codecool.contributor.model.Project;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ProjectStorageTest {

    @Autowired
    private ProjectStorage projectStorage;

    private ArrayList<String> tags = new ArrayList<>();

    private Project testProject;

    @Before
    public void init() {
        tags.add("tag1");
        tags.add("tag2");
        testProject = Project.builder()
                .title("titleTest")
                .shortDesc("shortDescTest")
                .description("DescTest")
                .organisation("OrgTest")
                .requirements("reqTest")
                .build();
        projectStorage.add(testProject);
    }

    @After
    public void clean() {
        projectStorage.remove(testProject.getId());
    }

    @Test
    public void testAddNewProject() {
        Project testProjectForAdd = Project.builder()
                .title("TestProjectForAdd")
                .shortDesc("shortDescTest")
                .description("DescTest")
                .organisation("OrgTest")
                .requirements("reqTest")
                .build();
        projectStorage.add(testProjectForAdd);
        List result = projectStorage.getAll().collect(Collectors.toList());
        assertEquals("Testing project adding.", 4, result.size());
    }

    @Test
    public void findProjectById() {
        Project excepted = testProject;
        Project result = projectStorage.find(testProject.getId());
        assertEquals("Testing project finding by id.", excepted, result);
    }

    @Test
    public void removeProjectById() {
        Project testProjectForRemove = Project.builder()
                .title("TestProjectForRemove")
                .shortDesc("shortDescTest")
                .description("DescTest")
                .organisation("OrgTest")
                .requirements("reqTest")
                .build();
        projectStorage.add(testProjectForRemove);
        projectStorage.remove(testProjectForRemove.getId());
        assertNull("Testing project removing by id.", projectStorage.find(testProjectForRemove.getId()));
    }

    @Test
    public void editOverwritesProject() {
        testProject.setDescription("Edited");
        projectStorage.edit(testProject);

        assertEquals("Testing project overwriting when editing.", "Edited", projectStorage.find(testProject.getId()).getDescription());
    }

}