#!/usr/bin/env groovy

def call(string $imageName) {
    echo "building docker image..."
    withCredentials ([usernamePassword(credentialsId:'dockerhub',usernameVariable: 'USER',passwordVariable:'PASS')]) {
        sh "docker build -t $imageName ."
        sh 'echo $PASS | docker login -u $USER --password-stdin'
        sh "docker push $imageName"
    }
}