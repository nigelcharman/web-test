podTemplate(label: 'java',
        containers: [
                containerTemplate(name: 'chrome', image: 'selenoid/chrome', ttyEnabled: true, command: 'cat')
        ]) {
    node("java"){
        checkout scm
        container("chrome") {
            stage('Test') {
                sh './gradlew test'    
            }
        }
    }
}
