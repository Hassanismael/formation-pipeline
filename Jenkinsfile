pipeline {
    agent any

    stages {
        stage('Connect to github') {
            steps {
                git(
                    url: "https://github.com/Hassanismael/formation-pipeline",
                    branch: "main"

                )

            }

        }
        stage('Build Artifact') {
            steps {
                sh 'mvn clean package -DskipTests=true'
            }

        }
        stage('Run Tests') {
            steps {
                sh 'mvn  test'
            }

        }
          stage('Build and push image') {
            steps {
                withDockerRegistry([credentialsId: "ha-docker-hub", url: ""]) {
                    sh 'docker build -t hadegoke/demo-boot:$BUILD_NUMBER .'
                    sh 'docker push hadegoke/demo-boot:$BUILD_NUMBER'
                }
            }

        }
          stage('Deploy') {
            when { expression { false } }
            steps {
                sh 'docker stop demo-boot || true'
                sh 'docker rm demo-boot || true'
                sh 'docker run -d -p 8180:8180 --name demo-boot demo-boot-pip:v1'
            }

        }
    }
}
