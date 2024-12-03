package org.nadiaproject.pinapp.entity;

public class JenkinsFile {
    pipeline {
        agent any

        stages {
            stage('Initialize') {
                steps {
                    echo 'Initializing the Build...'
                }
            }

            stage('Build') {
                steps {
                    script {
                        jules_pipelineRunner {
                            yml = 'jules.yml'  // Ensure your Jules file is correctly referenced here
                        }
                    }
                }
            }

            stage('Test') {
                steps {
                    echo 'Running Unit Tests...'
                    // Assuming you're using Maven for testing
                    sh 'mvn test'
                }
            }

            stage('Deploy to Test Environment') {
                steps {
                    echo 'Deploying to Test Environment...'
                    sh 'cf push -f manifest-jules.yml'  // Adjust for the manifest used for test environment
                }
            }

            stage('Deploy to Production') {
                when {
                    branch 'main'  // Deploy only on the 'main' branch
                }
                steps {
                    echo 'Deploying to Production...'
                    sh 'cf push -f manifest-prod.yml'  // Assuming manifest-prod.yml for prod deployment
                }
            }
        }

        post {
            always {
                cleanWs()  // Clean workspace after the build
            }
            success {
                echo 'Build and Deployment Successful!'
            }
            failure {
                echo 'Build or Deployment Failed!'
            }
        }
    }

}////
