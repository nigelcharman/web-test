podTemplate(label: 'java',
        containers: [
                containerTemplate(name: 'chrome', image: 'selenium/standalone-chrome', ttyEnabled: true, command: 'cat')
        ]) {
    node("java"){
        checkout scm
        container("chrome") {
            stage('Test') {
                sh './gradlew cucumber'
            }
        }
    }
}
