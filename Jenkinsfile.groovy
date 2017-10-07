#!/usr/bin/env groovy

pipeline {
    agent any
    stages {
        stage('Pull Code') {
            steps {
                git 'https://github.com/message2prateek/jenkinsTest.git'
            }
        }

        stage('Run unit test') {
            steps {
                sh './gradlew runUnitTests'
                publishHTML([allowMissing: false, alwaysLinkToLastBuild: false, keepAll: false, reportDir: 'build/reports/tests/runUnitTests', reportFiles: 'index.html', reportName: 'Unit Tests Report', reportTitles: ''])
            }
        }
        wrap([$class: 'Xvfb', additionalOptions: '', assignedLabels: '', displayName: 99, displayNameOffset: 0, installationName: 'default Xvfb', timeout: 10]) {
            stage('Run integration test') {
                steps {
                    sh './gradlew runIntegrationTests'
                    publishHTML([allowMissing: false, alwaysLinkToLastBuild: false, keepAll: false, reportDir: 'build/reports/tests/runIntegrationTests', reportFiles: 'index.html', reportName: 'Integration Tests Report', reportTitles: ''])
                }
            }
        }
    }
}