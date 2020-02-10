podTemplate(label: 'java',
        containers: [
                containerTemplate(name: 'chrome', image: 'openjdk:8-jdk', ttyEnabled: true, command: 'cat')
                containerTemplate(name: 'selenium-chrome', image: 'markhobson/maven-chrome:latest', ttyEnabled: true, command: 'cat')
        ]) {
    node("java"){
        checkout scm
        container("selenium-chrome") {
            stage('Test') {
                sh './gradlew test'
            }
        }
    }
}
