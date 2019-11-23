package org.launchcode.techjobs_oo.Tests;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertNotEquals;

public class JobTest {

    Job job;
    @Before
    public void createClass(){
        job=new Job();

    }
    //Assert each Job object should contain a unique ID number in sequential integers
    @Test
    public void testSettingJobId(){
        Job job1=new Job();
        int id=job1.getId()-job.getId();
        assertEquals(id,1);
    }

    // Test the full constructor sets all fields.
    @Test
    public void testJobConstructorSetsAllFields(){
        Job jobFullConstructor=new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(jobFullConstructor instanceof Job);
    }

    //Test the Equals Method
    @Test
    public void testJobsForEquality(){
        Job job1=new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job2=new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertNotEquals(job1.getId(), job2.getId());
    }
}
