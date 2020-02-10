podTemplate(label: 'java',
        containers: [
                containerTemplate(name: 'java', image: 'openjdk:8-jdk', ttyEnabled: true, command: 'cat')
        ]) {
    node("java"){
        checkout scm
        container("java") {
            stage('Test') {
                sh './gradlew test --tests *TradeMeTest --stacktrace'
            }
        }
    }
}