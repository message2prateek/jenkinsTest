#!/usr/bin/env groovy

pipeline {
    agent any

    options {
        buildDiscarder(logRotator(numToKeepStr: '5'))
        timeout(time: 1, unit: 'HOURS')
    }

    stages {
        stage('Checkout Code') {
            steps {
                git 'https://github.com/message2prateek/jenkinsTest.git'
            }
        }

        stage('Run unit test') {
            steps {
                sh './gradlew runUnitTests'
            }
            post {
                always {
                    junit allowEmptyResults: true, testResults: 'build/test-results/runUnitTests/*.xml'
                    publishHTML([allowMissing: false, alwaysLinkToLastBuild: false, keepAll: false, reportDir: 'build/reports/tests/runUnitTests', reportFiles: 'index.html', reportName: 'Unit Tests Report', reportTitles: ''])
                }
            }
        }
        stage('Run Acceptance test') {
            steps {
                wrap([$class: 'Xvfb', additionalOptions: '', assignedLabels: '', displayName: 99, displayNameOffset: 0, installationName: 'default Xvfb', timeout: 10]) {
                    sh './gradlew runAcceptanceTests'
                }
                post {
                    always {
                        junit allowEmptyResults: true, testResults: 'build/test-results/runAcceptanceTests/*.xml'
                        publishHTML([allowMissing: false, alwaysLinkToLastBuild: false, keepAll: false, reportDir: 'build/reports/tests/runIntegrationTests', reportFiles: 'index.html', reportName: 'Acceptance Tests Report', reportTitles: ''])
                    }
                }
            }
        }
    }
}