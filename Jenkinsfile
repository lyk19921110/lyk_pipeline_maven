pipeline {
    agent any

    stages {
        stage('pull form git') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/${branch}']], extensions: [], userRemoteConfigs: [[credentialsId: 'ca617273-88f2-44c0-9bed-63ea9ac93fa8', url: 'git@github.com:lyk19921110/lyk_pipeline_maven.git']]])
            }
        }

        stage('build project by maven') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('publish project to test enviroment') {
            steps {
                sshPublisher(publishers: [sshPublisherDesc(configName: 'VM-16-13-centos', transfers: [sshTransfer(cleanRemote: false, excludes: '', execCommand: '''source /etc/profile
/opt/test_jar_shell/lyk_pipeline_shell.sh''', execTimeout: 120000, flatten: false, makeEmptyDirs: false, noDefaultExcludes: false, patternSeparator: '[, ]+', remoteDirectory: '/opt/test_jar', remoteDirectorySDF: false, removePrefix: 'target', sourceFiles: 'target/lyk_pipeline_maven-0.0.1-SNAPSHOT.jar')], usePromotionTimestamp: false, useWorkspaceInPromotion: false, verbose: false)])
            }
        }


    }
}
