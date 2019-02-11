podTemplate(label: 'java',
        containers: [
                containerTemplate(name: 'chrome', image: 'selenium/standalone-chrome:3.14', ttyEnabled: true, command: 'cat')
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
