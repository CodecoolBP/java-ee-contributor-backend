package com.codecool.contributor.service.implementation;

import com.codecool.contributor.model.Status;
import com.codecool.contributor.entity.Project;
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
        projectStorageMem.add(new Project("Name1", "Test some stuff!","T S S", "Igen","No requirements", tags));
        projectStorageMem.add(new Project("Name2", "Test more stuff!","T M S", "T M S","No requirements", tags));
    }

    @Test
    public void testAddNewProject() {
        projectStorageMem.add(new Project("Name3", "Test add method","T A M", "Nem","Nope", tags));
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

    @Test
    public void editOverWriteProject() {
        Project projectToEdit = projectStorageMem.find(1);
        ArrayList<String> testTags = new ArrayList<>();
        testTags.add("TestTags");
        projectToEdit.setName("TestName");
        projectToEdit.setDescription("TestDescription");
        projectToEdit.setShortDesc("TestShortDescription");
        projectToEdit.setOrganisation("TestOrganisation");
        projectToEdit.setRequirements("TestRequirements");
        projectToEdit.setTags(testTags);
        projectToEdit.setStatus(Status.INPROGRESS);
        projectStorageMem.edit(projectToEdit);

        assertEquals("Test setName(): ","TestName", projectStorageMem.find(1).getName());
        assertEquals("Test setDescription(): ","TestDescription", projectStorageMem.find(1).getDescription());
        assertEquals("Test setShortDesc(): ","TestShortDescription", projectStorageMem.find(1).getShortDesc());
        assertEquals("Test setOrganisation(): ","TestOrganisation", projectStorageMem.find(1).getOrganisation() );
        assertEquals("Test setRequirements(): ","TestRequirements", projectStorageMem.find(1).getRequirements() );
        assertEquals("Test setTags(): ",testTags, projectStorageMem.find(1).getTags());
        assertEquals("Test setStatus(): ", Status.INPROGRESS, projectStorageMem.find(1).getStatus());
    }

}