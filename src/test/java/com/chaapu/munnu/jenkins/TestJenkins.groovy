package com.chaapu.munnu.jenkins

import com.lesfurets.jenkins.unit.BasePipelineTest
import com.lesfurets.jenkins.unit.PipelineTestHelper
import org.junit.Before
import org.junit.Test

class TestJenkins extends BasePipelineTest {

    @Override
    @Before
    void setUp() throws Exception {
//        helper.baseScriptRoot = 'jenkinsTest'
//        helper.scriptRoots += 'jenkinsTest'
//        helper.scriptExtension = 'groovy'
        super.setUp()
        helper.registerAllowedMethod("git", [String], {c -> c.toString()})

//         Assigns false to a job parameter ENABLE_TEST_STAGE
//        binding.setVariable('ENABLE_TEST_STAGE', 'false')
        // Defines the previous execution status
//        binding.getVariable('currentBuild').previousBuild = [result: 'UNSTABLE']
    }

    @Test
    void should_execute_without_errors() throws Exception {
        def script = loadScript("src/test/java/com/chaapu/munnu/jenkins/Jenkinsfile")
        script.execute()
        printCallStack()
    }
}
