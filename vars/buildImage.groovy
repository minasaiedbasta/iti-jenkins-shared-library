#!/usr/bin/env groovy

def call() {
    echo "building docker image..."
    withCredentials ([usernamePassword(credentialsId:'dockerhub',usernameVariable: 'USER',passwordVariable:'PASS')]) {
        sh 'docker build -t minasaiedbasta/demo-maven-app:jma-2.0 .'
        sh 'echo $PASS | docker login -u $USER --password-stdin'
        sh 'docker push minasaiedbasta/demo-maven-app:jma-2.0'
    }
}