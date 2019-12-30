pipelineJob('studentapp-project/TEST-Pipeline') {
  configure { flowdefinition ->
    flowdefinition << delegate.'definition'(class:'org.jenkinsci.plugins.workflow.cps.CpsScmFlowDefinition',plugin:'workflow-cps') {
      'scm'(class:'hudson.plugins.git.GitSCM',plugin:'git') {
        'configVersion'(2)
        'userRemoteConfigs' {
          'hudson.plugins.git.UserRemoteConfig' {
            'url'('https://github.com/cheerlavamsi/jenkins.git')
            
          }
        }

        'branches' {
          'hudson.plugins.git.BranchSpec' {
            'name'('*/master')
          }
        }
      }
      'scriptPath'('jobs/student-proj/proj-ui-test.jenkinsfile')
      'lightweight'(true)
    }
  }
}

// Student App CI-CT-CD
pipelineJob('studentapp-project/Complete-CI-CD-Pipeline') {
  configure { flowdefinition ->
    flowdefinition << delegate.'definition'(class:'org.jenkinsci.plugins.workflow.cps.CpsScmFlowDefinition',plugin:'workflow-cps') {
      'scm'(class:'hudson.plugins.git.GitSCM',plugin:'git') {
        'configVersion'(2)
        'userRemoteConfigs' {
          'hudson.plugins.git.UserRemoteConfig' {
            'url'('https://github.com/cheerlavamsi/jenkins.git')
           
          }
        }

        'branches' {
          'hudson.plugins.git.BranchSpec' {
            'name'('*/master')
          }
        }
      }
      'scriptPath'('jobs/student-proj/proj-ui-complete.jenkinsfile')
      'lightweight'(true)
    }
  }
}

//Student Project Manual RELEASE

pipelineJob('studentapp-project/APP-MANUAL-RELEASE') {
   parameters {
        stringParam('RELEASE_VERSION', '', 'APPLICATION RELEASE VERSION')
    }
  configure { flowdefinition ->
    flowdefinition << delegate.'definition'(class:'org.jenkinsci.plugins.workflow.cps.CpsScmFlowDefinition',plugin:'workflow-cps') {
      'scm'(class:'hudson.plugins.git.GitSCM',plugin:'git') {
        'configVersion'(2)
        'userRemoteConfigs' {
          'hudson.plugins.git.UserRemoteConfig' {
            'url'('https://github.com/cheerlavamsi/jenkins.git')
            'credentialsId'('git')
          }
        }

        'branches' {
          'hudson.plugins.git.BranchSpec' {
            'name'('*/master')
          }
        }
      }
      'scriptPath'('jobs/student-proj/proj-ui-manual-release.jenkinsfile')
      'lightweight'(true)
    }
  }
}

