podTemplate(label: 'java',
        containers: [
                containerTemplate(name: 'selenium-chrome', image: 'markhobson/maven-chrome:latest', ttyEnabled: true, command: 'cat')
        ]) {
    node("java"){
        checkout scm
        container("selenium-chrome") {
            stage('Test') {
                sh './gradlew test --tests *TradeMeTest --stacktrace'
            }
        }
    }
}
