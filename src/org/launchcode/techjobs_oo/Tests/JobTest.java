package org.launchcode.techjobs_oo.Tests;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertNotEquals;

public class JobTest {

    Job job,job1;

    @Before
    public void createClass() {
        job = new Job();
        job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    }

    //Assert each Job object should contain a unique ID number in sequential integers
    @Test
    public void testSettingJobId() {
        //Job job3 = new Job();
        int id = job1.getId() - job.getId();
        assertEquals(id, 1);
    }

    // Test the full constructor sets all fields.
    @Test
    public void testJobConstructorSetsAllFields() {
        Job jobFullConstructor = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(jobFullConstructor instanceof Job);
    }

    //Test the Equals Method
    @Test
    public void testJobsForEquality() {
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertNotEquals(job1.getId(), job2.getId());
    }

    //Test for Blank Line in toString method
    @Test
    public void blankLineBeforeAfterJob(){

        String text=job1.toString();
        assertTrue(text.contains("\n"));
    }

    //Assert the string should contain a label for each field, followed by the data stored in that field. Each field should be on its own line.
    @Test
    public void labelForFields(){
        String text=job1.toString();
        assertTrue(text.contains("\n"+"ID: "+job1.getId()+"\nName: "+job1.getName()+"\nEmployer: "+job1.getEmployer()+"\nLocation: "+job1.getLocation()+"\nPosition Type: "+job1.getPositionType()+"\nCore Competency: "+job1.getCoreCompetency()+"\n"));
    }

    //If a field is empty, the method should add, “Data not available” after the label.
    @Test
    public void fieldEmptyDataNotAvailable(){
        Job dataNotAvailableJob = new Job("", new Employer(), new Location("California"), new PositionType("Web Developer"), new CoreCompetency());
        String text=dataNotAvailableJob.toString();
        assertEquals("Name: Data not available","Name: "+dataNotAvailableJob.getName());
        assertEquals("Employer: Data not available","Employer: "+dataNotAvailableJob.getEmployer());
        assertEquals("Location: California", "Location: "+dataNotAvailableJob.getLocation());
        assertEquals("Position Type: Web Developer","Position Type: "+dataNotAvailableJob.getPositionType());
        assertEquals("Core Competency: Data not available","Core Competency: "+dataNotAvailableJob.getCoreCompetency());
        assertTrue(text.contains("\nID: "+dataNotAvailableJob.getId()+"\nName: Data not available"+"\nEmployer: Data not available"+"\nLocation: California"+"\nPosition Type: Web Developer"+"\nCore Competency: Data not available"));
    }

    //If a Job object ONLY contains data for the id field, the method should return, “OOPS! This job does not seem to exist.”
    @Test
    public void dataContainsOnlyID(){
        Job emptyData=new Job("",new Employer(),new Location(),new PositionType(),new CoreCompetency());
        String text=emptyData.toString();
        assertEquals("OOPS! This job does not seem to exist",text);
    }
}


