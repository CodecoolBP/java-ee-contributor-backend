package com.codecool.contributor.service.implementation;

import com.codecool.contributor.model.EnumStatus;
import com.codecool.contributor.model.Project;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class ProjectStorageMemTest {


    ProjectStorageMem projectStorageMem = new ProjectStorageMem();
    ArrayList<String> tags = new ArrayList<>();

    @Before
    public void init() {

        tags.add("tag1");
        tags.add("tag2");
        projectStorageMem.add(new Project("Name1", "Test some stuff!", "Igen", tags, EnumStatus.valueOf("CLOSED")));
        projectStorageMem.add(new Project("Name2", "Test more stiff!", "Nem", tags, EnumStatus.valueOf("OPEN")));
    }

    @Test
    public void testAddNewProject() {
        projectStorageMem.add(new Project("Name3", "Test add method", "Nem", tags, EnumStatus.valueOf("OPEN")));
        List result = projectStorageMem.getAll().collect(Collectors.toList());
        assertEquals("Add new project testing", 3, result.size());
    }

    @Test
    public void findProjectById() {
        List excepted = projectStorageMem.getAll().collect(Collectors.toList());
        Project result = projectStorageMem.find(1);
        assertEquals("Find project by id testing", excepted.get(0), result);
    }

    @Test
    public void removeProjectById() {
        projectStorageMem.find(1);
        projectStorageMem.remove(1);
        assertNull("Remove project by id testing", projectStorageMem.find(1));
    }
}