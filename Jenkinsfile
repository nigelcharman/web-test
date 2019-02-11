podTemplate(label: 'java',
        containers: [
                containerTemplate(name: 'jdk8', image: 'openjdk:8-jdk', ttyEnabled: true, command: 'cat')
        ]) {
    node("java"){
        checkout scm
        container("jdk8") {
            stage('Test') {
                sh './gradlew test'
            }
        }
    }
}
