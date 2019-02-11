podTemplate(label: 'java',
        containers: [
                containerTemplate(name: 'chrome', image: 'resultadosdigitais/google-chrome', ttyEnabled: true, command: 'cat')
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
